package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import java.util.Set;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.jxszj.pojo.Jxspm;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

//MS和PD群的每日城市冠军排行榜
public class CityChampionQuartz {
	
	// 简道云
    private static final String  APPID = "5cc110c3b3c41744aaa12b2e";
    //门店实时销售提报
    private static final String ENTRYID_DS2 = "5d2d229eee266915714e9e1e";
    private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
    
    //DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
    
    //3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";
    
    
    public void execute(){
    	champion1();
    	champion2();
    	champion3();
    }
    
    //PD/MS/HMW睡眠顾问分享群
    public void champion1(){
    	try {
    		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DS2, APIKEY);
        	List<String> pp=new ArrayList<String>();
        	pp.add("MS");
        	pp.add("PD");
        	pp.add("HMW");
        	for (int j = 0; j < pp.size(); j++) {
        		String jqrUrl="";
        		if("MS".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=6033afd51915bcdab55afcb93067661e791908d343542bd5a6a3d2e69af18872";
    	    	}else if("PD".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=726ad5a3356c837f2bf1b0bd46b1f23f13ebb647ea75ea82e98dfe1ce69aedac";
    	    	}else if("HMW".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=03118f5d1604fb761d8bb2505f5402e6624e7bbded5fc55e7547dbc36c7b78f0";
    	    	}
        		
        		
        		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("field", "_widget_1563246850783");//开单年月
        		map.put("type", "text");
        		map.put("method", "eq");
        		map.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
        		condList.add(map);
        		Map<String, Object> map1 = new HashMap<String, Object>();
        		map1.put("field", "_widget_1563246848536");
        		map1.put("type", "text");
        		map1.put("method", "eq");
        		map1.put("value", pp.get(j));
        		condList.add(map1);
        		Map<String, Object> map2 = new HashMap<String, Object>();
        		map2.put("field", "_widget_1563356837948");
        		map2.put("type", "text");
        		map2.put("method", "eq");
        		map2.put("value", "审批通过");
        		condList.add(map2);
        		Map<String, Object> filter = new HashMap<String, Object>() {
        			{
        				put("rel", "and");
        				put("cond", condList);
        			}
        		};
        		
                List<Map<String, Object>> formData = api.getAllFormData(null,filter);
                
                if(formData.size()==0){
                	continue;
                }
                
        		Set<String> A=new HashSet<String>();//A级城市门店
        		Set<String> B=new HashSet<String>();//B级城市门店
        		Set<String> C=new HashSet<String>();//C级城市门店
        		for (int i = 0; i < formData.size(); i++) {
        			if("A".equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246848832")))){
        				A.add(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")));
        			}else if("B".equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246848832")))){
        				B.add(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")));
        			}else if("C".equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246848832")))){
        				C.add(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")));
        			}
        		}
        		Map<String,Double> map_a=new HashMap<String,Double>(); //A级城市中每个门店每月的累计订单金额
        		for (String a : A) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(a.equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1563246851087")));
        				}
        			}
        			
        			map_a.put(a, num);
        		}
        		
        		Map<String,Double> map_b=new HashMap<String,Double>(); //B级城市中每个门店每月的累计订单金额
        		for (String b : B) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(b.equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1563246851087")));
        				}
        			}
        			map_b.put(b, num);
        		}
        		
        		Map<String,Double> map_c=new HashMap<String,Double>(); //C级城市中每个门店每月的累计订单金额
        		for (String c : C) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(c.equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246847853")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1563246851087")));
        				}
        			}
        			map_c.put(c, num);
        		}
        		LinkedHashMap<String, Integer> pm_a=getmdyjpm(map_a);
        		LinkedHashMap<String, Integer> pm_b=getmdyjpm(map_b);
        		LinkedHashMap<String, Integer> pm_c=getmdyjpm(map_c);
        		
        		
        		StringBuilder strA=new StringBuilder("  \n	");
        		StringBuilder strB=new StringBuilder("  \n	");
        		StringBuilder strC=new StringBuilder("  \n	");
        		for (Map.Entry<String, Integer> entry : pm_a.entrySet()) {
        	        String mapKey = entry.getKey().replace(".00", "").replace(".0", "");
        	        Integer mapValue = entry.getValue();
        	        if(mapValue<10){
        	        	strA.append("NO. "+mapValue+"      "+mapKey+"  \n	");
        	        }else if(mapValue==10){
        	        	strA.append("NO."+mapValue+"     "+mapKey+"  \n	");
        	        }
        	    }
        		
        		for (Map.Entry<String, Integer> entry : pm_b.entrySet()) {
        	        String mapKey = entry.getKey().replace(".00", "").replace(".0", "");
        	        Integer mapValue = entry.getValue();
        	        if(mapValue<10){
        	        	strB.append("NO. "+mapValue+"      "+mapKey+"  \n	");
        	        }else if(mapValue==10){
        	        	strB.append("NO."+mapValue+"     "+mapKey+"  \n	");
        	        }
        	    }
        		
        		for (Map.Entry<String, Integer> entry : pm_c.entrySet()) {
        	        String mapKey = entry.getKey().replace(".00", "").replace(".0", "");
        	        Integer mapValue = entry.getValue();
        	        if(mapValue<10){
        	        	strC.append("NO. "+mapValue+"      "+mapKey+"  \n	");
        	        }else if(mapValue==10){
        	        	strC.append("NO."+mapValue+"     "+mapKey+"  \n	");
        	        }
        	    }
        		String str="🏆**"+pp.get(j)+DateUtils.getMonth()+"月门店业绩冠军榜**🏆"
        				+ "  \n⭐⭐⭐**A级城市门店**⭐⭐⭐"+strA
        				+ "  \n⭐⭐⭐**B级城市门店**⭐⭐⭐"+strB
        				+ "  \n⭐⭐⭐**C级城市门店**⭐⭐⭐"+strC
        				+ "\n\n"
        				+ "  \n	[鼓掌][鼓掌][鼓掌]为第一名喝彩[鼓掌][鼓掌][鼓掌]"
        				+ "  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜";
        		DingTalkClient client = new DefaultDingTalkClient(jqrUrl);
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle(pp.get(j)+DateUtils.getMonth()+"月门店业绩冠军榜");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n	"+str;
        		actioncard.setText(json);
        		request.setActionCard(actioncard);
        		client.execute(request);
        		
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    //经销商群的排名,本年的收款金额
    public void champion2(){
    	try {
    		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
        	List<String> pp=new ArrayList<String>();
        	pp.add("MS");
        	pp.add("PD");
        	pp.add("HMW");
        	for (int j = 0; j < pp.size(); j++) {
        		String jqrUrl="";
        		if("MS".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=7b4f2efbf193c881c122fc360b17c64ecd9c3fef838f9910ba2edf369d3e83b0";
    	    	}else if("PD".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=bc41275a7ad9824e0a16cddc8caf93333f143d4ab836d4b13ebf270ef36e8575";
    	    	}else if("HMW".equals(pp.get(j))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=abb3a28cb1986117e0bc68d4bf6bd07badd2d1f59a4f9eed0d49d06a17c70beb";
    	    	}
            	final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("field", "_widget_1564272871299");
        		map.put("type", "text");
        		map.put("method", "eq");
        		map.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR));
        		condList.add(map);
        		Map<String, Object> map2 = new HashMap<String, Object>();
        		map2.put("field", "_widget_1593141119943");
        		map2.put("type", "text");
        		map2.put("method", "not_empty");
        		condList.add(map2);
        		Map<String, Object> map3 = new HashMap<String, Object>();
        		map3.put("field", "_widget_1548057662316");
        		map3.put("type", "text");
        		map3.put("method", "eq");
        		map3.put("value", pp.get(j));
        		condList.add(map3);
        		Map<String, Object> filter = new HashMap<String, Object>() {
        			{
        				put("rel", "and");
        				put("cond", condList);
        			}
        		};
        		
                List<Map<String, Object>> formData = api.getAllFormData(null,filter);
                
                if(formData.size()==0){
                	continue;
                }
                
        		Set<String> A=new HashSet<String>();//A级城市
        		Set<String> B=new HashSet<String>();//B级城市
        		Set<String> C=new HashSet<String>();//C级城市
        		for (int i = 0; i < formData.size(); i++) {
        			if("A".equals(ObjectUtils.getString(formData.get(i).get("_widget_1569114309696")))){
        				A.add(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")));
        			}else if("B".equals(ObjectUtils.getString(formData.get(i).get("_widget_1569114309696")))){
        				B.add(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")));
        			}else if("C".equals(ObjectUtils.getString(formData.get(i).get("_widget_1569114309696")))){
        				C.add(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")));
        			}
        		}
        		
        		Map<String,Double> map_a=new HashMap<String,Double>(); //A级城市中每个城市每月的累计日常返单金额
        		for (String a : A) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(a.equals(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1564390193051")));
        				}
        			}
        			map_a.put(a, num);
        		}
        		
        		Map<String,Double> map_b=new HashMap<String,Double>(); //B级城市中每个城市每月的累计日常返单金额
        		for (String b : B) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(b.equals(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1564390193051")));
        				}
        			}
        			map_b.put(b, num);
        		}
        		
        		Map<String,Double> map_c=new HashMap<String,Double>(); //C级城市中每个城市每月的累计日常返单金额
        		for (String c : C) {
        			double num=0.0;
        			for (int i = 0; i < formData.size(); i++) {
        				if(c.equals(ObjectUtils.getString(formData.get(i).get("_widget_1548057662521")))){
        					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1564390193051")));
        				}
        			}
        			map_c.put(c, num);
        		}
        		
        		List<Entry<String, Double>> list_a=mapSort(map_a);
        		List<Entry<String, Double>> list_b=mapSort(map_b);
        		List<Entry<String, Double>> list_c=mapSort(map_c);
        		
        		
        		StringBuilder strA=new StringBuilder("  \n	");
        		StringBuilder strB=new StringBuilder("  \n	");
        		StringBuilder strC=new StringBuilder("  \n	");
        		for (int i = 0; i < list_a.size(); i++) {
					if(i<=8){
						strA.append("第 "+(i+1)+" 名          "+list_a.get(i).getKey()+"  \n	");
					}else if(i==9){
						strA.append("第"+(i+1)+"名          "+list_a.get(i).getKey()+"  \n	");
					}
				}
        		
        		for (int i = 0; i < list_b.size(); i++) {
        			if(i<=8){
        				strB.append("第 "+(i+1)+" 名          "+list_b.get(i).getKey()+"  \n	");
					}else if(i==9){
						strB.append("第"+(i+1)+"名         "+list_b.get(i).getKey()+"  \n	");
					}
				}
        		
        		for (int i = 0; i < list_c.size(); i++) {
        			if(i<=8){
        				strC.append("第 "+(i+1)+" 名          "+list_c.get(i).getKey()+"  \n	");
					}else if(i==9){
						strC.append("第"+(i+1)+"名          "+list_c.get(i).getKey()+"  \n	");
					}
				}
        		
        		String str="🏆**"+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR)+pp.get(j)+"下单业绩排行榜**🏆"
        				+ "  \n	             ⭐⭐⭐**A级城市**⭐⭐⭐          "+strA.toString()
        				+ "            ⭐⭐⭐**B级城市**⭐⭐⭐          "+strB.toString()
        				+ "            ⭐⭐⭐**C级城市**⭐⭐⭐          "+strC.toString()
        				+ "  \n	TOP前10（截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_2_STRING)+")"
        				+ "  \n	[鼓掌][鼓掌][鼓掌]为第一名喝彩[鼓掌][鼓掌][鼓掌]"
        				+ "  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜";
        		DingTalkClient client = new DefaultDingTalkClient(jqrUrl);
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle(pp.get(j)+DateUtils.getMonth()+"月回款业绩排行榜");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n	"+str;
        		actioncard.setText(json);
        		request.setActionCard(actioncard);
        		client.execute(request);
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    
    //本月的收款金额   PD/MS/HMW睡眠顾问分享群
    public void champion3(){
    	try {
    		//查询营业中的门店
    		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
    		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1560998925033");//运营状态
    		map0.put("type", "text");
    		map0.put("method", "eq");
    		map0.put("value", "营业中");
    		condList0.add(map0);
    		Map<String, Object> filter0 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList0);
    			}
    		};
    		
            List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
    		
    		
    		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
        	List<String> pp=new ArrayList<String>();
        	pp.add("MS");
        	pp.add("PD");
        	pp.add("HMW");
        	for (int i = 0; i < pp.size(); i++) {
        		String jqrUrl="";
        		if("MS".equals(pp.get(i))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=6033afd51915bcdab55afcb93067661e791908d343542bd5a6a3d2e69af18872";
    	    	}else if("PD".equals(pp.get(i))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=726ad5a3356c837f2bf1b0bd46b1f23f13ebb647ea75ea82e98dfe1ce69aedac";
    	    	}else if("HMW".equals(pp.get(i))){
    	    		jqrUrl="https://oapi.dingtalk.com/robot/send?access_token=03118f5d1604fb761d8bb2505f5402e6624e7bbded5fc55e7547dbc36c7b78f0";
    	    	}
            	final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
        		Map<String, Object> map1 = new HashMap<String, Object>();
        		map1.put("field", "_widget_1548049038941");//收款年月
        		map1.put("type", "text");
        		map1.put("method", "eq");
        		map1.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
        		condList1.add(map1);
        		Map<String, Object> map2 = new HashMap<String, Object>();
        		map2.put("field", "_widget_1593141119943");//SAP的凭证号
        		map2.put("type", "text");
        		map2.put("method", "not_empty");
        		condList1.add(map2);
        		Map<String, Object> map3 = new HashMap<String, Object>();
        		map3.put("field", "_widget_1548057662316");
        		map3.put("type", "text");
        		map3.put("method", "eq");
        		map3.put("value", pp.get(i));
        		condList1.add(map3);
        		Map<String, Object> filter = new HashMap<String, Object>() {
        			{
        				put("rel", "and");
        				put("cond", condList1);
        			}
        		};
        		
                List<Map<String, Object>> formData = api.getAllFormData(null,filter);
                
                if(formData.size()==0){
                	continue;
                }
                
                
                //先获取收款的经销商
                Set<String> setKdsq=new HashSet<>();
                for (int j = 0; j < formData.size(); j++) {
                	setKdsq.add(formData.get(j).get("_widget_1548037673508").toString());
    			}
                //找出经销商所对应的门店数,key值为经销商，value值为当前经销商下的门店集合，集合元素由"门店编码-门店名称"构成
                Map<String,List<String>> mapKdsq=new HashMap<>();
                for(String jxs:setKdsq){
                	List<String> mdList=new ArrayList<>();
                	for (int j = 0; j < formData0.size(); j++) {
    					if(jxs.equals(formData0.get(j).get("_widget_1543981212621").toString())){
    						mdList.add(formData0.get(j).get("_widget_1543818219389").toString()+"&"+formData0.get(j).get("_widget_1543818219658").toString());
    					}
    				}
                	mapKdsq.put(jxs, mdList);
                }
                
                
                Set<String> jxsbm_A=new HashSet<String>();//A级城市
        		Set<String> jxsbm_B=new HashSet<String>();//B级城市
        		Set<String> jxsbm_C=new HashSet<String>();//C级城市
        		for (int j = 0; j < formData.size(); j++) {
        			if("A".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_A.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}else if("B".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_B.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}else if("C".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_C.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}
        		}
        		
        		LinkedHashMap<String, String> map_A=gethkpm(jxsbm_A, mapKdsq, formData);
        		LinkedHashMap<String, String> map_B=gethkpm(jxsbm_B, mapKdsq, formData);
        		LinkedHashMap<String, String> map_C=gethkpm(jxsbm_C, mapKdsq, formData);
        		
        		
        		StringBuilder str_a=new StringBuilder("  \n	");
        		for (Map.Entry<String, String> entry : map_A.entrySet()) {
        			if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))<10){
        				str_a.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"      "+entry.getKey()+"  \n	");
        			}else if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))==10){
        				str_a.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"    "+entry.getKey()+"  \n	");
        			}
        	    }
        		
        		StringBuilder str_b=new StringBuilder("  \n	");
        		for (Map.Entry<String, String> entry : map_B.entrySet()) {
        			if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))<10){
        				str_b.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"      "+entry.getKey()+"  \n	");
        			}else if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))==10){
        				str_b.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"    "+entry.getKey()+"  \n	");
        			}
        	    }
        		
        		StringBuilder str_c=new StringBuilder("  \n	");
        		for (Map.Entry<String, String> entry : map_C.entrySet()) {
        			if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))<10){
        				str_c.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"      "+entry.getKey()+"  \n	");
        			}else if(Integer.valueOf(entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length()))==10){
        				str_c.append("NO."+entry.getValue().substring(entry.getValue().indexOf("&")+1, entry.getValue().length())+"    "+entry.getKey()+"  \n	");
        			}
        	    }
        		
        		String str="🏆**"+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE)+pp.get(i)+"回款业绩排行榜**🏆"
        				+ "  \n	                ⭐⭐⭐**A级城市门店**⭐⭐⭐          "+str_a.toString()
        				+ "            ⭐⭐⭐**B级城市门店**⭐⭐⭐          "+str_b.toString()
        				+ "            ⭐⭐⭐**C级城市门店**⭐⭐⭐          "+str_c.toString()
        				+ "  \n	"
        				+ "  \n	[鼓掌][鼓掌][鼓掌]为第一名喝彩[鼓掌][鼓掌][鼓掌]"
        				+ "  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜  \n	业绩冲冲，上榜、上榜";
        		DingTalkClient client = new DefaultDingTalkClient(jqrUrl);
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle(pp.get(i)+DateUtils.getMonth()+"月回款业绩排行榜");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n	"+str;
        		actioncard.setText(json);
        		request.setActionCard(actioncard);
        		client.execute(request);
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    //门店店均回款排名
	public LinkedHashMap<String,String> gethkpm(Set<String> jxsbms, Map<String,List<String>> mapKdsq,List<Map<String, Object>> formData){
		List<Jxspm> jxspms = new ArrayList<>();
		for (String jxsbm : jxsbms) {
			//排除当前收款的经销商是否有营业中的门店
			if(mapKdsq.get(jxsbm)==null || mapKdsq.get(jxsbm).size()==0){
				continue;
			}
			int num=0;
			for (int j = 0; j < formData.size(); j++) {
				if(jxsbm.equals(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")))){
					num+=ObjectUtils.getDouble(ObjectUtils.getString(formData.get(j).get("_widget_1564390193051"))).intValue();
				}
			}
			//当前经销商的店均
			Integer dj=num/mapKdsq.get(jxsbm).size();
			List<String> list=mapKdsq.get(jxsbm);
			for (int j = 0; j < list.size(); j++) {
				Jxspm jxspm=new Jxspm();
				jxspm.setDj(dj);
				jxspm.setJxsbm(jxsbm);
				jxspm.setMdbm(list.get(j).substring(0, list.get(j).indexOf("&")));
				jxspm.setMdmc(list.get(j).substring(list.get(j).indexOf("&")+1, list.get(j).length()));
				jxspms.add(jxspm);
			}
		}
		
		LinkedHashMap<String,String> map=new LinkedHashMap<>();
        List<Entry<Integer, List<Jxspm>>> list = jxspms.stream()
                .collect(Collectors.groupingBy(Jxspm::getDj))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
                .collect(Collectors.toList());
        int index = 1;
        int num=0;
        for (Entry<Integer, List<Jxspm>> entry : list) {
        	for (int i = 0; i < entry.getValue().size(); i++) {
        		 String mdmc=entry.getValue().get(i).getMdmc().replace("MS", "").replace("PD", "").replace("HMW", "");
        		 map.put(mdmc, entry.getValue().get(i).getDj()+"&"+index);
        		 num++;
			}
            index+=num;
            num=0;
        }
		return map;
	}
	
	//门店业绩排名
	public LinkedHashMap<String,Integer> getmdyjpm(Map<String,Double> maps){
		List<Jxspm> jxspms = new ArrayList<>();
		for (Map.Entry<String, Double> entry : maps.entrySet()) {
	        Jxspm jxspm=new Jxspm();
			jxspm.setMdmc(entry.getKey());
			jxspm.setTotal(entry.getValue());
			jxspms.add(jxspm);
	    }
		
		LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        List<Entry<Double, List<Jxspm>>> list = jxspms.stream()
                .collect(Collectors.groupingBy(Jxspm::getTotal))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
                .collect(Collectors.toList());
        int index = 1;
        int num=0;
        for (Entry<Double, List<Jxspm>> entry : list) {
        	for (int i = 0; i < entry.getValue().size(); i++) {
        		 String mdmc=entry.getValue().get(i).getMdmc().replace("MS", "").replace("PD", "").replace("HMW", "");
        		 map.put(mdmc+"("+entry.getValue().get(i).getTotal()+")", index);
        		 num++;
			}
            index+=num;
            num=0;
        }
		return map;
	}
	
	
	//排序
	public static List<Map.Entry<String,Double>> mapSort(Map<String,Double> map){
		//将map.entrySet()转换成list
        List<Map.Entry<String,Double>> list = new ArrayList<Map.Entry<String,Double>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
            //升序排序
            public int compare(Entry<String, Double> o1,
                    Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return list;
	}
	
}
