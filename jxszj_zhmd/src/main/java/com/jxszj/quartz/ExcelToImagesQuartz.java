package com.jxszj.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;


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
import org.springframework.stereotype.Controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.jxszj.pojo.Jxspm;
import com.jxszj.utils.ExcelToImage;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;

@Controller
public class ExcelToImagesQuartz {
	
	//销售收款单
	private static final String DF1_ENTRYID = "5d3bc22704614439fd55e71d";
    //3-开店申请
    private static final String KDSQ_ENTRYID = "5d102d3f2144352834656205";
    //门店实时销售提报
    private static final String MDTB_ENTRYID = "5d2d229eee266915714e9e1e";
    
    //C7店长能量月度评分表
    private static final String C7_ENTRYID = "610cf9a301856800079f7cfe";
    
    //Y5运营能力月度评分表
    private static final String Y5_ENTRYID = "6119fe197085790007ab77e5";
    
    
    private static final String APPID = "5cc110c3b3c41744aaa12b2e";
    private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
    
    public static void main(String[] args) {
		new ExcelToImagesQuartz().execute();
	}
    
    public void execute(){
    	tbAndhkPicture();
    	jfPicture();
    	yyjljfPicture();
    }

	
	public void tbAndhkPicture(){
		DecimalFormat df = new DecimalFormat("#,###"); 
		try {
			List<String> pps=new ArrayList<>();
			pps.add("PD");
			pps.add("MS");
			pps.add("HMW");
			List<String> djs=new ArrayList<>();
			djs.add("A");
			djs.add("B");
			djs.add("C");
			Map<String,Double> tbMonth=getTb();
			Map<String,Double> skdMonth=getSkd();
			for(String pp:pps){
				XSSFWorkbook wb = new XSSFWorkbook();  
				XSSFSheet sheet = wb.createSheet();
	            XSSFFont font1 = wb.createFont();
	            font1.setFontName("微软雅黑");
	            font1.setFontHeightInPoints((short)30);
	            font1.setBold(true);//粗体
	            
	            XSSFCellStyle  style1= wb.createCellStyle();
	            style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//背景
	            style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            style1.setFont(font1);
	            style1.setAlignment(HorizontalAlignment.CENTER); // 居中
	            
	            XSSFFont font2 = wb.createFont();
	            font2.setFontName("宋体");
	            font2.setFontHeightInPoints((short)25);

	            XSSFCellStyle  style2= wb.createCellStyle();
	            style2.setFont(font2);
	            style2.setAlignment(HorizontalAlignment.CENTER); // 居中
	            
	            XSSFFont font4 = wb.createFont();
	            font4.setFontName("微软雅黑");
	            font4.setFontHeightInPoints((short)25);
	            font4.setBold(true);//粗体

	            XSSFCellStyle  style4= wb.createCellStyle();
	            style4.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//背景
	            style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            style4.setFont(font4);
	            style4.setAlignment(HorizontalAlignment.CENTER); // 居中
	            
				sheet.setColumnWidth(0, 14000);
	            sheet.setColumnWidth(1, 4500);
	            sheet.setColumnWidth(2, 3000);
	            sheet.setColumnWidth(3, 4500);//设置列宽
	            sheet.setColumnWidth(4, 3000);//设置列宽
				int rowIndex = 0;
				for(String dj:djs){
					List<Map<String, Object>> list=getMd(pp,dj);
					//对当月提报进行排名
					List<Jxspm> jxspms=new ArrayList<>();
					Map<String,String> mdbmmc=new HashMap<>();
					for (int i = 0; i < list.size(); i++) {
						Jxspm jxspm=new Jxspm();
		            	jxspm.setMdbm(list.get(i).get("_widget_1543818219389").toString());
		            	jxspm.setTotal(tbMonth.get(list.get(i).get("_widget_1543818219389").toString())!=null?tbMonth.get(list.get(i).get("_widget_1543818219389").toString()):0);
		            	jxspms.add(jxspm);
		            	mdbmmc.put(list.get(i).get("_widget_1543818219389").toString(), list.get(i).get("_widget_1543818219658").toString());
					}
					LinkedHashMap<String,Integer> tbpm=new LinkedHashMap<>();
		            List<Entry<Double, List<Jxspm>>> total = jxspms.stream()
		                    .collect(Collectors.groupingBy(Jxspm::getTotal))
		                    .entrySet()
		                    .stream()
		                    .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
		                    .collect(Collectors.toList());
		            int index = 1;
		            int num=0;
		            for (Entry<Double, List<Jxspm>> entry : total) {
		            	for (int j = 0; j < entry.getValue().size(); j++) {
		            		tbpm.put(entry.getValue().get(j).getMdbm(), index);
		            		num++;
		    			}
		                index+=num;
		                num=0;
		            }
		            //对当月回款进行排名
		            Map<String,Double> maps=new HashMap<>();//门店所对应的回款
		            jxspms=new ArrayList<>();
					for (int i = 0; i < list.size(); i++) {
						Jxspm jxspm=new Jxspm();
		            	jxspm.setMdbm(list.get(i).get("_widget_1543818219389").toString());
		            	jxspm.setTotal(skdMonth.get(list.get(i).get("_widget_1543981212621").toString())!=null?skdMonth.get(list.get(i).get("_widget_1543981212621").toString()):0);
		            	jxspms.add(jxspm);
		            	maps.put(list.get(i).get("_widget_1543818219389").toString(), jxspm.getTotal());
					}
					LinkedHashMap<String,Integer> hkpm=new LinkedHashMap<>();
		            total = jxspms.stream()
		                    .collect(Collectors.groupingBy(Jxspm::getTotal))
		                    .entrySet()
		                    .stream()
		                    .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
		                    .collect(Collectors.toList());
		            index = 1;
		            num=0;
		            for (Entry<Double, List<Jxspm>> entry : total) {
		            	for (int j = 0; j < entry.getValue().size(); j++) {
		            		hkpm.put(entry.getValue().get(j).getMdbm(), index);
		            		num++;
		    			}
		                index+=num;
		                num=0;
		            }
		            
		            //排序
		            List<Map.Entry<String,Integer>> lists = new ArrayList<Map.Entry<String,Integer>>(hkpm.entrySet());
		            Collections.sort(lists,new Comparator<Map.Entry<String,Integer>>() {
		                //升序排序
		                public int compare(Entry<String, Integer> o1,
		                        Entry<String, Integer> o2) {
		                    return o1.getValue().compareTo(o2.getValue());
		                }
		                 
		            });
		            
		            CellRangeAddress region = new CellRangeAddress(rowIndex, rowIndex, 0, 4);
		            sheet.addMergedRegion(region);
		            
		            XSSFRow row = sheet.getRow(rowIndex);
					if (null == row) {
						row = sheet.createRow(rowIndex);
					}
					row.setHeight((short)1000);
					XSSFCell cell = row.getCell(0);
					if (null == cell) {
						cell = row.createCell(0);
					}
					cell.setCellValue(pp+" "+dj+"级城市当月回款与报单");
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
					cell0.setCellValue("门店名称");
					cell0.setCellStyle(style4);
					XSSFCell cell1 = row0.getCell(1);
					if (null == cell1) {
						cell1 = row0.createCell(1);
					}
					cell1.setCellValue("回款");
					cell1.setCellStyle(style4);
					XSSFCell cell2 = row0.getCell(2);
					if (null == cell2) {
						cell2 = row0.createCell(2);
					}
					cell2.setCellValue("排名");
					cell2.setCellStyle(style4);
					XSSFCell cell3 = row0.getCell(3);
					if (null == cell3) {
						cell3 = row0.createCell(3);
					}
					cell3.setCellValue("报单");
					cell3.setCellStyle(style4);
					XSSFCell cell4 = row0.getCell(4);
					if (null == cell4) {
						cell4 = row0.createCell(4);
					}
					cell4.setCellValue("排名");
					cell4.setCellStyle(style4);
					rowIndex=rowIndex+2;
		            for (Map.Entry<String,Integer> map:lists) {
		            	XSSFRow row00 = sheet.getRow(rowIndex);
						if (null == row00) {
							row00 = sheet.createRow(rowIndex);
						}
						row00.setHeight((short)800);
						XSSFCell cell00 = row00.getCell(0);
						if (null == cell00) {
							cell00 = row00.createCell(0);
						}
						cell00.setCellValue(mdbmmc.get(map.getKey()));
						cell00.setCellStyle(style2);
						XSSFCell cell11 = row00.getCell(1);
						if (null == cell11) {
							cell11 = row00.createCell(1);
						}
						cell11.setCellValue(df.format(maps.get(map.getKey()).intValue()));
						cell11.setCellStyle(style2);
						XSSFCell cell22 = row00.getCell(2);
						if (null == cell22) {
							cell22 = row00.createCell(2);
						}
						cell22.setCellValue(hkpm.get(map.getKey()));
						cell22.setCellStyle(style2);
						XSSFCell cell33 = row00.getCell(3);
						if (null == cell33) {
							cell33 = row00.createCell(3);
						}
						cell33.setCellValue(tbMonth.get(map.getKey())!=null?df.format(tbMonth.get(map.getKey())):"0");
						cell33.setCellStyle(style2);
						XSSFCell cell44 = row00.getCell(4);
						if (null == cell44) {
							cell44 = row00.createCell(4);
						}
						cell44.setCellValue(tbpm.get(map.getKey()));
						cell44.setCellStyle(style2);
						rowIndex++;
		            }
				}
//				FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/aaa.xls");  
//				wb.write(fos);//写文件
//				fos.close(); 
				
				String imagesName=DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER)+"-"+pp+"-hktb.jpg";
				ExcelToImage.generatePic(wb,imagesName);
					
		        
		        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=6835829f3cfae0d3d718f570649eae2d21d32d6fe7c1cc446a43119d38eda873");
	    		OapiRobotSendRequest request = new OapiRobotSendRequest();
	    		request.setMsgtype("actionCard");
	    		Actioncard actioncard=new Actioncard();
	    		actioncard.setTitle("门店回款提报图");
	    		
	    		actioncard.setText("![screenshot](http://www.huasheng999.com/downloadImages?imageName="+imagesName+")");
	    		request.setActionCard(actioncard);
	    		client.execute(request);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void jfPicture(){
		try {
			List<String> pps=new ArrayList<>();
			pps.add("PD");
			pps.add("MS");
			pps.add("HMW");
			List<String> djs=new ArrayList<>();
			djs.add("A");
			djs.add("B");
			djs.add("C");
			
			for(String pp:pps){
				XSSFWorkbook wb = new XSSFWorkbook();  
				XSSFSheet sheet = wb.createSheet();
				sheet.setColumnWidth(0, 11000);
	            sheet.setColumnWidth(1, 4000);
	            sheet.setColumnWidth(2, 4000);
	            sheet.setColumnWidth(3, 4000);//设置列宽
				int rowIndex = 0;
				for(String dj:djs){
					List<Map.Entry<String,Integer>> lists=getJf(pp,dj);
		            
		            CellRangeAddress region = new CellRangeAddress(rowIndex, rowIndex, 0, 3);
		            sheet.addMergedRegion(region);
		            XSSFFont font1 = wb.createFont();
		            font1.setFontName("微软雅黑");
		            font1.setFontHeightInPoints((short)30);
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
		            
		            XSSFFont font3 = wb.createFont();
		            font3.setFontName("宋体");
		            font3.setFontHeightInPoints((short)18);

		            XSSFCellStyle  style3= wb.createCellStyle();
		            style3.setFont(font3);
		            
		            XSSFFont font4 = wb.createFont();
		            font4.setFontName("微软雅黑");
		            font4.setFontHeightInPoints((short)20);
		            font4.setColor(IndexedColors.RED.getIndex());
		            font4.setBold(true);//粗体

		            XSSFCellStyle  style4= wb.createCellStyle();
		            style4.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//背景
		            style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		            style4.setFont(font4);
		            style4.setAlignment(HorizontalAlignment.CENTER); // 居中
		            
		            
		            XSSFRow row = sheet.getRow(rowIndex);
					if (null == row) {
						row = sheet.createRow(rowIndex);
					}
					row.setHeight((short)1000);
					XSSFCell cell = row.getCell(0);
					if (null == cell) {
						cell = row.createCell(0);
					}
					cell.setCellValue(pp+" "+dj+"级城市门店积分");
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
					cell0.setCellValue("门店名称");
					cell0.setCellStyle(style4);
					XSSFCell cell1 = row0.getCell(1);
					if (null == cell1) {
						cell1 = row0.createCell(1);
					}
					cell1.setCellValue("当月总积分");
					cell1.setCellStyle(style4);
					XSSFCell cell2 = row0.getCell(2);
					if (null == cell2) {
						cell2 = row0.createCell(2);
					}
					cell2.setCellValue("当月排名");
					cell2.setCellStyle(style4);
					rowIndex=rowIndex+2;
		            for (Map.Entry<String,Integer> map:lists) {
		            	XSSFRow row00 = sheet.getRow(rowIndex);
						if (null == row00) {
							row00 = sheet.createRow(rowIndex);
						}
						row00.setHeight((short)600);
						XSSFCell cell00 = row00.getCell(0);
						if (null == cell00) {
							cell00 = row00.createCell(0);
						}
						cell00.setCellValue(map.getKey().split("/")[0]);
						cell00.setCellStyle(style3);
						XSSFCell cell11 = row00.getCell(1);
						if (null == cell11) {
							cell11 = row00.createCell(1);
						}
						cell11.setCellValue(map.getKey().split("/")[1]);
						cell11.setCellStyle(style2);
						XSSFCell cell22 = row00.getCell(2);
						if (null == cell22) {
							cell22 = row00.createCell(2);
						}
						cell22.setCellValue(map.getValue());
						cell22.setCellStyle(style2);
						rowIndex++;
		            }
				}
//				FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/aaa.xls");  
//				wb.write(fos);//写文件
//				fos.close(); 
				
				String imagesName=DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER)+"-"+pp+"-jf.jpg";
				ExcelToImage.generatePic(wb,imagesName);
	        
		        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=6835829f3cfae0d3d718f570649eae2d21d32d6fe7c1cc446a43119d38eda873");
	    		OapiRobotSendRequest request = new OapiRobotSendRequest();
	    		request.setMsgtype("actionCard");
	    		Actioncard actioncard=new Actioncard();
	    		actioncard.setTitle("门店积分图");
	    		
	    		actioncard.setText("![screenshot](http://www.huasheng999.com/downloadImages?imageName="+imagesName+")");
	    		request.setActionCard(actioncard);
	    		client.execute(request);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void yyjljfPicture(){
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, Y5_ENTRYID, APIKEY);
	    	final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1627905992820");
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
			condList.add(map0);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};

	        List<Map<String, Object>> formData = api.getAllFormData(null,filter);//获取当天所有的数据
	        Collections.sort(formData, new Comparator<Map<String,Object>>() {
	        	@Override
	        	public int compare(Map<String, Object> o1, Map<String, Object> o2) {
	        	//进行判断
	        		return ((Integer)o1.get("_widget_1628477304402")).compareTo((Integer)o2.get("_widget_1628477304402"));
	        	}
	        });
	        
			XSSFWorkbook wb = new XSSFWorkbook();  
			XSSFSheet sheet = wb.createSheet();
			sheet.setColumnWidth(0, 11000);
            sheet.setColumnWidth(1, 4000);
            sheet.setColumnWidth(2, 4000);
            sheet.setColumnWidth(3, 4000);//设置列宽
			int rowIndex = 0;
			CellRangeAddress region = new CellRangeAddress(rowIndex, rowIndex, 0, 3);
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
            
            XSSFFont font3 = wb.createFont();
            font3.setFontName("宋体");
            font3.setFontHeightInPoints((short)18);

            XSSFCellStyle  style3= wb.createCellStyle();
            style3.setFont(font3);
            
            XSSFFont font4 = wb.createFont();
            font4.setFontName("微软雅黑");
            font4.setFontHeightInPoints((short)20);
            font4.setColor(IndexedColors.RED.getIndex());
            font4.setBold(true);//粗体

            XSSFCellStyle  style4= wb.createCellStyle();
            style4.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());//背景
            style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style4.setFont(font4);
            style4.setAlignment(HorizontalAlignment.CENTER); // 居中
            
            
            XSSFRow row = sheet.getRow(rowIndex);
			if (null == row) {
				row = sheet.createRow(rowIndex);
			}
			row.setHeight((short)1000);
			XSSFCell cell = row.getCell(0);
			if (null == cell) {
				cell = row.createCell(0);
			}
			cell.setCellValue(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE)+"运营经理积分排行榜");
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
			cell0.setCellValue("运营经理");
			cell0.setCellStyle(style4);
			XSSFCell cell1 = row0.getCell(1);
			if (null == cell1) {
				cell1 = row0.createCell(1);
			}
			cell1.setCellValue("当月总积分");
			cell1.setCellStyle(style4);
			XSSFCell cell2 = row0.getCell(2);
			if (null == cell2) {
				cell2 = row0.createCell(2);
			}
			cell2.setCellValue("当月排名");
			cell2.setCellStyle(style4);
			rowIndex=rowIndex+2;
            for (int i=0; i<formData.size(); i++) {
            	XSSFRow row00 = sheet.getRow(rowIndex);
				if (null == row00) {
					row00 = sheet.createRow(rowIndex);
				}
				row00.setHeight((short)600);
				XSSFCell cell00 = row00.getCell(0);
				if (null == cell00) {
					cell00 = row00.createCell(0);
				}
				cell00.setCellValue(formData.get(i).get("_widget_1627886456425").toString());
				cell00.setCellStyle(style3);
				XSSFCell cell11 = row00.getCell(1);
				if (null == cell11) {
					cell11 = row00.createCell(1);
				}
				cell11.setCellValue(formData.get(i).get("_widget_1628477304461").toString());
				cell11.setCellStyle(style2);
				XSSFCell cell22 = row00.getCell(2);
				if (null == cell22) {
					cell22 = row00.createCell(2);
				}
				cell22.setCellValue(formData.get(i).get("_widget_1628477304402").toString());
				cell22.setCellStyle(style2);
				rowIndex++;
            }
//			FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Desktop/aaa.xls");  
//			wb.write(fos);//写文件
//			fos.close(); 
			
			String imagesName=DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER)+"-yyjljf.jpg";
			ExcelToImage.generatePic(wb,imagesName);
	        
	        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=6835829f3cfae0d3d718f570649eae2d21d32d6fe7c1cc446a43119d38eda873");
    		OapiRobotSendRequest request = new OapiRobotSendRequest();
    		request.setMsgtype("actionCard");
    		Actioncard actioncard=new Actioncard();
    		actioncard.setTitle("运营经理积分图");
    		
    		actioncard.setText("![screenshot](http://www.huasheng999.com/downloadImages?imageName="+imagesName+")");
    		request.setActionCard(actioncard);
    		client.execute(request);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> getMd(String pp,String dj){
		//查询营业中的门店
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, KDSQ_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1560998925033");//运营状态
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "营业中");
		condList0.add(map0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "_widget_1543818220013");//品牌编码
		map1.put("type", "text");
		map1.put("method", "eq");
		map1.put("value", pp);
		condList0.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("field", "_widget_1560762247060");//城市等级
		map2.put("type", "text");
		map2.put("method", "eq");
		map2.put("value", dj);
		condList0.add(map2);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		//获取所有营业中的门店
        List<Map<String, Object>> formData = kdsq.getAllFormData(null,filter0);
        return formData;
	}
	
	public Map<String,Double> getSkd(){
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, KDSQ_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("field", "_widget_1560998925033");//运营状态
		map.put("type", "text");
		map.put("method", "eq");
		map.put("value", "营业中");
		condList.add(map);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};
		//获取所有营业中的门店
        List<Map<String, Object>> formData = kdsq.getAllFormData(null,filter);
        Set<String> set=new HashSet<>();
        for (int i = 0; i < formData.size(); i++) {
			set.add(formData.get(i).get("_widget_1543981212621").toString());
		}
        Map<String,Integer> mds=new HashMap<>();
        for(String jxs:set){
        	int number=0;
        	for(int i = 0; i < formData.size(); i++){
        		if(jxs.equals(formData.get(i).get("_widget_1543981212621").toString())){
        			number++;
        		}
        	}
        	mds.put(jxs, number);
        }
		
		//查询当月有回款的的门店
		JDYAPIUtils skd = new JDYAPIUtils(APPID, DF1_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1548049038941");//收款日期
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
		condList0.add(map0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "_widget_1593141119943");//SAP的凭证号
		map1.put("type", "text");
		map1.put("method", "not_empty");
		condList0.add(map1);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		//获取所有营业中的门店
        formData = skd.getAllFormData(null,filter0);
        Set<String> jxs=new HashSet<>();
        for (int i = 0; i < formData.size(); i++) {
			jxs.add(formData.get(i).get("_widget_1548037673508").toString());
		}
        Map<String,Double> maps=new HashMap<>();
        for(String jxsbm:jxs){
        	if(mds.get(jxsbm)==null){
        		continue;
        	}
        	double sk=0;
        	for (int i = 0; i < formData.size(); i++) {
        		if(jxsbm.equals(formData.get(i).get("_widget_1548037673508").toString())){
        			sk+=Double.valueOf(formData.get(i).get("_widget_1564390193051").toString());
        		}
        	}
        	maps.put(jxsbm, sk/mds.get(jxsbm));
        }
        return maps;
	}
	
	public Map<String,Double> getTb(){
		JDYAPIUtils api = new JDYAPIUtils(APPID, MDTB_ENTRYID, APIKEY);
    	final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1563246850783");
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
		condList.add(map0);
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

        List<Map<String, Object>> formData = api.getAllFormData(null,filter);//获取当天所有的数据
        
        //获取当日开单的门店
        Set<String> md=new HashSet<>();
        for (int i = 0; i < formData.size(); i++) {
			md.add(formData.get(i).get("_widget_1563246847900").toString());
		}
        
        Map<String,Double> map=new HashMap<>();
        for(String mdbn:md){
        	double kdje=0;
        	for (int i = 0; i < formData.size(); i++) {
				if(mdbn.equals(formData.get(i).get("_widget_1563246847900").toString())){
					kdje+=Double.valueOf(formData.get(i).get("_widget_1563246851087").toString()); //订单金额
				}
			}
        	map.put(mdbn, kdje);
        }
        return map;
	}
	
	public List<Map.Entry<String,Integer>> getJf(String pp,String dj){
		JDYAPIUtils api = new JDYAPIUtils(APPID, C7_ENTRYID, APIKEY);
    	final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1627905992820");
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
		condList.add(map0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "_widget_1627886457630");
		map1.put("type", "text");
		map1.put("method", "eq");
		map1.put("value", pp);
		condList.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("field", "_widget_1627887109748");
		map2.put("type", "text");
		map2.put("method", "eq");
		map2.put("value", dj);
		condList.add(map2);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};

        List<Map<String, Object>> formData = api.getAllFormData(null,filter);//获取当天所有的数据
        
        Map<String,Double> map=new HashMap<>();
        for (int i = 0; i < formData.size(); i++) {
        	map.put(formData.get(i).get("_widget_1627887110072").toString(), Double.valueOf(formData.get(i).get("_widget_1628477304461").toString()));
		}
        
        List<Jxspm> jxspms=new ArrayList<>();
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			Jxspm jxspm=new Jxspm();
        	jxspm.setMdmc(entry.getKey());
        	jxspm.setTotal(entry.getValue());
        	jxspms.add(jxspm);
		}
		//按照当月回款进行排名
		LinkedHashMap<String,Integer> jfpm=new LinkedHashMap<>();
        List<Entry<Double, List<Jxspm>>> total = jxspms.stream()
                .collect(Collectors.groupingBy(Jxspm::getTotal))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
                .collect(Collectors.toList());
        int index = 1;
        int num=0;
        for (Entry<Double, List<Jxspm>> entry : total) {
        	for (int j = 0; j < entry.getValue().size(); j++) {
        		jfpm.put(entry.getValue().get(j).getMdmc()+"/"+entry.getValue().get(j).getTotal(), index);
        		num++;
			}
            index+=num;
            num=0;
        }
        
        //排序
        List<Map.Entry<String,Integer>> lists = new ArrayList<Map.Entry<String,Integer>>(jfpm.entrySet());
        Collections.sort(lists,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
             
        });
        return lists;
	}
	
}
