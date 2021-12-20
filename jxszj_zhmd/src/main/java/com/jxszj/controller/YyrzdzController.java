package com.jxszj.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.dingtalk.api.request.OapiRobotSendRequest.Btns;
import com.jxszj.service.IYyrzdzService;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.MessageResult;
import com.jxszj.utils.ObjectUtils;

@Controller
public class YyrzdzController {
	
	@Autowired
	private IYyrzdzService yyrzdzService;
	
    private static final String  APPID = "5cc110c3b3c41744aaa12b2e";
    
    private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
    
    //Y2工作日志积分
    private static final String Y2_ENTRYID="611a09c5e12ca00007ac7a01";
    
      //Y2.1工作日志提报
    private static final String ENTRYID = "61528f58d8111b0008415b1f";
    
	
	@RequestMapping("/welcome")
	public String  welcome(Model model,String tid){
		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1635995776080");//流水号
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", tid);
		condList.add(map0);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};
		List<Map<String, Object>> formData0 = api.getAllFormData(null,filter);
		Object yyyg=formData0.get(0).get("_widget_1632800603215");//运营员工名称
		String dzlb=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953892"));//点赞列表
		String fbdz=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953857"));//范本点赞
		Object dzjf=formData0.get(0).get("_widget_1634714900763");//点赞积分
		Object fbjf=formData0.get(0).get("_widget_1634898994852");//范本积分
		String pl=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953993"));//评论
		model.addAttribute("tid", tid); 
		model.addAttribute("yyyg", yyyg);
		model.addAttribute("dzlb", dzlb);
		model.addAttribute("fbdz", fbdz);
		model.addAttribute("dzjf", dzjf);
		model.addAttribute("fbjf", fbjf);
		
		
		if(!pl.equals("")){
			List<String> lists=Arrays.asList(pl.split("##"));//取出所有的评论，格式为评论人#时间#评论内容
			List<HashMap<String, Object>> listMaps=new ArrayList<HashMap<String,Object>>();
			for (int i = 0; i < lists.size(); i++) {
				if("".equals(lists.get(i))){
					continue;
				}
				List<String> list=Arrays.asList(lists.get(i).split("#"));
				HashMap<String, Object> maps=new HashMap<String, Object>();
				maps.put("plr", list.get(0));
				maps.put("plsj", list.get(1));
				maps.put("plnr", list.get(2));
				listMaps.add(maps);
			}
			model.addAttribute("pljl", listMaps);
		}
		
		return "welcome";
	}
	
	
	@RequestMapping(value = "/dianzan", method = RequestMethod.GET)
	@ResponseBody
	 public MessageResult dianzan (String code,String tid,String userid1,String userName1) {
		//配置哪些人可以点赞
		Map<String,String> map=new HashMap<>();
		map.put("0308432232679085", "刘毅");
		map.put("1617770508396949", "吴峰松");
		map.put("H0001", "吴为");
		map.put("H0004", "林媚");
		map.put("H0008", "凌雅琼");
		try {
			Map<String,Object> data=new HashMap<>();
			String name="";
			String userId=userid1;
			String userName=userName1;
			if("".equals(userid1)){
				JSONObject json=yyrzdzService.dianzan(code);
				userId=json.getString("userid");
				userName=json.getString("name");
			}
			data.put("userid", userId);
			if(map.get(userId)==null){
				return MessageResult.build(201,"当前权限不足，无法参与点赞！",data);
			 }
			name= map.get(userId);
			//查询当前的运营员工
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1635995776080");
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", tid);
			condList.add(map0);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Map<String, Object>> formData0 = api.getAllFormData(null,filter);
			String yyyg=ObjectUtils.getString(formData0.get(0).get("_widget_1632800603215"));//运营员工名称
			String dzlb=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953892"));//点赞列表
//			String fbdz=formData0.get(0).get("_widget_1635851715101").toString();//范本点赞
			int dzjf=1;//点赞积分
//			int fbjf=5;//范本积分
			
			 
			Map<String, Object> rawData = new HashMap<String, Object>();
			
			if(dzlb.contains(name)){
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", dzlb);
				rawData.put("_widget_1635947953892", m0);
			}else if("".equals(dzlb)){
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", name);
				rawData.put("_widget_1635947953892", m0);
				dzlb=name;
			}else{
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", dzlb+"、"+name);
				rawData.put("_widget_1635947953892", m0);
				dzlb=dzlb+"、"+name;
			}
			
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", dzjf);
			rawData.put("_widget_1634714900763", m0);
			
//			Map<String, Object> m1 = new HashMap<String, Object>();
//			m1.put("value", fbjf);
//			rawData.put("_widget_1634898994852", m1);
			
			String pljl=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953993"));//评论
//			String str="";
//			if(!"".equals(pl)){
//				if("".equals(pljl)){
//					str="##"+name+"#"+DateUtils.getNowDateToString(DateUtils.FORMAT_1_LONG)+"#"+pl;
//					Map<String, Object> m2 = new HashMap<String, Object>();
//					m2.put("value", str);
//					rawData.put("_widget_1635851715005", m2);
//				}else{
//					str="##"+name+"#"+DateUtils.getNowDateToString(DateUtils.FORMAT_1_LONG)+"#"+pl+pljl;
//					Map<String, Object> m2 = new HashMap<String, Object>();
//					m2.put("value", str);
//					rawData.put("_widget_1635851715005", m2);
//				}
//			}else{
//				 str=pljl;
//			}
			
			
			if(!"".equals(pljl)){
				List<String> lists=Arrays.asList(pljl.split("##"));
				List<HashMap<String, Object>> listMaps=new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < lists.size(); i++) {
					if("".equals(lists.get(i))){
						continue;
					}
					List<String> list=Arrays.asList(lists.get(i).split("#"));
					HashMap<String, Object> maps=new HashMap<String, Object>();
					maps.put("plr", list.get(0));
					maps.put("plsj", list.get(1));
					maps.put("plnr", list.get(2));
					listMaps.add(maps);
				}
				data.put("pljl", listMaps);
			}
			
			data.put("userid", userId);
			data.put("userName", userName);
			data.put("dzlb", dzlb);
			data.put("dzjf", dzjf);
			
			//判断是否已经点过赞
			if(ObjectUtils.getString(formData0.get(0).get("_widget_1635947953892")).contains(name)){
				return MessageResult.build(201,"已点过赞，不要重复点赞！",data);
			}
			
			api.updateData(formData0.get(0).get("_id").toString(), rawData);
			
			//将点赞积分写入积分表
			api = new JDYAPIUtils(APPID, Y2_ENTRYID, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("field", "_widget_1635992326276");
			map1.put("type", "text");
			map1.put("method", "eq");
			map1.put("value", tid);
			condList1.add(map1);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList1);
				}
			};
			List<Map<String, Object>> formData1 = api.getAllFormData(null,filter1);
			
			rawData = new HashMap<String, Object>();
			m0 = new HashMap<String, Object>();
			m0.put("value", dzjf);
			rawData.put("_widget_1629097511377", m0);
			api.updateData(formData1.get(0).get("_id").toString(), rawData);
			
			jqrPush(tid,yyyg,"点赞[赞]");
			return MessageResult.build(200,"点赞成功！",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MessageResult.build(500,"系统异常！");
	 }
	
	//范本点赞
	@RequestMapping(value = "/dianzan1", method = RequestMethod.GET)
	@ResponseBody
	 public MessageResult dianzan1 (String code,String tid,String userid1,String userName1) {
		//配置哪些人可以点赞
		Map<String,String> map=new HashMap<>();
		map.put("0308432232679085", "刘毅");
		map.put("H0001", "吴为");
		try {
			Map<String,Object> data=new HashMap<>();
			String name="";
			String userId=userid1;
			String userName=userName1;
			if("".equals(userid1)){
				JSONObject json=yyrzdzService.dianzan(code);
				userId=json.getString("userid");
				userName=json.getString("name");
			}
			data.put("userid", userId);
			if(map.get(userId)==null){
				return MessageResult.build(201,"当前权限不足，无法参与范本点赞！",data);
			  }
			name= map.get(userId);
			//查询当前的运营员工
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1635995776080");
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", tid);
			condList.add(map0);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Map<String, Object>> formData0 = api.getAllFormData(null,filter);
			String yyyg=ObjectUtils.getString(formData0.get(0).get("_widget_1632800603215"));//运营员工名称
			String dzlb=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953857"));//范本点赞列表
			int fbjf=5;//范本积分
			
			 
			Map<String, Object> rawData = new HashMap<String, Object>();
			
			if("".equals(dzlb)){
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", name);
				rawData.put("_widget_1635947953857", m0);
				dzlb=name;
			}else{
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", dzlb+"、"+name);
				rawData.put("_widget_1635947953857", m0);
				dzlb=dzlb+"、"+name;
			}
			
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", fbjf);
			rawData.put("_widget_1634898994852", m0);
			
			
			String pljl=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953993"));//评论
			
			if(!"".equals(pljl)){
				List<String> lists=Arrays.asList(pljl.split("##"));
				List<HashMap<String, Object>> listMaps=new ArrayList<HashMap<String,Object>>();
				for (int i = 0; i < lists.size(); i++) {
					if("".equals(lists.get(i))){
						continue;
					}
					List<String> list=Arrays.asList(lists.get(i).split("#"));
					HashMap<String, Object> maps=new HashMap<String, Object>();
					maps.put("plr", list.get(0));
					maps.put("plsj", list.get(1));
					maps.put("plnr", list.get(2));
					listMaps.add(maps);
				}
				data.put("pljl", listMaps);
			}
			
			data.put("userid", userId);
			data.put("fbdz", dzlb);
			data.put("fbjf", fbjf);
			data.put("userName", userName);
			//判断是否已经点过赞
			if(ObjectUtils.getString(formData0.get(0).get("_widget_1635947953857")).contains(name)){
				return MessageResult.build(201,"已点过赞，不要重复点赞！",data);
			}
			
			api.updateData(formData0.get(0).get("_id").toString(), rawData);
			
			//将点赞积分写入积分表
			api = new JDYAPIUtils(APPID, Y2_ENTRYID, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("field", "_widget_1635992326276");
			map1.put("type", "text");
			map1.put("method", "eq");
			map1.put("value", tid);
			condList1.add(map1);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList1);
				}
			};
			List<Map<String, Object>> formData1 = api.getAllFormData(null,filter1);
			
			rawData = new HashMap<String, Object>();
			m0 = new HashMap<String, Object>();
			m0.put("value", fbjf);
			rawData.put("_widget_1629097511489", m0);
			api.updateData(formData1.get(0).get("_id").toString(), rawData);
			jqrPush(tid,yyyg,"点赞[赞]");
			return MessageResult.build(200,"点赞成功！",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MessageResult.build(500,"系统异常！");
	 }
	
	
	@RequestMapping(value = "/pinglun", method = RequestMethod.GET)
	@ResponseBody
	 public MessageResult pinglun (String code,String tid,String userid1,String pl,String userName1) {
		try {
			Map<String,Object> data=new HashMap<>();
			String userId=userid1;
			String userName=userName1;
			if("".equals(userid1)){
				JSONObject json=yyrzdzService.dianzan(code);
				userId=json.getString("userid");
				userName=json.getString("name");
			}
			//配置哪些人可以评论
//			Map<String,String> maps=new HashMap<>();
//			maps.put("0308432232679085", "刘毅");
//			maps.put("1617770508396949", "吴峰松");
//			maps.put("H0001", "吴为");
//			maps.put("H0004", "林媚");
//			maps.put("H0008", "凌雅琼");
			
			
			//查询当前的运营员工
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("field", "_widget_1635995776080");
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", tid);
			condList.add(map);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Map<String, Object>> formData0 = api.getAllFormData(null,filter);
			String pljl=ObjectUtils.getString(formData0.get(0).get("_widget_1635947953993"));//评论
			
			data.put("userid", userId);
			data.put("userName", userName);
			Map<String, Object>rawData = new HashMap<String, Object>();
			String str="";
			if("".equals(pljl)){
				str="##"+userName+"#"+DateUtils.getNowDateToString(DateUtils.FORMAT_1_LONG)+"#"+pl;
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("value", str);
				rawData.put("_widget_1635947953993", m1);
			}else{
				str="##"+userName+"#"+DateUtils.getNowDateToString(DateUtils.FORMAT_1_LONG)+"#"+pl+pljl;
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("value", str);
				rawData.put("_widget_1635947953993", m1);
			}
			api.updateData(formData0.get(0).get("_id").toString(), rawData);
			
			List<String> lists=Arrays.asList(str.split("##"));
			List<HashMap<String, Object>> listMaps=new ArrayList<HashMap<String,Object>>();
			for (int i = 0; i < lists.size(); i++) {
				if("".equals(lists.get(i))){
					continue;
				}
				List<String> list=Arrays.asList(lists.get(i).split("#"));
				HashMap<String, Object> maps1=new HashMap<String, Object>();
				maps1.put("plr", list.get(0));
				maps1.put("plsj", list.get(1));
				maps1.put("plnr", list.get(2));
				listMaps.add(maps1);
			}
			data.put("pljl", listMaps);
			if(!userName.equals(ObjectUtils.getString(formData0.get(0).get("_widget_1632800603215")))){
				jqrPush(tid,ObjectUtils.getString(formData0.get(0).get("_widget_1632800603215")),"日志评论[气泡]");
			}else if(pl.contains("@")){
				jqrPush(tid,Arrays.asList(pl.split("@")).get(1),"日志回复[气泡]");
			}
			return MessageResult.build(200,"评论成功！",data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MessageResult.build(500,"评论失败！");
	 }
	public void  jqrPush(String tid,String name,String type){
		try {
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=6835829f3cfae0d3d718f570649eae2d21d32d6fe7c1cc446a43119d38eda873");
			OapiRobotSendRequest request = new OapiRobotSendRequest();
			request.setMsgtype("actionCard");
			Actioncard actioncard=new Actioncard();
			actioncard.setTitle("💬💬💬新消息💬💬💬");
			String json="[广播][广播][广播]"+name+",你有新的"+type;
			
			actioncard.setText(json);
			List<Btns> btns=new ArrayList<Btns>();
			Btns btn1=new Btns();
			btn1.setTitle("去看看");
			btn1.setActionURL("http://www.huasheng999.com/welcome?tid="+tid);
			btns.add(btn1);
			
			actioncard.setBtns(btns);
			actioncard.setBtnOrientation("0");
			request.setActionCard(actioncard);
			client.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
