package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.jxszj.pojo.Jxspm;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

//店长能量积分榜
public class DznlPushQuartz {

	// 简道云
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

	//C7店长能量月度评分表
    private static final String C7_ENTRYID = "610cf9a301856800079f7cfe";
    
	public void execute() {
		try {
			JDYAPIUtils c1_api = new JDYAPIUtils(APPID, C7_ENTRYID, APIKEY);
			List<String> pp = new ArrayList<String>();
			pp.add("MS");
			pp.add("PD");
			pp.add("HMW");
			// 按品牌获取门店店长信息
			for (int j = 0; j < pp.size(); j++) {
				String jqrUrl = "";
				if ("MS".equals(pp.get(j))) {
					jqrUrl = "https://oapi.dingtalk.com/robot/send?access_token=6033afd51915bcdab55afcb93067661e791908d343542bd5a6a3d2e69af18872";
				} else if ("PD".equals(pp.get(j))) {
					jqrUrl = "https://oapi.dingtalk.com/robot/send?access_token=726ad5a3356c837f2bf1b0bd46b1f23f13ebb647ea75ea82e98dfe1ce69aedac";
				} else if ("HMW".equals(pp.get(j))) {
					jqrUrl = "https://oapi.dingtalk.com/robot/send?access_token=03118f5d1604fb761d8bb2505f5402e6624e7bbded5fc55e7547dbc36c7b78f0";
				}
				
				final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
				Map<String, Object> map0 = new HashMap<String, Object>();
				map0.put("field", "_widget_1627886457630");// 品牌
				map0.put("type", "text");
				map0.put("method", "eq");
				map0.put("value", pp.get(j));
				condList.add(map0);
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("field", "_widget_1627905992820");// 评分年月
				map1.put("type", "text");
				map1.put("method", "eq");
				map1.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
				condList.add(map1);
				Map<String, Object> filter = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList);
					}
				};

				List<Map<String, Object>> formData = c1_api.getAllFormData(null, filter);

				List<Jxspm> jxspms = new ArrayList<>();
				for (int i = 0; i < formData.size(); i++) {
					Jxspm jxspm=new Jxspm();
					jxspm.setMdmc(formData.get(i).get("_widget_1627887110072").toString());
					jxspm.setDz(formData.get(i).get("_widget_1627886455851").toString());
					jxspm.setJf(ObjectUtils.getDouble(formData.get(i).get("_widget_1628477304461")));
					jxspms.add(jxspm);
				}
				
				LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
		        List<Entry<Double, List<Jxspm>>> list = jxspms.stream()
		                .collect(Collectors.groupingBy(Jxspm::getJf))
		                .entrySet()
		                .stream()
		                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
		                .collect(Collectors.toList());
		        int index = 1;
		        int num=0;
		        for (Entry<Double, List<Jxspm>> entry : list) {
		        	for (int i = 0; i < entry.getValue().size(); i++) {
		        		 String mdmc=entry.getValue().get(i).getMdmc().replace("MS", "").replace("PD", "").replace("HMW", "");
		        		 map.put(mdmc+"("+entry.getValue().get(i).getDz()+":"+entry.getValue().get(i).getJf()+")", index);
		        		 num++;
					}
		            index+=num;
		            num=0;
		        }




				StringBuilder sb = new StringBuilder("  \n	");
				
				if("HMW".equals(pp.get(j))){
					for (Map.Entry<String, Integer> entry : map.entrySet()) {
	        			if(entry.getValue()<=4){
	        				sb.append(""+entry.getValue()+"    "+entry.getKey().replace(".00", "").replace(".0", "")+"  \n	");
	        			}
	        	    }
				}else{
					for (Map.Entry<String, Integer> entry : map.entrySet()) {
	        			if(entry.getValue()<10){
	        				sb.append(""+entry.getValue()+"    "+entry.getKey().replace(".00", "").replace(".0", "")+"  \n	");
	        			}else if(entry.getValue()>=10 && entry.getValue()<=20){
	        				sb.append(""+entry.getValue()+"  "+entry.getKey().replace(".00", "").replace(".0", "")+"  \n	");
	        			}
	        	    }
				}

				DingTalkClient client = new DefaultDingTalkClient(jqrUrl);
				OapiRobotSendRequest request = new OapiRobotSendRequest();
				request.setMsgtype("actionCard");
				Actioncard actioncard = new Actioncard();
				actioncard.setTitle(DateUtils.getNowDateToString() + "店长英杰榜");
				String json="🏆**"+pp.get(j)+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE2)+"店长英杰榜**🏆 \n "+sb.toString();
				actioncard.setText(json);
				request.setActionCard(actioncard);
				client.execute(request);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 排序
	public static List<Map.Entry<String, Double>> mapSort(Map<String, Double> map) {
		// 将map.entrySet()转换成list
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 排序
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
	}
	
	
    public String getStr(int length,String str){
    	StringBuilder sb=new StringBuilder();
    	if(length>str.length()){
    		for (int i = 0; i < length-str.length(); i++) {
				sb.append("    ");
			}
    	}
    	return str+sb.toString()+"     ";
    }
    
    public String getStr1(int length,String str){
    	StringBuilder sb=new StringBuilder();
    	if(length>str.length()){
    		for (int i = 0; i < length-str.length(); i++) {
				sb.append("0");
			}
    	}
    	return sb.toString()+str+"       ";
    }

}
