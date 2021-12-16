package com.jxszj.service.impl;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.jxszj.service.IYyrzdzService;

@Service
public class YyrzdzServiceImpl implements IYyrzdzService {

    
	@Override
	public String dianzan(String code) {
		String userId ="";
		try {
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
			OapiGettokenRequest req = new OapiGettokenRequest();
			req.setAppkey("ding8xgxo7yjtwqq7keh"); 
			req.setAppsecret("5Dny9VuYe31-YFPOZKWtbO-M1Xi3FgRsVnBT2lZH7LpTRos3OAXn2SEBrkLCUNTp");
			req.setHttpMethod("GET");
			OapiGettokenResponse rsp = client.execute(req);
			String access_token=JSONObject.parseObject(rsp.getBody()).getString("access_token");
			 // 获取access_token，注意正式代码要有异常流处理
			  // 获取用户信息
			  client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
			  OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
			  request.setCode(code);
			  request.setHttpMethod("GET");
			  OapiUserGetuserinfoResponse response;
			  response = client.execute(request, access_token);
			  // 查询得到当前用户的userId    
			  // 获得到userId之后应用应该处理应用自身的登录会话管理（session）,避免后续的业务交互（前端到应用服务端）每次都要重新获取用户身份，提升用户体验
//			  userId = response.getUserid();
			  JSONObject json=JSONObject.parseObject(response.getBody());
			  if("ok".equals(json.getString("errmsg"))){
				  userId=json.getString("userid");
			  }
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
	
}
