package com.jxszj.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/*
 * Y2.2工作周计划提报模板
 */
public class YyzjhrzTemplateQuartz {

	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

    private static final String ENTRYID = "61724ea4e11d57000706ea12";
    
    //运营经理钉钉编码对照表
    private static final String ENTRYID_DD="616135f81908e700083afa91";
    
	//3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";
    
    //C1.1门店人员进群
    private static final String C1_1_ENTRYID = "613965b6976a2c00084d636a";
    
    //C6门店实时销售提报
    private static final String C6_ENTRYID = "5d2d229eee266915714e9e1e";
    
    public static void main(String[] args) {
		new YyzjhrzTemplateQuartz().execute();
	}
    
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
   		
		JDYAPIUtils dd = new JDYAPIUtils(APPID, ENTRYID_DD, APIKEY);
		final List<Map<String, Object>> condList2 = new ArrayList<Map<String, Object>>();
   		map1 = new HashMap<String, Object>();
   		map1.put("field", "_widget_1635997338620");
   		map1.put("type", "text");
   		map1.put("method", "eq");
   		map1.put("value", "Y");
   		condList2.add(map1);
   		Map<String, Object> filter2 = new HashMap<String, Object>() {
   			{
   				put("rel", "and");
   				put("cond", condList2);
   			}
   		};
		List<Map<String, Object>> list =dd.getAllFormData(null, filter2);
		Map<String,String> ddbm=new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			ddbm.put(list.get(i).get("_widget_1633760760830").toString(), list.get(i).get("_widget_1633760760777")+"/"+list.get(i).get("_widget_1633760760758"));
		}
		
		JDYAPIUtils rz = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		//先生成周计划模板
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date());
    	int week=calendar.get(Calendar.WEEK_OF_YEAR);//得到当前周


   		
   		//门店销售未达标门店
   		Map<String,List<String>> wdbmd=getMap2(listC6,Integer.valueOf(DateUtils.getNowDateToString("d"))-1);
   		
   		//门店销售完成良好门店
   		Map<String,List<String>> wclhmd=getMap3(listC6,Integer.valueOf(DateUtils.getNowDateToString("d"))-1);
   		
		
		Map<String,String> map=new HashMap<>();
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		map.put("7", "星期天");
		map.put("8", "星期一");
		
		for (Map.Entry<String, String> yy:ddbm.entrySet()) {
			String str=yy.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR)+week;
			Map<String, Object>rawData = new HashMap<String, Object>();
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", yy.getValue().split("/")[0]);
			rawData.put("_widget_1632801394682", m0);
			Map<String, Object> m1 = new HashMap<String, Object>();
			m1.put("value", yy.getValue().split("/")[1]);
			rawData.put("_widget_1632800603215", m1);// 员工姓名
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("value", yy.getKey());
			rawData.put("_widget_1632800603235", m2);// 员工编码
			Map<String, Object> m3 = new HashMap<String, Object>();
			m3.put("value", DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),1)+"T00:00:00.000Z");
			rawData.put("_widget_1634881277576", m3);// 提报日期
//			Map<String, Object> m4 = new HashMap<String, Object>();
//			m4.put("value", DateUtils.getDateStringToStringFormat1(DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),1),DateUtils.FORMAT_STRING_YEAR));
//			rawData.put("_widget_1633664138148", m4);// 提报日期-年
//			Map<String, Object> m5 = new HashMap<String, Object>();
//			m5.put("value", DateUtils.getDateStringToStringFormat1(DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),1),DateUtils.FORMAT_STRING1_MINUTE));
//			rawData.put("_widget_1633664138196", m5);// 提报日期-年-月
//			Map<String, Object> m6 = new HashMap<String, Object>();
//			m6.put("value", DateUtils.getDateStringToStringFormat1(DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),1),DateUtils.FORMAT_2_1_STRING));
//			rawData.put("_widget_1633664138216", m6);// 提报日期-年-月-日
			Map<String, Object> m7 = new HashMap<String, Object>();
			m7.put("value", str.replace("年", ""));
			rawData.put("_widget_1634881275842", m7);// 运营经理工作周计划唯一性标识
			Map<String, Object> m8 = new HashMap<String, Object>();
			m8.put("value", DateUtils.getDateStringToStringFormat1(DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),1),DateUtils.FORMAT_STRING_YEAR)+week+"周");
			rawData.put("_widget_1634881275070", m8);// 提报日期-年-周
			List<Map<String, Object>> lists=new ArrayList<>();
			for(int j=1;j<=7;j++){
				Map<String, Object> item = new HashMap<String, Object>();
				Map<String, Object> m9 = new HashMap<String, Object>();
				m9.put("value", DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),j)+"T00:00:00.000Z");
				item.put("_widget_1635231504169", m9);// 日期
				Map<String, Object> m10 = new HashMap<String, Object>();
				m10.put("value", map.get(String.valueOf(j+1)));
				item.put("_widget_1635231504217", m10);// 星期
				Map<String, Object> m11 = new HashMap<String, Object>();
				m11.put("value", DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),j)+map.get(String.valueOf(j+1)));
				item.put("_widget_1635235123396", m11);// 计划日期
				lists.add(item);
			}
			Map<String, Object> m12 = new HashMap<String, Object>();
			m12.put("value", lists);
			rawData.put("_widget_1635231504052", m12);
			
			Map<String, Object> m13 = new HashMap<String, Object>();
			m13.put("value", yymds.get(yy.getKey()));
			rawData.put("_widget_1638167340592", m13);
			Map<String, Object> m14 = new HashMap<String, Object>();
			m14.put("value", maps.get(yy.getKey()));
			rawData.put("_widget_1638167340720", m14);
			if(wdbmd.get(yy.getKey())!=null){
				List<String> lists1=wdbmd.get(yy.getKey());
				StringBuilder sb=new StringBuilder();
				for(String str1:lists1){
					sb.append(mdmc.get(str1.split("/")[0])+"("+str1.split("/")[1]+") \n");
				}
				
				Map<String, Object> m15 = new HashMap<String, Object>();
    			m15.put("value", sb);
    			rawData.put("_widget_1638167340762", m15);
			}
			if(wclhmd.get(yy.getKey())!=null){
				List<String> lists1=wclhmd.get(yy.getKey());
				StringBuilder sb=new StringBuilder();
				for(String str1:lists1){
					sb.append(mdmc.get(str1.split("/")[0])+"("+str1.split("/")[1]+") \n");
				}
				Map<String, Object> m16 = new HashMap<String, Object>();
    			m16.put("value", sb);
    			rawData.put("_widget_1638167340893", m16);
			}
			Map<String, Object> m17 = new HashMap<String, Object>();
			m17.put("value", "否");
			rawData.put("_widget_1639205132548", m17);
			rz.createDataByworkflow(rawData);
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
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1627886456443").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
					}
				}
            	maps.put(yy, sb.toString());
            }
          //判断当前的运营员工是否是p02
            for(String yy:set2){
            	StringBuilder sb=new StringBuilder();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628169392779").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
					}
				}
            	maps.put(yy, sb.toString());
            }
            
          //判断当前的运营员工是否是p03
            for(String yy:set3){
            	StringBuilder sb=new StringBuilder();
            	for (int i = 0; i < formData.size(); i++) {
					if(yy.equals(formData.get(i).get("_widget_1628169392851").toString()) && ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))<4){
						sb.append(formData.get(i).get("_widget_1627887110072").toString()+"("+ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1631151630231"))+")\n");
					}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje<number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
						list.add(formData.get(i).get("_widget_1563246847900")+"/"+formData.get(i).get("_widget_1563246851087"));
						set.add(formData.get(i).get("_widget_1563246847900").toString());
					}
				}
            	for(String md:set){
            		double ddje=0;
            		for (int i = 0; i < list.size(); i++) {
						if(md.equals(list.get(i).split("/")[0])){
							ddje+=Double.valueOf(list.get(i).split("/")[1]);
						}
					}
            		if(ddje>=number){
            			lists.add(md+"/"+df.format(ddje));
            		}
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
		str[1]=DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(), 1);
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
}
