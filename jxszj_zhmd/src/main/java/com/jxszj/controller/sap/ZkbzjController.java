package com.jxszj.controller.sap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.service.sap.IZkbzjService;
import com.jxszj.utils.MessageResult;

//账扣保证金
@Controller
public class ZkbzjController {

	@Autowired
	private IZkbzjService zkbzjService;
	
	@RequestMapping("/zkbzj/uploadPostExcel")
	@ResponseBody
	public MessageResult uploadPostExcel(@RequestParam("zkbzjExcelFile") MultipartFile zkbzjExcelFile,HttpServletRequest request, HttpServletResponse response){
		try {
			if (zkbzjExcelFile==null) {
				return MessageResult.build(null,"上传Excel失败,请重试！");
			}
			int num=zkbzjService.uploadExcel(request, response, zkbzjExcelFile);
			if(num>0){
				return MessageResult.build(200,"同步完成");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return MessageResult.build(500,"同步失败");
	}
	
	@RequestMapping("/zkbzj/getSAPPostList")
	@ResponseBody
	public EUDataGridResult getSAPPostList(Integer page, Integer rows,String dskqzStatus){
		EUDataGridResult result =zkbzjService.getSAPPost(page, rows,dskqzStatus);
		return result;
	}
}
