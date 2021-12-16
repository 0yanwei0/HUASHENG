package com.jxszj.controller.sap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.service.sap.IGdtcService;

@Controller
public class GdtcController {
	
	@Autowired
	private IGdtcService gdtcService;
	
	@RequestMapping("/getGdtc")
	@ResponseBody
	public EUDataGridResult getGdtc(Integer page, Integer rows, String gdtcrq){
		EUDataGridResult result =gdtcService.getGdtcList(page, rows, gdtcrq);
		return result;
	}

}
