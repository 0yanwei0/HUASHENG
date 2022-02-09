package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiReportListRequest;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiV2UserListRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiReportListResponse;
import com.dingtalk.api.response.OapiV2UserListResponse;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.ExcelToImage;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/*
 * 业务排名
 */
public class YwpmQuartz {

	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

  	
	//开店申请
    private static final String KDSQ_ENTRYID = "5d102d3f2144352834656205";
    
   //开店申请
    private static final String YXJSKD_ENTRYID = "5f7c0ba30b8cc700067eca8a";
    
	public void execute() {
		try {
			List<Long> dept_ids=new ArrayList<>();
			dept_ids.add(587993877L);
			dept_ids.add(589119539L);
			JDYAPIUtils kdsq = new JDYAPIUtils(APPID, KDSQ_ENTRYID, APIKEY);
			final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1642494454648");//提交年月
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE1));
			condList0.add(map0);
			Map<String, Object> filter0 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList0);
				}
			};
			List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
			
			
			JDYAPIUtils yxjskd = new JDYAPIUtils(APPID, YXJSKD_ENTRYID, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("field", "_widget_1642501724769");//收款年月
			map1.put("type", "text");
			map1.put("method", "eq");
			map1.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE1));
			condList1.add(map1);
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("field", "_widget_1614645557746");//凭证编号
			map2.put("type", "text");
			map2.put("method", "not_empty");
			condList1.add(map2);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList1);
				}
			};
			List<Map<String, Object>> formData1 = yxjskd.getAllFormData(null,filter1);
			
			Map<String,String> maps=new HashMap<>();
			String bq="";
			String nq="";
			for (int k = 0; k < dept_ids.size(); k++) {
				Map<String,String> users=getYwyg(dept_ids.get(k));
				int totalKds=0;
				double totalMdmj=0.0;
				int totalQys=0;
				int yys=0;
				for (Map.Entry<String,String> map:users.entrySet()) {
					int kds=0;
					double mdmj=0.0;
					int qys=0;
					for (int j = 0; j < formData0.size(); j++) {
						if(map.getValue().equals(formData0.get(j).get("_widget_1566557299905").toString())){
							kds++;
							mdmj+=ObjectUtils.getObjectToDouble(formData0.get(j).get("_widget_1560998924602"));
						}
					}
					for (int j = 0; j < formData1.size(); j++) {
						if(map.getValue().equals(formData1.get(j).get("_widget_1564236770978").toString())){
							qys++;
						}
					}
					int number=getJobLog(map.getKey());
					maps.put(map.getValue(), qys+"/"+number+"/"+kds+"/"+mdmj);
					totalKds+=kds;
					totalMdmj+=mdmj;
					totalQys+=qys;
					yys+=number;
				}
				if(k==0){
					bq=totalQys+"/"+yys+"/"+totalKds+"/"+totalMdmj;
				}else{
					nq=totalQys+"/"+yys+"/"+totalKds+"/"+totalMdmj;
				}
			}
			List<Entry<String, String>> lists=mapSort(maps);
			Map<String,String> map=new HashMap<>();
			map.put("北区", bq);
			map.put("南区", nq);
			List<Entry<String, String>> lists1=mapSort(map);
			lists.add(lists1.get(0));
			lists.add(lists1.get(1));
			
			XSSFWorkbook wb = new XSSFWorkbook();  
			XSSFSheet sheet = wb.createSheet();
			sheet.setColumnWidth(0, 5000);
            sheet.setColumnWidth(1, 2500);
            sheet.setColumnWidth(2, 2500);
            sheet.setColumnWidth(3, 2500);//设置列宽
            sheet.setColumnWidth(4, 2500);//设置列宽
			int rowIndex = 0;
			CellRangeAddress region = new CellRangeAddress(rowIndex, rowIndex, 0, 4);
            sheet.addMergedRegion(region);
            XSSFFont font1 = wb.createFont();
            font1.setFontName("微软雅黑");
            font1.setFontHeightInPoints((short)20);
            font1.setColor(IndexedColors.RED.getIndex());
            font1.setBold(true);//粗体
            
            XSSFCellStyle  style1= wb.createCellStyle();
            style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//背景
            style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style1.setFont(font1);
            style1.setAlignment(HorizontalAlignment.CENTER); // 居中
            
            XSSFFont font2 = wb.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short)20);

            XSSFCellStyle  style2= wb.createCellStyle();
            style2.setFont(font2);
            style2.setAlignment(HorizontalAlignment.CENTER); // 居中
            
            XSSFCellStyle  style3= wb.createCellStyle();
            style3.setFillForegroundColor(IndexedColors.CORAL.getIndex());//背景
            style3.setFont(font1);

            XSSFRow row = sheet.getRow(rowIndex);
			if (null == row) {
				row = sheet.createRow(rowIndex);
			}
			row.setHeight((short)1000);
			XSSFCell cell = row.getCell(0);
			if (null == cell) {
				cell = row.createCell(0);
			}
			cell.setCellValue(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE2)+"拓展战报");
			cell.setCellStyle(style1);
			
			XSSFRow row0 = sheet.getRow(rowIndex+1);
			if (null == row0) {
				row0 = sheet.createRow(rowIndex+1);
			}
			row0.setHeight((short)800);
			XSSFCell cell0 = row0.getCell(0);
			if (null == cell0) {
				cell0 = row0.createCell(0);
			}
			cell0.setCellValue("业务");
			cell0.setCellStyle(style1);
			XSSFCell cell1 = row0.getCell(1);
			if (null == cell1) {
				cell1 = row0.createCell(1);
			}
			cell1.setCellValue("签约");
			cell1.setCellStyle(style1);
			XSSFCell cell2 = row0.getCell(2);
			if (null == cell2) {
				cell2 = row0.createCell(2);
			}
			cell2.setCellValue("邀约");
			cell2.setCellStyle(style1);
			XSSFCell cell3 = row0.getCell(3);
			if (null == cell3) {
				cell3 = row0.createCell(3);
			}
			cell3.setCellValue("开店");
			cell3.setCellStyle(style1);
			XSSFCell cell4 = row0.getCell(4);
			if (null == cell4) {
				cell4 = row0.createCell(4);
			}
			cell4.setCellValue("面积");
			cell4.setCellStyle(style1);
			rowIndex=rowIndex+2;
            for (int i=0; i<lists.size(); i++) {
            	XSSFRow row00 = sheet.getRow(rowIndex);
				if (null == row00) {
					row00 = sheet.createRow(rowIndex);
				}
				row00.setHeight((short)600);
				XSSFCell cell00 = row00.getCell(0);
				if (null == cell00) {
					cell00 = row00.createCell(0);
				}
				cell00.setCellValue(lists.get(i).getKey());
				cell00.setCellStyle(style2);
				if(lists.get(i).getKey().equals("北区") || lists.get(i).getKey().equals("南区")){
					cell00.setCellStyle(style3);
				}
				XSSFCell cell11 = row00.getCell(1);
				if (null == cell11) {
					cell11 = row00.createCell(1);
				}
				cell11.setCellValue(lists.get(i).getValue().split("/")[0]);
				cell11.setCellStyle(style2);
				if(lists.get(i).getKey().equals("北区") || lists.get(i).getKey().equals("南区")){
					cell11.setCellStyle(style3);
				}
				XSSFCell cell22 = row00.getCell(2);
				if (null == cell22) {
					cell22 = row00.createCell(2);
				}
				cell22.setCellValue(lists.get(i).getValue().split("/")[1]);
				cell22.setCellStyle(style2);
				if(lists.get(i).getKey().equals("北区") || lists.get(i).getKey().equals("南区")){
					cell22.setCellStyle(style3);
				}
				XSSFCell cell23 = row00.getCell(3);
				if (null == cell23) {
					cell23 = row00.createCell(3);
				}
				cell23.setCellValue(lists.get(i).getValue().split("/")[2]);
				cell23.setCellStyle(style2);
				if(lists.get(i).getKey().equals("北区") || lists.get(i).getKey().equals("南区")){
					cell23.setCellStyle(style3);
				}
				XSSFCell cell24 = row00.getCell(4);
				if (null == cell24) {
					cell24 = row00.createCell(4);
				}
				cell24.setCellValue(lists.get(i).getValue().split("/")[3]);
				cell24.setCellStyle(style2);
				if(lists.get(i).getKey().equals("北区") || lists.get(i).getKey().equals("南区")){
					cell24.setCellStyle(style3);
				}
				rowIndex++;
            }
			
			String imagesName=DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER)+"tzzb.jpg";
			ExcelToImage.generatePic(wb,imagesName);
	        
	        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=8a7613157b05ee243146cbc857deaa530d10867602fe5c7719ca321edef6dbd8");
    		OapiRobotSendRequest request = new OapiRobotSendRequest();
    		request.setMsgtype("actionCard");
    		Actioncard actioncard=new Actioncard();
    		actioncard.setTitle(DateUtils.getNowDateToString() + "拓展战报");
    		
    		actioncard.setText("![screenshot](http://www.huasheng999.com/downloadImages?imageName="+imagesName+")");
    		request.setActionCard(actioncard);
    		client.execute(request);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//获取业务员工
	public static Map<String,String> getYwyg(long dept_id){
		Map<String,String> users=new HashMap<>();
		try {
			//获取运用token
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
			OapiGettokenRequest req = new OapiGettokenRequest(); 
			req.setAppkey("dingmyhdkz9wjl10xdiw"); //华生大家居的考勤  
			req.setAppsecret("okdg_dn13xYt5a-qAvFvYxNLXMUgksqeZfretP52IcSTY5QRlzYZqTzHcUQHW2wn");
			req.setHttpMethod("GET");
			OapiGettokenResponse rsp = client.execute(req);
			String token=JSONObject.parseObject(rsp.getBody()).getString("access_token");
			
			client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
			OapiV2UserListRequest req1 = new OapiV2UserListRequest();
			req1.setDeptId(dept_id); //拓展部
			req1.setCursor(0L);
			req1.setSize(100L);
			OapiV2UserListResponse rsp1 = client.execute(req1, token);
			JSONArray array=JSONObject.parseObject(rsp1.getBody()).getJSONObject("result").getJSONArray("list");
			for(int i=0;i<array.size();i++){
				users.put(array.getJSONObject(i).getString("userid"), array.getJSONObject(i).getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static int getJobLog(String userid){
		int number=0;
		try {
			//获取运用token
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
			OapiGettokenRequest req = new OapiGettokenRequest(); 
			req.setAppkey("dingmyhdkz9wjl10xdiw"); //华生大家居的考勤  
			req.setAppsecret("okdg_dn13xYt5a-qAvFvYxNLXMUgksqeZfretP52IcSTY5QRlzYZqTzHcUQHW2wn");
			req.setHttpMethod("GET");
			OapiGettokenResponse rsp = client.execute(req);
			String token=JSONObject.parseObject(rsp.getBody()).getString("access_token");
			
			client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/report/list");
			OapiReportListRequest req1 = new OapiReportListRequest();
			req1.setStartTime(DateUtils.DateToTimeStamp(DateUtils.getStringToMonthOneDay(),DateUtils.FORMAT_1_STRING));
			req1.setEndTime(DateUtils.DateToTimeStamp(DateUtils.getNowDateToString(), DateUtils.FORMAT_1_STRING));
			req1.setUserid(userid);
			req1.setCursor(0L);
			req1.setSize(31L);
			OapiReportListResponse rsp1 = client.execute(req1, token);
			JSONArray array=JSONObject.parseObject(rsp1.getBody()).getJSONObject("result").getJSONArray("data_list");
			if(array.size()!=0){
				array=array.getJSONObject(array.size()-1).getJSONArray("contents");
				for (int i = 0; i < array.size(); i++) {
					if(array.getJSONObject(i).getString("key").equals("本月成功邀约客户数累计")){
						number=array.getJSONObject(i).getInteger("value");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
	
	public static List<Map.Entry<String,String>> mapSort(Map<String,String> map){
		//将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o2.getValue().split("/")[0].compareTo(o1.getValue().split("/")[0]);
            }
        });
		return list;
	}
	
    public static String getStr(int length,String str){
    	StringBuilder sb=new StringBuilder();
    	if(length>str.length()){
    		for (int i = 0; i < length-str.length(); i++) {
				sb.append("    ");
			}
    	}
    	return str+sb.toString()+"     ";
    }
}
