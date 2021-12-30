package com.jxszj.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/*
 * Y2.2工作周计划提报（每天下午6点半执行）
 */
public class YyjlzjhrzQuartz {

	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

    private static final String ENTRYID = "61724ea4e11d57000706ea12";
    
	//3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";
    
    
    //C1.1门店人员进群
    private static final String C1_1_ENTRYID = "613965b6976a2c00084d636a";
    
    //C6门店实时销售提报
    private static final String C6_ENTRYID = "5d2d229eee266915714e9e1e";
    
	public void execute() {
		
		//每个运营员工对应的门店数
		Map<String,Integer> yymds=getYymds();
		
		//运营对应的小于4人的门店
		Map<String,String> maps=getMap1();
		
		JDYAPIUtils C6 = new JDYAPIUtils(APPID, C6_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "_widget_1563246850783");
		map1.put("type", "text");
		map1.put("method", "eq");
		map1.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
		condList1.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("field", "flowState");
		map2.put("type", "text");
		map2.put("method", "eq");
		map2.put("value", 1);
		condList1.add(map2);
		Map<String, Object> filter1 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList1);
			}
		};
		List<Map<String, Object>> listC6 = C6.getAllFormData(null,filter1);
		
		//门店编码对应的门店名称
   		List<Map<String, Object>> formData0=getDate();
   		Map<String,String> mdmc=new HashMap<>();
   		for (int i = 0; i < formData0.size(); i++) {
   			mdmc.put(formData0.get(i).get("_widget_1543818219389").toString(), formData0.get(i).get("_widget_1543818219658").toString());
   		}
   		
		
		JDYAPIUtils rz = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date());
    	
    	if(calendar.get(Calendar.DAY_OF_WEEK)==3){
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1639205132548");
    		map0.put("type", "text");
    		map0.put("method", "eq");
    		map0.put("value", "是");
    		condList.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		List<Map<String, Object>> zjh = rz.getAllFormData(null,filter);
    		for (int i = 0; i < zjh.size(); i++) {
    			Map<String, Object>rawData = new HashMap<String, Object>();
    			Map<String, Object> m0 = new HashMap<String, Object>();
    			m0.put("value", "");
    			rawData.put("_widget_1639205132548", m0);
    			rz.updateData(zjh.get(i).get("_id").toString(), rawData);
			}
    		
    		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
    		map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1639205132548");
    		map0.put("type", "text");
    		map0.put("method", "eq");
    		map0.put("value", "否");
    		condList0.add(map0);
    		filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList0);
    			}
    		};
    		zjh = rz.getAllFormData(null,filter);
    		for (int i = 0; i < zjh.size(); i++) {
    			Map<String, Object>rawData = new HashMap<String, Object>();
    			Map<String, Object> m0 = new HashMap<String, Object>();
    			m0.put("value", "是");
    			rawData.put("_widget_1639205132548", m0);
    			rz.updateData(zjh.get(i).get("_id").toString(), rawData);
			}
    		
    	}
		//门店销售未达标门店
   		Map<String,List<String>> wdbmd=getMap2(listC6,Integer.valueOf(DateUtils.getNowDateToString("d")));
   		
   		//门店销售完成良好门店
   		Map<String,List<String>> wclhmd=getMap3(listC6,Integer.valueOf(DateUtils.getNowDateToString("d")));
   		
		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1639205132548");
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "是");
		condList.add(map0);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};
		List<Map<String, Object>> zjh = rz.getAllFormData(null,filter);
		
		for (int i = 0; i < zjh.size(); i++) {
			Map<String, Object>rawData = new HashMap<String, Object>();
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", yymds.get(zjh.get(i).get("_widget_1632800603235").toString()));
			rawData.put("_widget_1638167340592", m0);
			Map<String, Object> m1 = new HashMap<String, Object>();
			m1.put("value", maps.get(zjh.get(i).get("_widget_1632800603235").toString()));
			rawData.put("_widget_1638167340720", m1);
			if(wdbmd.get(zjh.get(i).get("_widget_1632800603235").toString())!=null){
				List<String> lists=wdbmd.get(zjh.get(i).get("_widget_1632800603235").toString());
				StringBuilder sb=new StringBuilder();
				for(String str:lists){
					sb.append(mdmc.get(str.split("/")[0])+"("+str.split("/")[1]+") \n");
				}
				Map<String, Object> m2 = new HashMap<String, Object>();
				m2.put("value", sb);
				rawData.put("_widget_1638167340762", m2);
			}
			if(wclhmd.get(zjh.get(i).get("_widget_1632800603235").toString())!=null){
				List<String> lists=wclhmd.get(zjh.get(i).get("_widget_1632800603235").toString());
				StringBuilder sb=new StringBuilder();
				for(String str:lists){
					sb.append(mdmc.get(str.split("/")[0])+"("+str.split("/")[1]+") \n");
				}
				Map<String, Object> m3 = new HashMap<String, Object>();
				m3.put("value", sb);
				rawData.put("_widget_1638167340893", m3);
			}
			Map<String, Object> m4 = new HashMap<String, Object>();
			m4.put("value", zjh.get(i).get("_widget_1632800603235").toString()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
			rawData.put("_widget_1639205132257", m4);
			rz.updateData(zjh.get(i).get("_id").toString(), rawData);
		}

	}
	
	//C1.1门店人员进群,计算营运的的门店店员小于4的门店
	public Map<String,String> getMap1(){
		 Map<String,String> maps=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C1_1_ENTRYID, APIKEY);
           List<Map<String, Object>> formData = api.getAllFormData(null,null);
           
           Set<String> set1=new HashSet<>();
           Set<String> set2=new HashSet<>();
           Set<String> set3=new HashSet<>();
           for (int i = 0; i < formData.size(); i++) {
           	set1.add(formData.get(i).get("_widget_1627886456443").toString());
           	set2.add(formData.get(i).get("_widget_1628169392779").toString());
           	set3.add(formData.get(i).get("_widget_1628169392851").toString());
			}
           //判断当前的运营员工是否是p01
           for(String yy:set1){
           	StringBuilder sb=new StringBuilder();
           	Map<String,Integer> map=new HashMap<String,Integer>();
           	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1627886456443").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
						map.put(formData.get(i).get("_widget_1627887110072").toString(), ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231")));
//						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
					}
				}
           	List<Entry<String, Integer>> list=mapSort(map);
           	for (int i = 0; i < list.size(); i++) {
           		sb.append(list.get(i).getKey()+"("+list.get(i).getValue()+")\n");
				}
           	maps.put(yy, sb.toString());
           }
         //判断当前的运营员工是否是p02
           for(String yy:set2){
           	StringBuilder sb=new StringBuilder();
           	Map<String,Integer> map=new HashMap<String,Integer>();
           	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628169392779").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
						map.put(formData.get(i).get("_widget_1627887110072").toString(), ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231")));
//						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
					}
				}
           	List<Entry<String, Integer>> list=mapSort(map);
           	for (int i = 0; i < list.size(); i++) {
           		sb.append(list.get(i).getKey()+"("+list.get(i).getValue()+")\n");
				}
           	maps.put(yy, sb.toString());
           }
           
         //判断当前的运营员工是否是p03
           for(String yy:set3){
           	StringBuilder sb=new StringBuilder();
           	Map<String,Integer> map=new HashMap<String,Integer>();
           	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628169392851").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
//						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
						map.put(formData.get(i).get("_widget_1627887110072").toString(), ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231")));
					}
				}
           	List<Entry<String, Integer>> list=mapSort(map);
           	for (int i = 0; i < list.size(); i++) {
           		sb.append(list.get(i).getKey()+"("+list.get(i).getValue()+")\n");
				}
           	maps.put(yy, sb.toString());
           }
   		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	
	public Map<String,List<String>> getMap2(List<Map<String, Object>> formData,int num){
		Map<String,List<String>> maps=new HashMap<>();
		DecimalFormat df = new DecimalFormat("#,###"); 
		try {
            
            Set<String> yys1=new HashSet<>();
            Set<String> yys2=new HashSet<>();
            Set<String> yys3=new HashSet<>();
            for (int i = 0; i < formData.size(); i++) {
            	yys1.add(formData.get(i).get("_widget_1563246848890").toString());
            	yys2.add(formData.get(i).get("_widget_1628170770663").toString());
            	yys3.add(formData.get(i).get("_widget_1628170770916").toString());
			}
            int number=60000/7*num;
            //计算p01
            for(String yy:yys1){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1563246848890").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
            //计算p02
            for(String yy:yys2){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628170770663").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
            //计算p03
            for(String yy:yys3){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628170770916").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	public Map<String,List<String>> getMap3(List<Map<String, Object>> formData,int num){
		Map<String,List<String>> maps=new HashMap<>();
		DecimalFormat df = new DecimalFormat("#,###"); 
		try {
            
            Set<String> yys1=new HashSet<>();
            Set<String> yys2=new HashSet<>();
            Set<String> yys3=new HashSet<>();
            for (int i = 0; i < formData.size(); i++) {
            	yys1.add(formData.get(i).get("_widget_1563246848890").toString());
            	yys2.add(formData.get(i).get("_widget_1628170770663").toString());
            	yys3.add(formData.get(i).get("_widget_1628170770916").toString());
			}
            int number=100000/7*num;
            //计算p01
            for(String yy:yys1){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1563246848890").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
            //计算p02
            for(String yy:yys2){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628170770663").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
            //计算p03
            for(String yy:yys3){
            	List<String> lists=new ArrayList<>();
            	List<String> list=new ArrayList<>();
            	Set<String> set=new HashSet<>();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628170770916").toString())){
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1563246851087")).intValue());
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	Map<String,Integer> map=new HashMap<String,Integer>();
            	for(String md:set){
            		int ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Integer.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
//            			lists.add(md+"/"+df.format(ddje));
            			map.put(md, ddje);
            		}
            	}
            	List<Entry<String, Integer>> list1=mapSort(map);
            	for (int i = 0; i < list1.size(); i++) {
            		lists.add(list1.get(i).getKey()+"/"+df.format(list1.get(i).getValue()));
				}
            	maps.put(yy, lists);
            }
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	public List<Map<String, Object>> getDate(){
		//查询营业中的门店,且实际开业时间小于当前日期
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1560998925033");//运营状态：营业中
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "营业中");
		condList0.add(map0);
//		String[] str=new String[2];
//		str[0]="null";
//		str[1]=DateUtils.getNowDateToString();
//		Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
//		map1.put("field", "_widget_1578996437131");
//		map1.put("type", "text");
//		map1.put("method", "range");
//		map1.put("value",str);
//		condList0.add(map1);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
		return formData0;
	}
	
	
	public Map<String,Integer> getYymds(){
		//查询营业中的门店,且实际开业时间小于当前日期
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1560998925033");//运营状态：营业中
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "营业中");
		condList0.add(map0);
		String[] str=new String[2];
		str[0]="null";
		str[1]=DateUtils.getNowDateToString();
		Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
		map1.put("field", "_widget_1578996437131");
		map1.put("type", "text");
		map1.put("method", "range");
		map1.put("value",str);
		condList0.add(map1);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		List<Map<String, Object>> formData = kdsq.getAllFormData(null,filter0);
		 Set<String> yys1=new HashSet<>();
         Set<String> yys2=new HashSet<>();
         Set<String> yys3=new HashSet<>();
         for (int i = 0; i < formData.size(); i++) {
         	yys1.add(formData.get(i).get("_widget_1560906554863").toString());
         	yys2.add(formData.get(i).get("_widget_1628167934994").toString());
         	yys3.add(formData.get(i).get("_widget_1628167935327").toString());
		}
        Map<String,Integer> yymds=new HashMap<>();
        //计算p01
        for(String yy:yys1){
        	Integer mds=0;
        	for (int i = 0; i < formData.size(); i++) {
				if(yy.equals(formData.get(i).get("_widget_1560906554863").toString())){
					mds++;
				}
			}
        	yymds.put(yy, mds);
        }
        
       //计算p02
        for(String yy:yys2){
        	Integer mds=0;
        	for (int i = 0; i < formData.size(); i++) {
				if(yy.equals(formData.get(i).get("_widget_1628167934994").toString())){
					mds++;
				}
			}
        	yymds.put(yy, mds);
        }
        //计算p03
        for(String yy:yys3){
        	Integer mds=0;
        	for (int i = 0; i < formData.size(); i++) {
				if(yy.equals(formData.get(i).get("_widget_1628167935327").toString())){
					mds++;
				}
			}
        	yymds.put(yy, mds);
        }
        
        return yymds;
	}
	
	public static List<Map.Entry<String,Integer>> mapSort(Map<String,Integer> map){
		//将map.entrySet()转换成list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return list;
	}
}
