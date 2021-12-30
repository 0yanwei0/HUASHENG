package com.jxszj.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxszj.mapper.sap.YyjfTbMapper;
import com.jxszj.pojo.Jxspm;
import com.jxszj.pojo.sap.YyjfTb;
import com.jxszj.pojo.sap.YyjfTbExample;
import com.jxszj.pojo.sap.YyjfTbExample.Criteria;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

//运营经理月度能力评分表
@Service
public class YynlydpfbQuartz {
	
	@Autowired
	private YyjfTbMapper yyjfTbMapper;

	// 简道云
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
	
	//M3月度目标维护
	private static final String ENTRYID_YDMB="609a4176637de90009c21f63";
	
	//DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
	//C7店长能量月度评分表
    private static final String C7_ENTRYID = "610cf9a301856800079f7cfe";

	//C7店长能量月度评分表
    private static final String KDSQ_ENTRYID = "5d102d3f2144352834656205";
    
    //Y5运营能力月度评分表
    private static final String Y5_ENTRYID = "6119fe197085790007ab77e5";
    
    //Y1专业知识考核认证
    private static final String Y1_ENTRYID = "611a078dc112f80008e155ef";
    
    //Y2工作日志
    private static final String Y2_ENTRYID = "611a09c5e12ca00007ac7a01";
    
    //Y3特别贡献
    private static final String Y3_ENTRYID = "611a18f53ca5a800079f71e6";
    
    //Y4处罚
    private static final String Y4_ENTRYID = "611a31661a171c0008c1bbfe";
    
    
    //C4促销活动
    private static final String C4_ENTRYID = "610915165435d900078c22ac";
    

    public void execute(){
    	String year=DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR);
		String month=DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE1);
		mainFun(year,month);
		if(DateUtils.isFirstDayOfMonth()){
			month=DateUtils.getBeforeMonth();
			year=DateUtils.getDateStringToString(month,DateUtils.FORMAT_STRING_YEAR);
			mainFun(year,month);
		}
    }
    
	public void mainFun(String year,String month) {
		DecimalFormat df = new DecimalFormat("#0.00");
		try {
			JDYAPIUtils c7_api = new JDYAPIUtils(APPID, C7_ENTRYID, APIKEY);
			JDYAPIUtils kdsq_api = new JDYAPIUtils(APPID, KDSQ_ENTRYID, APIKEY);
			JDYAPIUtils c4_api = new JDYAPIUtils(APPID, C4_ENTRYID, APIKEY);
			JDYAPIUtils y1_api = new JDYAPIUtils(APPID, Y1_ENTRYID, APIKEY);
			JDYAPIUtils y2_api = new JDYAPIUtils(APPID, Y2_ENTRYID, APIKEY);
			JDYAPIUtils y3_api = new JDYAPIUtils(APPID, Y3_ENTRYID, APIKEY);
			JDYAPIUtils y4_api = new JDYAPIUtils(APPID, Y4_ENTRYID, APIKEY);
			JDYAPIUtils y5_api = new JDYAPIUtils(APPID, Y5_ENTRYID, APIKEY);
			
			List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("field", "_widget_1629096500841");// 年-月
			m.put("type", "text");
			m.put("method", "eq");
			m.put("value", month);
			condList0.add(m);
			Map<String, Object> filter0 = new HashMap<String, Object>();
			filter0.put("rel", "and");
			filter0.put("cond", condList0);
			List<Map<String, Object>> formDataY1 = y1_api.getAllFormData(null, filter0);
			
			condList0 = new ArrayList<Map<String, Object>>();
			m = new HashMap<String, Object>();
			m.put("field", "_widget_1629442513994");// 年月
			m.put("type", "text");
			m.put("method", "eq");
			m.put("value", month);
			condList0.add(m);
			filter0 = new HashMap<String, Object>();
			filter0.put("rel", "and");
			filter0.put("cond", condList0);
			List<Map<String, Object>> formDataY2 = y2_api.getAllFormData(null, filter0);
			
			condList0 = new ArrayList<Map<String, Object>>();
			Map<String, Object> m1 = new HashMap<String, Object>();
			m = new HashMap<String, Object>();
			m.put("field", "_widget_1627905992838");// 年月
			m.put("type", "text");
			m.put("method", "eq");
			m.put("value", month);
			condList0.add(m);
			m1 = new HashMap<String, Object>();
			m1.put("field", "flowState");
			m1.put("type", "text");
			m1.put("method", "eq");
			m1.put("value", 1);
			condList0.add(m);
			filter0 = new HashMap<String, Object>();
			filter0.put("rel", "and");
			filter0.put("cond", condList0);
			List<Map<String, Object>> formDataY3 = y3_api.getAllFormData(null, filter0);
			
			
			condList0 = new ArrayList<Map<String, Object>>();
			m1 = new HashMap<String, Object>();
			m = new HashMap<String, Object>();
			m.put("field", "_widget_1627905992838");// 年月
			m.put("type", "text");
			m.put("method", "eq");
			m.put("value", month);
			condList0.add(m);
			m1 = new HashMap<String, Object>();
			m1.put("field", "flowState");
			m1.put("type", "text");
			m1.put("method", "eq");
			m1.put("value", 1);
			condList0.add(m);
			filter0 = new HashMap<String, Object>();
			filter0.put("rel", "and");
			filter0.put("cond", condList0);
			List<Map<String, Object>> formDataY4 = y4_api.getAllFormData(null, filter0);
			
			List<String> pp = new ArrayList<String>();
			pp.add("MS");
			pp.add("PD");
			pp.add("HMW");
			// 按品牌获取门店信息
			for (int j = 0; j < pp.size(); j++) {
				final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
				Map<String, Object> map0 = new HashMap<String, Object>();
				map0.put("field", "_widget_1560998925033");//运营状态：营业中
				map0.put("type", "text");
				map0.put("method", "eq");
				map0.put("value", "营业中");
				condList.add(map0);
				String[] str=new String[2];
				str[0]="null";
				str[1]=DateUtils.getLastDay(month,DateUtils.FORMAT_STRING_MINUTE1);
				Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当月最后一天
				map1.put("field", "_widget_1578996437131");
				map1.put("type", "text");
				map1.put("method", "range");
				map1.put("value",str);
				condList.add(map1);
				Map<String, Object> map2 = new HashMap<String, Object>();//品牌
				map2.put("field", "_widget_1543818220013");
				map2.put("type", "text");
				map2.put("method", "eq");
				map2.put("value",pp.get(j));
				condList.add(map2);
				Map<String, Object> filter = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList);
					}
				};
				List<Map<String, Object>> formData0 = kdsq_api.getAllFormData(null,filter);
				Map<String,String> maps=new HashMap<>();//员工编码对应的员工名称
				Set<String> set=new HashSet<>();//对应品牌下所有运营员工名称(员工编码)
				for (int i = 0; i < formData0.size(); i++) {
					set.add(formData0.get(i).get("_widget_1560906554863").toString());
					set.add(formData0.get(i).get("_widget_1628167934994").toString());
					set.add(formData0.get(i).get("_widget_1628167935327").toString());
					maps.put(formData0.get(i).get("_widget_1560906554863").toString(), formData0.get(i).get("_widget_1545358841001").toString());
					maps.put(formData0.get(i).get("_widget_1628167934994").toString(), formData0.get(i).get("_widget_1628167934919").toString());
					maps.put(formData0.get(i).get("_widget_1628167935327").toString(), formData0.get(i).get("_widget_1628167935237").toString());
				}
				
				
				final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
				map0 = new HashMap<String, Object>();
				map0.put("field", "_widget_1627886457630");// 品牌
				map0.put("type", "text");
				map0.put("method", "eq");
				map0.put("value", pp.get(j));
				condList1.add(map0);
				map1 = new HashMap<String, Object>();
				map1.put("field", "_widget_1627905992820");// 评分年月
				map1.put("type", "text");
				map1.put("method", "eq");
				map1.put("value", month);
				condList1.add(map1);
				Map<String, Object> filter1 = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList1);
					}
				};
				List<Map<String, Object>> formData = c7_api.getAllFormData(null, filter1);
				
				map2 = new HashMap<String, Object>();
				map2.put("field", "flowState");
				map2.put("type", "text");
				map2.put("method", "eq");
				map2.put("value", 1);
				condList1.add(map2);
				filter1 = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList1);
					}
				};
				List<Map<String, Object>> formDataC4 = c4_api.getAllFormData(null, filter1);
				
				
				
				//找出p01p02p03每个运营员工下的门店
				Map<String,Set<String>> mdMaps=new HashMap<>();
				Map<String,Set<String>> jxsMaps=new HashMap<>();
				Set<String> p01=new HashSet<>();
				Set<String> p02=new HashSet<>();
				Set<String> p03=new HashSet<>();
				for (int i = 0; i < formData0.size(); i++) {
					p01.add(formData0.get(i).get("_widget_1560906554863").toString());
					p02.add(formData0.get(i).get("_widget_1628167934994").toString());
					p03.add(formData0.get(i).get("_widget_1628167935327").toString());
				}
				for(String yyyg:p01){
					Set<String> md=new HashSet<>();
					Set<String> jxs=new HashSet<>();
					for(int i=0;i<formData0.size();i++){
						if(yyyg.equals(formData0.get(i).get("_widget_1560906554863").toString())){
							md.add(formData0.get(i).get("_widget_1543818219389").toString());
							jxs.add(formData0.get(i).get("_widget_1543981212621").toString());
						}
					}
					mdMaps.put(yyyg, md);
					jxsMaps.put(yyyg, jxs);
				}
				
				for(String yyyg:p02){
					Set<String> md=new HashSet<>();
					Set<String> jxs=new HashSet<>();
					for(int i=0;i<formData0.size();i++){
						if(yyyg.equals(formData0.get(i).get("_widget_1628167934994").toString())){
							md.add(formData0.get(i).get("_widget_1543818219389").toString());
							jxs.add(formData0.get(i).get("_widget_1543981212621").toString());
						}
					}
					mdMaps.put(yyyg, md);
					jxsMaps.put(yyyg, jxs);
				}
				
				for(String yyyg:p03){
					Set<String> md=new HashSet<>();
					Set<String> jxs=new HashSet<>();
					for(int i=0;i<formData0.size();i++){
						if(yyyg.equals(formData0.get(i).get("_widget_1628167935327").toString())){
							md.add(formData0.get(i).get("_widget_1543818219389").toString());
							jxs.add(formData0.get(i).get("_widget_1543981212621").toString());
						}
					}
					mdMaps.put(yyyg, md);
					jxsMaps.put(yyyg, jxs);
				}
				
				
				Map<String,String> maps1=getMap1(pp.get(j), month,mdMaps,jxsMaps);
				Map<String,Integer> maps2=getMap2(pp.get(j), formData,mdMaps);
				Map<String,Integer> maps3=getMap3(pp.get(j), formData);
				Map<String,Integer> maps4=getMap4(pp.get(j), formDataC4, set);
				Map<String,Double> maps5=getMap5(pp.get(j), formDataY1, set);
				Map<String,Integer> maps6=getMap6(pp.get(j), formDataY2, set);
				Map<String,Integer> maps7=getMap7(pp.get(j), formDataY3, set);
				Map<String,Integer> maps8=getMap8(pp.get(j), formDataY4, set);
				
				for (Map.Entry<String,String> map:maps.entrySet()) {
					String ygbm=map.getKey();
					String ybmc=map.getValue();
					String dj=Arrays.asList(maps1.get(ygbm).split("/")).get(2);
					String hkjf=Arrays.asList(maps1.get(ygbm).split("/")).get(0);
					String dsjf=Arrays.asList(maps1.get(ygbm).split("/")).get(1);
					String hk=Arrays.asList(maps1.get(ygbm).split("/")).get(3);
					String mds=Arrays.asList(maps1.get(ygbm).split("/")).get(4);
					String mb=Arrays.asList(maps1.get(ygbm).split("/")).get(5);
					int rspzjf=maps2.get(ygbm);
					int yjbjf=maps3.get(ygbm);
					int hdjf=maps4.get(ygbm);
					double khrzjf=maps5.get(ygbm);
					int rzjf=maps6.get(ygbm);
					int gxjf=maps7.get(ygbm);
					int cfjf=maps8.get(ygbm);
					Map<String, Object> rawData=addDate(year,month,ygbm, ybmc, dj, hkjf, dsjf, rspzjf, yjbjf, hdjf, khrzjf, rzjf, gxjf, cfjf,hk,mds,mb,pp.get(j));
					
					condList0 = new ArrayList<Map<String, Object>>();
					m = new HashMap<String, Object>();
					m.put("field", "_widget_1627886456443");// 运营员工编码
					m.put("type", "text");
					m.put("method", "eq");
					m.put("value", ygbm);
					condList0.add(m);
					m1 = new HashMap<String, Object>();
					m1.put("field", "_widget_1627905992820");// 评分年月
					m1.put("type", "text");
					m1.put("method", "eq");
					m1.put("value", month);
					condList0.add(m1);
					filter0 = new HashMap<String, Object>();
					filter0.put("rel", "and");
					filter0.put("cond", condList0);

					List<Map<String, Object>> formDataY5 = y5_api.getAllFormData(null, filter0);
					if(formDataY5.size()==0){
						y5_api.createCpData(rawData);
					}else{
						y5_api.updateData(formDataY5.get(0).get("_id").toString(), rawData);
					}
					
				}
				
			}
			
			
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("field", "_widget_1627905992820");// 评分年月
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", month);
			condList.add(map);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Jxspm> jxspms = new ArrayList<>();
			List<Map<String, Object>> formData = y5_api.getAllFormData(null, filter);
			for (int i = 0; i < formData.size(); i++) {
				Jxspm jxspm=new Jxspm();
				jxspm.setId(formData.get(i).get("_id").toString());
				jxspm.setJf(ObjectUtils.getObjectToDouble(formData.get(i).get("_widget_1628477304461")));
				jxspms.add(jxspm);
			}
			LinkedHashMap<String,Integer> maps=new LinkedHashMap<>();
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
	        		 maps.put(entry.getValue().get(i).getId(), index);
	        		 num++;
				}
	            index+=num;
	            num=0;
	        }
	        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
	        	Map<String, Object> rawData = new HashMap<String, Object>();
	        	Map<String, Object> map1 = new HashMap<String, Object>();
	        	map1.put("value",entry.getValue());
	    		rawData.put("_widget_1628477304402", map1);// 总积分排名
	    		y5_api.updateData(entry.getKey(), rawData);
    	    }

	        //
	        for (int i = 0; i < pp.size(); i++) {
	        	final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
				map = new HashMap<String, Object>();
				map.put("field", "_widget_1627905992820");// 评分年月
				map.put("type", "text");
				map.put("method", "eq");
				map.put("value", month);
				condList1.add(map);
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("field", "_widget_1637722386615");// 品牌
				map1.put("type", "text");
				map1.put("method", "eq");
				map1.put("value", pp.get(i));
				condList1.add(map1);
				Map<String, Object> filter1 = new HashMap<String, Object>() {
					{
						put("rel", "and");
						put("cond", condList1);
					}
				};
				formData = y5_api.getAllFormData(null, filter1);
				double zjf=0.0;
				for (int j = 0; j < formData.size(); j++) {
					zjf+=ObjectUtils.getObjectToDouble(formData.get(j).get("_widget_1628477304461"));
				}
				YyjfTb yyjfTb=new YyjfTb();
				yyjfTb.setPp(pp.get(i));
				yyjfTb.setNy(month);
				yyjfTb.setZrs(formData.size());
				yyjfTb.setZjf(zjf);
				yyjfTb.setRjjf(Double.valueOf(df.format(zjf/formData.size())));
				YyjfTbExample yyjfTbExample=new YyjfTbExample();
				Criteria criteria=yyjfTbExample.createCriteria();
				criteria.andNyEqualTo(month);
				criteria.andPpEqualTo(pp.get(i));
				List<YyjfTb> yyjfTbs=yyjfTbMapper.selectByExample(yyjfTbExample);
				if(yyjfTbs.size()==1){
					yyjfTbMapper.updateByExample(yyjfTb,yyjfTbExample);
            	}else if(yyjfTbs.size()==0){
            		yyjfTbMapper.insert(yyjfTb);
            	}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> addDate(String year,String yearMonth,String ygbm,String ybmc,String dj,String hkjf,String dsjf,int rspzjf,int yjbjf,int hdjf,double khrzjf,int rzjf,int gxjf,int cfjf,String hk,String mds,String mb,String pp){
		Map<String, Object> rawData = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("value",year);
		rawData.put("_widget_1627905992838", m1);// 评分年
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("value",yearMonth);
		rawData.put("_widget_1627905992820", m2);// 评分年月
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("value",ybmc);
		rawData.put("_widget_1627886456425", m3);// 运营员工名称
		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("value",ygbm);
		rawData.put("_widget_1627886456443", m4);// 运营员工编码
		Map<String, Object> m5 = new HashMap<String, Object>();
		m5.put("value",dj);
		rawData.put("_widget_1628240778489", m5);// 月度店均回款(元)
		Map<String, Object> m6 = new HashMap<String, Object>();
		m6.put("value",hkjf);
		rawData.put("_widget_1628240778831", m6);// 【能量积分】-月度店均回款
		Map<String, Object> m7 = new HashMap<String, Object>();
		m7.put("value",dsjf);
		rawData.put("_widget_1629109411878", m7);// 【能量积分】-负责店数
		Map<String, Object> m8 = new HashMap<String, Object>();
		m8.put("value",rspzjf);
		rawData.put("_widget_1629109412150", m8);// 【能量积分】-单店人数配置
		Map<String, Object> m9 = new HashMap<String, Object>();
		m9.put("value",yjbjf);
		rawData.put("_widget_1629109412628", m9);// 【能量积分】-店长英杰榜
		Map<String, Object> m10 = new HashMap<String, Object>();
		m10.put("value",hdjf);
		rawData.put("_widget_1629109413589", m10);// 【行动力积分】-促销活动
		Map<String, Object> m11 = new HashMap<String, Object>();
		m11.put("value",khrzjf);
		rawData.put("_widget_1629109413829", m11);// 【行动力积分】-专业知识考核认证
		Map<String, Object> m12 = new HashMap<String, Object>();
		m12.put("value",rzjf);
		rawData.put("_widget_1629109414145", m12);// 【行动力积分】-工作日志
		Map<String, Object> m13 = new HashMap<String, Object>();
		m13.put("value",gxjf);
		rawData.put("_widget_1629109414334", m13);// 【行动力积分】-特别贡献
		Map<String, Object> m14 = new HashMap<String, Object>();
		m14.put("value",cfjf);
		rawData.put("_widget_1629109414587", m14);// 【行动力积分】-处罚
		double zjf=Integer.valueOf(hkjf)+Integer.valueOf(dsjf)+rspzjf+yjbjf+hdjf+khrzjf+rzjf+gxjf+cfjf;
		Map<String, Object> m15 = new HashMap<String, Object>();
		m15.put("value",zjf);
		rawData.put("_widget_1628477304461", m15);// 总积分
		Map<String, Object> m16 = new HashMap<String, Object>();
		m16.put("value",hk);
		rawData.put("_widget_1635581163734", m16);// 月累计回款
		Map<String, Object> m17 = new HashMap<String, Object>();
		m17.put("value",mds);
		rawData.put("_widget_1635581163865", m17);// 负责门店数
		Map<String, Object> m18 = new HashMap<String, Object>();
		m18.put("value",mb);
		rawData.put("_widget_1635581163399", m18);// 月回款目标
		Map<String, Object> m19 = new HashMap<String, Object>();
		m19.put("value",pp);
		rawData.put("_widget_1637722386615", m19);// 负责品牌
		
		return rawData;
	}
	
	
	//返回map集合，key值是员工编码，value值为【能量积分】-月度店均回款/【能量积分】-负责店数/月度店均回款(元)
	public Map<String,String> getMap1(String pp, String month,Map<String,Set<String>> mdMaps,Map<String,Set<String>> jxsMaps){
		Map<String,String> maps=new HashMap<>();
		try {

			
			//找出当月有收款单的门店
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map1 = new HashMap<String, Object>();
    		map1.put("field", "_widget_1548049038941");//收款年月
    		map1.put("type", "text");
    		map1.put("method", "eq");
    		map1.put("value", month);
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
    		map3.put("value", pp);
    		condList1.add(map3);
    		Map<String, Object> filter1 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList1);
    			}
    		};
    		
            List<Map<String, Object>> formData1 = api.getAllFormData(null,filter1);
            
          //获取当月每个经销商的月目标值
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("field", "_widget_1620722144569");
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", "启用");
			condList.add(map);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			api = new JDYAPIUtils(APPID, ENTRYID_YDMB, APIKEY);
			List<Map<String, Object>> list=api.getAllFormData(null, filter);
			Map<String,Integer> ydmb=new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				ydmb.put(list.get(i).get("_widget_1620722144565").toString(), ObjectUtils.getObjectToInteger(list.get(i).get("_widget_1620722145500")));
			}
            
            for(Map.Entry<String, Set<String>> entry:jxsMaps.entrySet()){
            	Set<String> jxsbm=entry.getValue();
            	int hk=0;
            	int mb=0;
            	for(String jxs:jxsbm){
            		mb+=ydmb.get(jxs)==null?0:ydmb.get(jxs);
            		for (int i = 0; i < formData1.size(); i++) {
						if(jxs.equals(formData1.get(i).get("_widget_1548037673508").toString())){
							hk+=ObjectUtils.getDouble(ObjectUtils.getString(formData1.get(i).get("_widget_1564390193051"))).intValue();
						}
					}
            	}
            	int dj=hk/mdMaps.get(entry.getKey()).size();
            	int mds=mdMaps.get(entry.getKey()).size();
            	
            	int djdf=0;//店均得分
        		int dsdf=0;//店数得分
        		if(Integer.valueOf(dj)>100000){
        			djdf=Integer.valueOf(dj)/500;
        		}else if(Integer.valueOf(dj)>=70000 && Integer.valueOf(dj)<=100000){
        			djdf=Integer.valueOf(dj)/1000;
        		}else if(Integer.valueOf(dj)<70000){
        			djdf=Integer.valueOf(dj)/2000;
        		}
        		
        		if(Integer.valueOf(mds)>=15){
        			dsdf=Integer.valueOf(mds)*4;
        		}else if(Integer.valueOf(mds)>=11 && Integer.valueOf(mds)<=14){
        			dsdf=Integer.valueOf(mds)*3;
        		}else if(Integer.valueOf(mds)<=10){
        			dsdf=Integer.valueOf(mds)*2;
        		}
        		maps.put(entry.getKey(),djdf+"/"+dsdf+"/"+dj+"/"+hk+"/"+mds+"/"+mb);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	//【能量积分】-单店人数配置,返回map，key值为员工编码，value值为对应得分
	public Map<String,Integer> getMap2(String pp,List<Map<String, Object>> formData,Map<String,Set<String>> mdMaps){
		Map<String,Integer> maps=new HashMap<>(); 
		try {
			Map<String,Integer> map=new HashMap<>();
			for (int i = 0; i < formData.size(); i++) {
				map.put(formData.get(i).get("_widget_1627886455424").toString(), ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1628479756474")));
			}
			for(Map.Entry<String, Set<String>> entry:mdMaps.entrySet()){
				int dfs=0;
				Set<String> mds=entry.getValue();
				for(String md:mds){
					int df=map.get(md)==null?0:map.get(md);
					if(df<4){
						dfs+=((df-4)*2+df);
					}else{
						dfs+=df;
					}
				}
				maps.put(entry.getKey(), dfs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	
	//【能量积分】-店长英杰榜
	public Map<String , Integer > getMap3(String pp,List<Map<String, Object>> formData){
		Map<String,Integer> map=new HashMap<>(); 
		Set<String> set=new HashSet<>();
		Map<String,Integer> maps=new HashMap<>(); 
		try {
			//p01下的总积分排名
			for (int i = 0; i < formData.size(); i++) {
				String key=formData.get(i).get("_widget_1627886455424").toString()+formData.get(i).get("_widget_1627886456443").toString();
				Integer value=ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1628477304402"));
				map.put(key, value);//key值为门店编码员工编码，value值为总积分排名
				set.add(formData.get(i).get("_widget_1627886456443").toString());
			}
			//按照排名进行排序
			List<Map.Entry<String, Integer>> list=mapSort(map);
			if(pp.equals("PD")){
				//p02下的总积分排名
				for (int i = 0; i < formData.size(); i++) {
					String key=formData.get(i).get("_widget_1627886455424").toString()+formData.get(i).get("_widget_1628169595535").toString();
					Integer value=ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1628477304402"));
					map.put(key, value);//key值为门店编码员工编码，value值为积分总排名
					set.add(formData.get(i).get("_widget_1628169595535").toString());
				}
			}else if(pp.equals("MS")){
				//p02下H0362员工的总积分排名
				for (int i = 0; i < formData.size(); i++) {
					if("H0362".equals(formData.get(i).get("_widget_1628169595535").toString())){
						String key=formData.get(i).get("_widget_1627886455424").toString()+"H0362";
						Integer value=ObjectUtils.getObjectToInteger(formData.get(i).get("_widget_1628477304402"));
						map.put(key, value);
					}
				}
				set.add("H0362");
			}
			
			if(pp.equals("PD") || pp.equals("MS")){
				//取出最后一个元素的value值
				Integer last=list.get(list.size()-1).getValue();
				//判断总积分排名是否大于40
				if(last>40){
					Integer beforeCount=list.get(list.size()-20).getValue();//倒数前20名的第一名
					for(String str:set){
						int df=30;
						for (Map.Entry<String,Integer> m:map.entrySet()) {
							if(m.getKey().contains(str)){
								int mc=m.getValue();
								if(mc==1){
									df+=20;
								}else if(mc==2){
									df+=17;
								}else if(mc==3){
									df+=14;
								}else if(mc==4){
									df+=11;
								}else if(mc==5){
									df+=10;
								}else if(mc>=6 && mc<=10){
									df+=9;
								}else if(mc>=11 && mc<=15){
									df+=7;
								}else if(mc>=16 && mc<=20){
									df+=5;
								}else if(mc>=beforeCount){
									df-=10;
								}
							}
						}
						maps.put(str, df);
					}
				}else if(last<=40){
					for(String str:set){
						int df=30;
						for (Map.Entry<String,Integer> m:map.entrySet()) {
							if(m.getKey().contains(str)){
								int mc=m.getValue();
								if(mc==1){
									df+=20;
								}else if(mc==2){
									df+=17;
								}else if(mc==3){
									df+=14;
								}else if(mc==4){
									df+=11;
								}else if(mc==5){
									df+=10;
								}else if(mc>=6 && mc<=10){
									df+=9;
								}else if(mc>=11 && mc<=15){
									df+=7;
								}else if(mc>=16 && mc<=20){
									df+=5;
								}
							}
						}
						maps.put(str, df);
					}
				}
			}else{
				for(String str:set){
					int df=30;
					for (Map.Entry<String,Integer> m:map.entrySet()) {
						if(m.getKey().contains(str)){
							int mc=m.getValue();
							if(mc==1){
								df+=20;
							}else if(mc==2){
								df+=17;
							}else if(mc==3){
								df+=14;
							}else if(mc==4){
								df+=11;
							}
						}
					}
					maps.put(str, df);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	// 排序
	public static List<Map.Entry<String, Integer>> mapSort(Map<String, Integer> map) {
		// 将map.entrySet()转换成list
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			// 排序
			public int compare(Entry<String, Integer> o2, Entry<String, Integer> o1) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		return list;
	}
	
	//【行动力积分】-促销活动-
	public Map<String , Integer > getMap4(String pp,List<Map<String, Object>> formDataC4,Set<String> set){
		Map<String,Integer> map=new HashMap<>(); 
		try {
			//p01下的运营能力-促销活动积分
			for(String str:set){
				int df=0;
				for (int i = 0; i < formDataC4.size(); i++) {
					if(str.equals(formDataC4.get(i).get("_widget_1627886456443").toString())){
						df+=ObjectUtils.getObjectToInteger(formDataC4.get(i).get("_widget_1629093616109"));
					}
				}
				map.put(str, df);
			}
			if(pp.equals("PD")){
				//p02下的运营能力-促销活动积分
				Set<String> p02=new HashSet<>();
				for(int i = 0; i < formDataC4.size(); i++){
					p02.add(formDataC4.get(i).get("_widget_1628170323350").toString());
				}
				for(String str : p02){
					int df=0;
					for (int i = 0; i < formDataC4.size(); i++) {
						if(str.equals(formDataC4.get(i).get("_widget_1628170323350").toString())){
							df+=ObjectUtils.getObjectToInteger(formDataC4.get(i).get("_widget_1629093616109"));
						}
					}
					map.put(str, df);
				}
			}else if(pp.equals("MS")){
				int cxdf=0;
				for (int i = 0; i < formDataC4.size(); i++) {
					if("H0362".equals(formDataC4.get(i).get("_widget_1628170323350").toString())){
						cxdf+=ObjectUtils.getObjectToInteger(formDataC4.get(i).get("_widget_1629093616109"));
					}
				}
				map.put("H0362", cxdf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//【行动力积分】-专业知识考核认证
	public Map<String , Double > getMap5(String pp,List<Map<String, Object>> formDataY1,Set<String> set){
		Map<String,Double> map=new HashMap<>(); 
		try {
			for(String str:set){
				double df=0;
				for (int i = 0; i < formDataY1.size(); i++) {
					if(str.equals(formDataY1.get(i).get("_widget_1629095822365").toString())){
						df+=ObjectUtils.getObjectToDouble(formDataY1.get(i).get("_widget_1629095822862"));
					}
				}
				map.put(str, df);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	//【行动力积分】-工作日志
	public Map<String , Integer > getMap6(String pp,List<Map<String, Object>> formDataY2,Set<String> set){
		Map<String,Integer> map=new HashMap<>(); 
		try {
			for(String str:set){
				int df=0;
				for (int i = 0; i < formDataY2.size(); i++) {
					if(str.equals(formDataY2.get(i).get("_widget_1629095822365").toString())){
						df+=(ObjectUtils.getObjectToInteger(formDataY2.get(i).get("_widget_1629095822862"))+ObjectUtils.getObjectToInteger(formDataY2.get(i).get("_widget_1629097511377"))+ObjectUtils.getObjectToInteger(formDataY2.get(i).get("_widget_1629097511489")));
					}
				}
				map.put(str, df);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	//【行动力积分】-特别贡献
	public Map<String , Integer > getMap7(String pp,List<Map<String, Object>> formDataY3,Set<String> set){
		Map<String,Integer> map=new HashMap<>(); 
		try {
			for(String str:set){
				int df=0;
				for (int i = 0; i < formDataY3.size(); i++) {
					if(str.equals(formDataY3.get(i).get("_widget_1627996839137").toString())){
						df+=ObjectUtils.getObjectToInteger(formDataY3.get(i).get("_widget_1627985533320"));
					}
				}
				map.put(str, df);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	//【行动力积分】-处罚
	public Map<String , Integer > getMap8(String pp,List<Map<String, Object>> formDataY4,Set<String> set){
		Map<String,Integer> map=new HashMap<>(); 
		try {
			for(String str:set){
				int df=0;
				for (int i = 0; i < formDataY4.size(); i++) {
					if(str.equals(formDataY4.get(i).get("_widget_1627996839137").toString())){
						df+=ObjectUtils.getObjectToInteger(formDataY4.get(i).get("_widget_1627985529814"));
					}
				}
				map.put(str, df);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
