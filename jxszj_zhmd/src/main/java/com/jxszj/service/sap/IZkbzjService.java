package com.jxszj.service.sap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.jxszj.pojo.EUDataGridResult;

public interface IZkbzjService {
	
	public EUDataGridResult getSAPPost(int page, int rows,String Status);
	
//	public void sendPost(List<Integer> list);
	
	public int uploadExcel(HttpServletRequest request,HttpServletResponse response,MultipartFile file) throws Exception;
	
//	public int delete(List<Integer> list);
	
//	public XSSFWorkbook getXSSFWorkbook(String excelUrl);

}
