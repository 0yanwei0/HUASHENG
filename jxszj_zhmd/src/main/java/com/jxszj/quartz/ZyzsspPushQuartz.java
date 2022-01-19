package com.jxszj.quartz;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

//专业知识视频
public class ZyzsspPushQuartz {

	// 简道云  
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

	//3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";

	//C3专业知识视频
    private static final String C3_ENTRYID = "6109090976c77b0008982793";
    
    
	public void execute() {
		try {
			JDYAPIUtils c3_api = new JDYAPIUtils(APPID, C3_ENTRYID, APIKEY);
			//查询营业中的门店,且实际开业时间小于当前日期
			JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
			
			NumberFormat nf = NumberFormat.getPercentInstance(); 
			List<String> pp = new ArrayList<String>();
			pp.add("MS");
			pp.add("PD");
			pp.add("HMW");
			// 按品牌获取门店店长信息
			for (int j = 0; j < pp.size(); j++) {
				final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
				Map<String, Object> map0 = new HashMap<String, Object>();
				map0.put("field", "_widget_1560998925033");//运营状态：营业中
				map0.put("type", "text");
				map0.put("method", "eq");
				map0.put("value", "营业中");
				condList0.add(map0);
				String[] str=new String[2];
				str[0]="null";
				str[1]=DateUtils.getLastDay(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE1),DateUtils.FORMAT_STRING_MINUTE1);
				Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
				map1.put("field", "_widget_1578996437131");
				map1.put("type", "text");
				map1.put("method", "range");
				map1.put("value",str);
				condList0.add(map1);
				Map<String, Object> map2 = new HashMap<String, Object>();//品牌
				map2.put("field", "_widget_1543818220013");
				map2.put("type", "text");
				map2.put("method", "eq");
				map2.put("value",pp.get(j));
				condList0.add(map2);
				Map<String, Object> filter0 = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList0);
					}
				};
				List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
				Set<String> p01=new HashSet<String>();
	    		Set<String> p02=new HashSet<String>();
	    		Map<String, String> yyjls=new HashMap<String, String>();//运营经理对应的名称
				for (int i = 0; i < formData0.size(); i++) {
					p01.add(ObjectUtils.getString(formData0.get(i).get("_widget_1560906554863")));//p01运营经理
					p02.add(ObjectUtils.getString(formData0.get(i).get("_widget_1628167934994")));//p02运营经理
					yyjls.put(formData0.get(i).get("_widget_1560906554863").toString(), formData0.get(i).get("_widget_1545358841001").toString());
					yyjls.put(formData0.get(i).get("_widget_1628167934994").toString(), formData0.get(i).get("_widget_1628167934919").toString());
				}
				//开店申请中运营经理对应的门店数
	    		Map<String, Integer> yyjlmds=new HashMap<String, Integer>();
	    		for(String yyjlbm:p01) {
	    			int number=0;
	    			for (int i = 0; i < formData0.size(); i++) {
	    				if(yyjlbm.equals(formData0.get(i).get("_widget_1560906554863").toString())) {
	    					number++;
	    				}
	    			}
	    			yyjlmds.put(yyjlbm, number);
	    		}
	    		for(String yyjlbm:p02) {
	    			int number=0;
	    			for (int i = 0; i < formData0.size(); i++) {
	    				if(yyjlbm.equals(formData0.get(i).get("_widget_1628167934994").toString())) {
	    					number++;
	    				}
	    			}
	    			yyjlmds.put(yyjlbm, number);
	    		}
	    		
				final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
				map1 = new HashMap<String, Object>();
				map1.put("field", "_widget_1627886457630");// 品牌
				map1.put("type", "text");
				map1.put("method", "eq");
				map1.put("value", pp.get(j));
				condList1.add(map1);
				map2 = new HashMap<String, Object>();
				map2.put("field", "_widget_1627905992605");// 日期
				map2.put("type", "text");
				map2.put("method", "eq");
				map2.put("value", DateUtils.getNowDateToString());
				condList1.add(map2);
				Map<String, Object> filter1 = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList1);
					}
				};

				List<Map<String, Object>> formData1 = c3_api.getAllFormData(null, filter1);
				//C3专业知识视频运营经理对应的门店数
	    		Map<String, Integer> spyyjlmds=new HashMap<String, Integer>();
	    		for(String yyjlbm:p01) {
	    			Set<String> set=new HashSet<String>();
	    			for (int i = 0; i < formData1.size(); i++) {
	    				if(yyjlbm.equals(formData1.get(i).get("_widget_1627886456443").toString())) {
	    					set.add(formData1.get(i).get("_widget_1627886455424").toString());
	    				}
	    			}
	    			spyyjlmds.put(yyjlbm, set.size());
	    		}
//	    		for(String yyjlbm:p02) {
//	    			Set<String> set=new HashSet<String>();
//	    			for (int i = 0; i < formData1.size(); i++) {
//	    				if(yyjlbm.equals(formData1.get(i).get("_widget_1628169748713").toString())) {
//	    					set.add(formData1.get(i).get("_widget_1627886455424").toString());
//	    				}
//	    			}
//	    			spyyjlmds.put(yyjlbm, set.size());
//	    		}
	    		
				//date的key值由督导，value值为提报率
				Map<String, Double> date = new HashMap<>();
				for (Map.Entry<String, Integer> entry: yyjlmds.entrySet()) {
					date.put(entry.getKey(),Double.valueOf(spyyjlmds.get(entry.getKey()))/Double.valueOf(entry.getValue()));
				}
				List<Map.Entry<String, Double>> lists = mapSort(date);

				StringBuilder sb = new StringBuilder();
				sb.append("  \n ------------------");
				sb.append("  \n	"+"运营     门店     已报     未报     提报率");
				for (int i=0;i<lists.size();i++) {
					sb.append("  \n ------------------");
//					sb.append("  \n	" + getStr(3,yyjls.get(lists.get(i)))+getStr1(2,String.valueOf(yyjlmds.get(lists.get(i))))+getStr1(2,String.valueOf(spyyjlmds.get(lists.get(i))))+getStr1(2,String.valueOf(yyjlmds.get(lists.get(i))-spyyjlmds.get(lists.get(i))))+df.format(lists.get(1).getValue()));
					sb.append("  \n	" + getStr(3,yyjls.get(lists.get(i).getKey())));
					sb.append(getStr1(2,String.valueOf(yyjlmds.get(lists.get(i).getKey()))));
					sb.append(getStr1(2,String.valueOf(spyyjlmds.get(lists.get(i).getKey()))));
					sb.append(getStr1(2,String.valueOf(yyjlmds.get(lists.get(i).getKey())-spyyjlmds.get(lists.get(i).getKey()))));
					sb.append(nf.format(lists.get(i).getValue()));
				}

				DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=63fcb97730d44ce40f5fddf216c7fdb921462361284db69060a51088dcb14fe5");
				OapiRobotSendRequest request = new OapiRobotSendRequest();
				request.setMsgtype("actionCard");
				Actioncard actioncard = new Actioncard();
				actioncard.setTitle(DateUtils.getNowDateToString() + "视频数据提报排行榜");
				String json="🏆**"+pp.get(j)+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE2)+"视频数据提报排行榜**🏆 \n "+sb.toString();
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
			// 升序排序
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
