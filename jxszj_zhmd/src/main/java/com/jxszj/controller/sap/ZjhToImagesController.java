package com.jxszj.controller.sap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.jxszj.utils.ExcelToImage;
import com.jxszj.utils.JDYAPIUtils;

//供应商清账
@Controller
public class ZjhToImagesController {

	@RequestMapping(value="/saveZjhImages", method = RequestMethod.GET)
	public void saveZjhImages(String id){
		String imagesName="";
		try {
			// POS经销商之家 -- DS2-门店实时销售提报
		    String  appId = "5cc110c3b3c41744aaa12b2e";
		    String entryId = "61724ea4e11d57000706ea12";
		    String apiKey = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
		    
		    JDYAPIUtils api = new JDYAPIUtils(appId, entryId, apiKey);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1634881275842");
    		map0.put("type", "text");
    		map0.put("method", "eq");
    		map0.put("value", id);
    		condList1.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList1);
    			}
    		};
    		
    		List<Map<String, Object>> formData = api.getAllFormData(null,filter);
    		formData=(List<Map<String, Object>>)formData.get(0).get("_widget_1635231504052");
    		XSSFWorkbook wb = new XSSFWorkbook();  
    		XSSFSheet sheet = wb.createSheet();
    		sheet.setColumnWidth(0, 12000);
            sheet.setColumnWidth(1, 12000);
            sheet.setColumnWidth(2, 12000);
            sheet.setColumnWidth(3, 12000);//设置列宽
            sheet.setColumnWidth(4, 12000);//设置列宽
            sheet.setColumnWidth(5, 12000);
            sheet.setColumnWidth(6, 12000);
            
            XSSFFont font2 = wb.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short)25);

            XSSFCellStyle  style2= wb.createCellStyle();
            style2.setFont(font2);
            style2.setWrapText(true);
            style2.setAlignment(HorizontalAlignment.CENTER); // 居中
            style2.setVerticalAlignment(VerticalAlignment.CENTER);
            
            XSSFFont font3 = wb.createFont();
            font3.setFontName("宋体");
            font3.setFontHeightInPoints((short)20);

            XSSFCellStyle  style3= wb.createCellStyle();
            style3.setFont(font3);
            style3.setWrapText(true);
            style3.setAlignment(HorizontalAlignment.CENTER); // 居中
            style3.setVerticalAlignment(VerticalAlignment.CENTER);
            
            
            XSSFRow row00 = sheet.getRow(0);
    		if (null == row00) {
    			row00 = sheet.createRow(0);
    		}
    		row00.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row00.getCell(i);
    			if (null == cell) {
    				cell = row00.createCell(i);
    			}
    			cell.setCellValue(getStringFormat_Z(formData.get(i).get("_widget_1635231504169").toString(),"yyyy-MM-dd"));
    			cell.setCellStyle(style2);
    		}
    		XSSFRow row01 = sheet.getRow(1);
    		if (null == row01) {
    			row01 = sheet.createRow(1);
    		}
    		row01.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row01.getCell(i);
    			if (null == cell) {
    				cell = row01.createCell(i);
    			}
    			cell.setCellValue(formData.get(i).get("_widget_1635231504217").toString());
    			cell.setCellStyle(style2);
    		}
    		XSSFRow row02 = sheet.getRow(2);
    		if (null == row02) {
    			row02 = sheet.createRow(2);
    		}
    		row02.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row02.getCell(i);
    			if (null == cell) {
    				cell = row02.createCell(i);
    			}
    			JSONObject json=(JSONObject)JSONObject.toJSON(formData.get(i).get("_widget_1635231504355"));
    			cell.setCellValue(json.getString("province")+json.getString("city"));
    			cell.setCellStyle(style3);
    		}
    		XSSFRow row03 = sheet.getRow(3);
    		if (null == row03) {
    			row03 = sheet.createRow(3);
    		}
    		row03.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row03.getCell(i);
    			if (null == cell) {
    				cell = row03.createCell(i);
    			}
    			cell.setCellValue(formData.get(i).get("_widget_1635231504384").toString());
    			cell.setCellStyle(style3);
    		}
    		XSSFRow row04 = sheet.getRow(4);
    		if (null == row04) {
    			row04 = sheet.createRow(4);
    		}
    		row04.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row04.getCell(i);
    			if (null == cell) {
    				cell = row04.createCell(i);
    			}
    			cell.setCellValue(formData.get(i).get("_widget_1635231504466").toString());
    			cell.setCellStyle(style3);
    		}
    		XSSFRow row05 = sheet.getRow(5);
    		if (null == row05) {
    			row05 = sheet.createRow(5);
    		}
    		row05.setHeight((short)800);
    		for(int i=0;i<formData.size();i++){
    			XSSFCell cell = row05.getCell(i);
    			if (null == cell) {
    				cell = row05.createCell(i);
    			}
    			cell.setCellValue(formData.get(i).get("_widget_1635231504565").toString());
    			cell.setCellStyle(style3);
    		}
    		
    		imagesName=id+".png";
    		ExcelToImage.generatePic(wb,imagesName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getStringFormat_Z(String time,String format) throws ParseException{
		if("".equals(time)) {
			return "";
		}
		time = time.replace(" ", "").replace("Z", " UTC");//注意是空格+UTC
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
		Date date = dateFormat.parse(time );
	    SimpleDateFormat formatter = new SimpleDateFormat(format);  
	    String dateString = formatter.format(date);  
	    return dateString; 
	}
	
}
