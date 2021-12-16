package com.jxszj.controller.sap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.service.sap.IXsdddjysService;
import com.jxszj.utils.MessageResult;

@Controller
public class XsdddjysController {
	
	@Autowired
	private IXsdddjysService xsdddjysService;
	
	@RequestMapping("/getXsdddjys")
	@ResponseBody
	public EUDataGridResult getXsdddjys(Integer page, Integer rows){
		EUDataGridResult result =xsdddjysService.getSapXsdddjysTbList(page, rows);
		return result;
	}
	
	@RequestMapping("/updateXsdddjys")
	@ResponseBody
	public MessageResult updateXsdddjys(String ny){
		int i=xsdddjysService.updateSapXsdddjysTb(ny);
		if(i==0){
			return MessageResult.build(500,"更新失败！");
		}
		return MessageResult.build(200,"更新完成！");
	}

}
