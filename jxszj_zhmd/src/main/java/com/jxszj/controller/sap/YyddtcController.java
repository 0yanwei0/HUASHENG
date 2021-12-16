package com.jxszj.controller.sap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.service.sap.IYyddtcService;

@Controller
public class YyddtcController {
	
	@Autowired
	private IYyddtcService yyddtcService;
	
	@RequestMapping("/getYyddtc")
	@ResponseBody
	public EUDataGridResult getYyddtc(Integer page, Integer rows, String yyddtcrq){
		EUDataGridResult result =yyddtcService.getYyddtcList(page, rows, yyddtcrq);
		return result;
	}

}
