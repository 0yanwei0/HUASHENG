package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
			StringBuilder sb = new StringBuilder();
			sb.append("  \n ------------------");
			sb.append("  \n	"+"              签约       邀约       开店      面积");
			for (int i = 0; i < lists.size(); i++) {
				sb.append("  \n ------------------");
				sb.append("  \n	" + getStr(3,lists.get(i).getKey()));
				sb.append(getStr(3,lists.get(i).getValue().split("/")[0]));
				sb.append(getStr(3,lists.get(i).getValue().split("/")[1]));
				sb.append(getStr(2,lists.get(i).getValue().split("/")[2]));
				sb.append((int)Double.parseDouble(lists.get(i).getValue().split("/")[3]));
			}
			sb.append("  \n ------------------");
			sb.append("  \n	" + getStr(3,"⭐北区"));
			sb.append(getStr(3,bq.split("/")[0]));
			sb.append(getStr(3,bq.split("/")[1]));
			sb.append(getStr(2,bq.split("/")[2]));
			sb.append((int)Double.parseDouble(bq.split("/")[3]));
			sb.append("  \n ------------------");
			sb.append("  \n	" + getStr(3,"⭐南区"));
			sb.append(getStr(3,nq.split("/")[0]));
			sb.append(getStr(3,nq.split("/")[1]));
			sb.append(getStr(2,nq.split("/")[2]));
			sb.append((int)Double.parseDouble(nq.split("/")[3]));
			
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=8a7613157b05ee243146cbc857deaa530d10867602fe5c7719ca321edef6dbd8");
			OapiRobotSendRequest request = new OapiRobotSendRequest();
			request.setMsgtype("actionCard");
			Actioncard actioncard = new Actioncard();
			actioncard.setTitle(DateUtils.getNowDateToString() + "拓展战报");
			String json="🏆**"+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE2)+"拓展战报**🏆 \n "+sb.toString();
			actioncard.setText(json);
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
						System.out.println(array.getJSONObject(i).getString("value"));
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
