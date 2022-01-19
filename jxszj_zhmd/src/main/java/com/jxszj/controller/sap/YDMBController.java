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
		try {
			// 简道云      M3月度目标维护
			String ENTRYID = "609a4176637de90009c21f63";
		 	String APPID = "5cc110c3b3c41744aaa12b2e";
			String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
			//门店数据
			String mdsj = "61d67ee8ffdf9d00080a0946";
			JDYAPIUtils api = new JDYAPIUtils(APPID, mdsj, APIKEY);
			final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
			String[] str=new String[2];
			str[0]="null";
			str[1]=DateUtils.getLastDay(DateUtils.getNowDateToString(),DateUtils.FORMAT_1_STRING);
			Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
			map1.put("field", "_widget_1641447146029");
			map1.put("type", "text");
			map1.put("method", "range");
			map1.put("value",str);
			condList0.add(map1);
			Map<String, Object> filter0 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList0);
				}
			};
			List<Map<String, Object>> formData0 = api.getAllFormData(null,filter0);
			Set<String> set=new HashSet<>();
			for (int i = 0; i < formData0.size(); i++) {
				set.add(formData0.get(i).get("_widget_1641447146001").toString());
			}
			Map<String,Integer> jxsmd=new HashMap<>();
			for(String jxsbm:set){
				int num=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(jxsbm.equals(formData0.get(i).get("_widget_1641447146001").toString())){
						num++;
					}
				}
				jxsmd.put(jxsbm, num);
			}
			//开户申请
			String khsq = "5d102d3721443528346561db";
			api = new JDYAPIUtils(APPID, khsq, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1548316175994");//使用标识：启用
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", "启用");
			condList1.add(map0);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList1);
				}
			};
			formData0 = api.getAllFormData(null,filter1);
			
			
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
			map1 = new HashMap<String, Object>();
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
			api = new JDYAPIUtils(APPID, C4_ENTRYID, APIKEY);
			List<Map<String, Object>> list_c4=api.getAllFormData(null, filter);
			set=new HashSet<>();
			for(int i=0;i<list_c4.size();i++){
				set.add(list_c4.get(i).get("_widget_1627886455604").toString());
			}
			
			Map<String,Integer> hdmbs=new HashMap<>();
			for(String jxs:set){
				int hdmb=0;
				for (int i = 0; i < list_c4.size(); i++) {
					if(jxs.equals(list_c4.get(i).get("_widget_1627886455604").toString())){
						hdmb+=ObjectUtils.getObjectToInteger(list_c4.get(i).get("_widget_1637561573517"));
					}
				}
				hdmbs.put(jxs, hdmb);
			}
			api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
			for (int i = 0; i < formData0.size(); i++) {
				Map<String, Object> rawData = new HashMap<String, Object>();
				Map<String, Object> m2 = new HashMap<String, Object>();
				m2.put("value", formData0.get(i).get("_widget_1545377155914"));
				rawData.put("_widget_1620722144561", m2);// 品牌编码
				Map<String, Object> m3 = new HashMap<String, Object>();
				m3.put("value", formData0.get(i).get("_widget_1586139868538"));
				rawData.put("_widget_1620722144563", m3);// SAP经销商编码
				Map<String, Object> m4 = new HashMap<String, Object>();
				m4.put("value", formData0.get(i).get("_widget_1543814801964"));
				rawData.put("_widget_1620722144565", m4);// 经销商编码
				Map<String, Object> m5 = new HashMap<String, Object>();
				m5.put("value", formData0.get(i).get("_widget_1543814802008"));
				rawData.put("_widget_1620722144567", m5);// 经销商名称
				Map<String, Object> m6 = new HashMap<String, Object>();
				m6.put("value", formData0.get(i).get("_widget_1560762110588"));
				rawData.put("_widget_1635596350104", m6);// 城市等级
				Map<String, Integer> m7 = new HashMap<String, Integer>();
				m7.put("value", jxsmd.get(formData0.get(i).get("_widget_1543814801964"))==null?1:jxsmd.get(formData0.get(i).get("_widget_1543814801964")));
				rawData.put("_widget_1635676052502", m7);// 门店数量
				Map<String, Object> m8 = new HashMap<String, Object>();
				m8.put("value", "启用");
				rawData.put("_widget_1620722144569", m8);//使用标识
				Map<String, Object> m9 = new HashMap<String, Object>();
				m9.put("value", formData0.get(i).get("_widget_1548225231293"));
				rawData.put("_widget_1620722144571", m9);//P01运营员工名称
				Map<String, Object> m10 = new HashMap<String, Object>();
				m10.put("value", formData0.get(i).get("_widget_1548225231565"));
				rawData.put("_widget_1620722144573", m10);//P01运营员工编码
				Map<String, Object> m11 = new HashMap<String, Object>();
				m11.put("value", formData0.get(i).get("_widget_1628164974484"));
				rawData.put("_widget_1628171453005", m11);//P02运营员工名称
				Map<String, Object> m12 = new HashMap<String, Object>();
				m12.put("value", formData0.get(i).get("_widget_1628164974565"));
				rawData.put("_widget_1628171453041", m12);//P02运营员工编码
				Map<String, Integer> m17 = new HashMap<String, Integer>();
				if(formData0.get(i).get("_widget_1560762110588").equals("A")){
					m17.put("value", 100000);
				}else if(formData0.get(i).get("_widget_1560762110588").equals("B")){
					m17.put("value", 80000);
				}else if(formData0.get(i).get("_widget_1560762110588").equals("C")){
					m17.put("value", 60000);
				}
				rawData.put("_widget_1635676052876", m17);//店均月目标
				Map<String, Object> m18 = new HashMap<String, Object>();
				m18.put("value", m17.get("value")*m7.get("value"));
				rawData.put("_widget_1620722145500", m18);//回款月目标
				Map<String, Object> m19 = new HashMap<String, Object>();
				m19.put("value", hdmbs.get(formData0.get(i).get("_widget_1543814801964"))==null?0:hdmbs.get(formData0.get(i).get("_widget_1543814801964")));
				rawData.put("_widget_1637561518698", m19);//活动目标
				api.createData(rawData);
			}
			
			//获取当月每个经销商的月目标值
			List<Map<String, Object>> list=api.getAllFormData(null, null);
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
