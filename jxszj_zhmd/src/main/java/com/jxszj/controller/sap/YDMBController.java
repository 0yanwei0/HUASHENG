package com.jxszj.controller.sap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.pojo.sap.PpxxTb;
import com.jxszj.pojo.sap.YdmbTb;
import com.jxszj.service.sap.IPpxxService;
import com.jxszj.service.sap.IYdmbService;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.MessageResult;
import com.jxszj.utils.ObjectUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/ydmb")
public class YDMBController {
	
	@Autowired
	private IPpxxService ppxxService;
	
	@Autowired
	private IYdmbService ydmbService;
	
	@RequestMapping("/getPp")
	@ResponseBody
	public String getPp(){
		List<PpxxTb> list=ppxxService.getPpxxLists();
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
		
	}
	
	@RequestMapping("/ydmbExport")
	public void ydmbExport(HttpServletRequest request, HttpServletResponse response) {
		// excel模板路径
		//本地：E:/work/jxszj_zhmd/src/main/webapp/WEB-INF/excel/本月目标回款.xlsx
		//生产：/root/opt/jxszj/apache-tomcat-7.0.105/webapps/jxszj_zhmd/WEB-INF/excel/本月目标回款.xlsx
		String excelUrl = "/root/opt/jxszj/apache-tomcat-7.0.105/webapps/jxszj_zhmd/WEB-INF/excel/本月目标回款.xlsx";
		String ppbm=request.getParameter("ppbm");
		String dd=request.getParameter("dd");
		XSSFWorkbook wb = ydmbService.getXSSFWorkbook(excelUrl,ppbm,dd);

		try {
			String fileName = "本月目标回款.xlsx";
			fileName = fileName.replace("-", "");
			response.setHeader("Content-disposition",
					"attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));// 设置文件头编码格式
			response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");// 设置类型
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头
			wb.write(response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/uploadYdmbExcel")
	@ResponseBody
	public MessageResult uploadYdmbExcel(@RequestParam("ydmbExcelFile") MultipartFile ydmbExcelFile,HttpServletRequest request, HttpServletResponse response){
		try {
			if (ydmbExcelFile==null) {
				return MessageResult.build(null,"上传Excel失败,请重试！");
			}
			int num=ydmbService.uploadYdmbExcel(request, response, ydmbExcelFile);
			if(num>0){
				return MessageResult.build(200,"已成功上传"+num+"条数据！");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return MessageResult.build(500,"上传失败！");
	}
	
	
	@RequestMapping("/getYdmb")
	@ResponseBody
	public EUDataGridResult getYdmb(Integer page, Integer rows){
		EUDataGridResult result =ydmbService.getYdmb(page, rows);
		return result;
	}
	
	@RequestMapping("/addYdmbData")
	public void addYdmbData(){
		// 简道云      M3月度目标维护
		String ENTRYID = "609a4176637de90009c21f63";
	 	String APPID = "5cc110c3b3c41744aaa12b2e";
		String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
		
		// 简道云      C4促销活动
		Date currentTime = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy年M月");  
	    String dateString = formatter.format(currentTime); 
		String C4_ENTRYID = "610915165435d900078c22ac";
		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("field", "_widget_1627905992820");
		map.put("type", "text");
		map.put("method", "eq");
		map.put("value", dateString);
		condList.add(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "flowState");
		map1.put("type", "text");
		map1.put("method", "eq");
		map1.put("value", 1);
		condList.add(map1);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};
		JDYAPIUtils api = new JDYAPIUtils(APPID, C4_ENTRYID, APIKEY);
		List<Map<String, Object>> list_c4=api.getAllFormData(null, filter);
		Set<String> set=new HashSet<>();
		for(int i=0;i<list_c4.size();i++){
			set.add(list_c4.get(i).get("_widget_1627886455604").toString());
		}
		api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		for(String jxs:set){
			int hdmb=0;
			for (int i = 0; i < list_c4.size(); i++) {
				if(jxs.equals(list_c4.get(i).get("_widget_1627886455604").toString())){
					hdmb+=ObjectUtils.getObjectToInteger(list_c4.get(i).get("_widget_1637561573517"));
				}
			}
			
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			map = new HashMap<String, Object>();
			map.put("field", "_widget_1620722144565");
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", jxs);
			condList1.add(map);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList1);
				}
			};
			List<Map<String, Object>> list=api.getAllFormData(null, filter1);
			if(list.size()!=1){
				continue;
			}
			Map<String, Object>rawData = new HashMap<String, Object>();
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", hdmb);
			rawData.put("_widget_1637561518698", m0);
			api.updateData(list.get(0).get("_id").toString(), rawData);
		}
		
		
		//获取当月每个经销商的月目标值
		final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
		map = new HashMap<String, Object>();
		map.put("field", "_widget_1620722144569");
		map.put("type", "text");
		map.put("method", "eq");
		map.put("value", "启用");
		condList1.add(map);
		Map<String, Object> filter1 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList1);
			}
		};
		List<Map<String, Object>> list=api.getAllFormData(null, filter1);
		
		List<YdmbTb > ydmbTbs =new ArrayList<YdmbTb>();
		for (int i = 0; i < list.size(); i++) {
			YdmbTb ydmbTb=new YdmbTb();
			ydmbTb.setJxsmc(list.get(i).get("_widget_1620722144567").toString());
			ydmbTb.setJxsbm(list.get(i).get("_widget_1620722144565").toString());
			ydmbTb.setPpbm(list.get(i).get("_widget_1620722144561").toString());
			ydmbTb.setDd(list.get(i).get("_widget_1620722144571").toString());
			ydmbTb.setYyzt(list.get(i).get("_widget_1620722144569").toString());
			ydmbTb.setBymbhk(Double.valueOf(list.get(i).get("_widget_1620722145500").toString()));
			ydmbTb.setDrsj(DateUtils.getNowDateToString());
			ydmbTbs.add(ydmbTb);
		}
		ydmbService.addData(ydmbTbs);
	}

}
