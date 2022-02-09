package com.jxszj.quartz;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map.Entry;

import com.jxszj.mapper.sap.DznljfTbMapper;
import com.jxszj.pojo.Jxspm;
import com.jxszj.pojo.sap.DznljfTb;
import com.jxszj.pojo.sap.DznljfTbExample;
import com.jxszj.pojo.sap.DznljfTbExample.Criteria;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/**
 * 店长能量评分
 * <pre>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanwei
 * <b>Date:</b> 2021年8月7日下午3:48:18
 * </pre>
 */
@Service
public class DznlpfQuartz {
	
	@Autowired
	private DznljfTbMapper dznljfTbMapper;
	
	//C1门店店长信息
    private static final String C1_ENTRYID = "61079376b4cdc700085a8dd8";
	//C7店长能量月度评分表
    private static final String C7_ENTRYID = "610cf9a301856800079f7cfe";
    
    //DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
    //3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";
    
    //品牌排名分值管理
    private static final String PMFZ_KDSQ = "610e5ed38d36840007f58544";
    
    //DS2-门店实时销售提报
    private static final String ENTRYID_DS2 = "5d2d229eee266915714e9e1e";
    
    //C2每日晨会
    private static final String C2_ENTRYID = "6107df91d9e6920008ef467f";
    
    //C3专业知识视频
    private static final String C3_ENTRYID = "6109090976c77b0008982793";
    
    //C4促销活动
    private static final String C4_ENTRYID = "610915165435d900078c22ac";
    
    //C1.1门店人员进群
    private static final String C1_1_ENTRYID = "613965b6976a2c00084d636a";
    
    
    //C5特别贡献
    private static final String C5_ENTRYID = "61093f60c526370008e12767";
    
    private static final String APPID = "5cc110c3b3c41744aaa12b2e";
    private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
    
    
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
	
	public void mainFun(String year,String month){
		try {
			JDYAPIUtils c7_api = new JDYAPIUtils(APPID, C7_ENTRYID, APIKEY);
			final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("field", "_widget_1627905992820");//评分年月
    		map.put("type", "text");
    		map.put("method", "eq");
    		map.put("value", month);
    		condList0.add(map);
    		Map<String, Object> filter0 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList0);
    			}
    		};
    		
            List<Map<String, Object>> c7_List = c7_api.getAllFormData(null,filter0);
            for (int i = 0; i < c7_List.size(); i++) {
            	c7_api.deleteData(c7_List.get(i).get("_id").toString());
			}
            
			List<String> pp=new ArrayList<String>();
        	pp.add("MS");
        	pp.add("PD");
        	pp.add("HMW");
        	Map<String,String> djpm1=getMap1(pp,month);
        	Map<String,Double>  mdddje=getMap2(month);
        	Map<String,String> chjf=getMap3(month);
        	Map<String,String> mdrss=getMap3_1();
        	Map<String, Integer> spjfmap=getMap4(month);
        	Map<String, Integer> cxhdjfmap=getMap5(month);
        	Map<String, Double> tbgxjfmap=getMap6(month);
			//获取所有的C1门店店长信息
	        JDYAPIUtils c1_api = new JDYAPIUtils(APPID, C1_ENTRYID, APIKEY);
	        JDYAPIUtils pmfz_api = new JDYAPIUtils(APPID, PMFZ_KDSQ, APIKEY);
	        //查询开店时间小于当前月份的门店
	        String[] str=new String[2];
			str[0]="2000-01";
			str[1]=DateUtils.getDateStrToString1(month);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
			map1.put("field", "_widget_1633514214241");
			map1.put("type", "text");
			map1.put("method", "range");
			map1.put("value",str);
			condList1.add(map1);
			Map<String, Object> map2 = new HashMap<String, Object>();//实际开业时间：小于当前日期
			map2.put("field", "_widget_1627999680934");
			map2.put("type", "text");
			map2.put("method", "eq");
			map2.put("value","启用");
			condList1.add(map2);
			Map<String, Object> filter1 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList1);
    			}
    		};
	        List<Map<String, Object>> mdList = c1_api.getAllFormData(null, filter1);
	        //获取品牌排名分值管理
	        Map<String,String> pmfzMap=new HashMap<>();
	        List<Map<String, Object>> pmfzList = pmfz_api.getAllFormData(null, null);
	        for (int i = 0; i < pmfzList.size(); i++) {
	        	pmfzMap.put(pmfzList.get(i).get("_widget_1628331731514").toString()+pmfzList.get(i).get("_widget_1628331731496").toString(), pmfzList.get(i).get("_widget_1628331731532").toString());
			}
	        for (int i = 0; i < mdList.size(); i++) {
                String ppdjpm=djpm1.get(mdList.get(i).get("_widget_1627886455424").toString());
            	Double ddje=mdddje.get(mdList.get(i).get("_widget_1627886455424").toString());
            	String mrch=chjf.get(mdList.get(i).get("_widget_1627886455424").toString());
            	Integer jf=spjfmap.get(mdList.get(i).get("_widget_1627886455424").toString());
            	Integer cxhdjf=cxhdjfmap.get(mdList.get(i).get("_widget_1627886455424").toString());
            	Double tbgxjf=tbgxjfmap.get(mdList.get(i).get("_widget_1627886455424").toString());
            	String mdrs=mdrss.get(mdList.get(i).get("_widget_1627886455424").toString());
            	c7_api.createData(addDate(year,month,mdList.get(i),ppdjpm,pmfzMap,ddje,mrch,jf,cxhdjf,tbgxjf,mdrs));
			}
	        
	        DecimalFormat df = new DecimalFormat("#0.00");
	        for (int i = 0; i < pp.size(); i++) {
	        	//再对当月所有的门店的总积分按品牌进行排名
		        final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
	    		map = new HashMap<String, Object>();
	    		map.put("field", "_widget_1627905992820");//评分年月
	    		map.put("type", "text");
	    		map.put("method", "eq");
	    		map.put("value", month);
	    		condList.add(map);
	    		map1 = new HashMap<String, Object>();
        		map1.put("field", "_widget_1627886457630"); //品牌
        		map1.put("type", "text");
        		map1.put("method", "eq");
        		map1.put("value", pp.get(i));
        		condList.add(map1);
	    		Map<String, Object> filter = new HashMap<String, Object>() {
	    			{
	    				put("rel", "and");
	    				put("cond", condList);
	    			}
	    		};
	            c7_List = c7_api.getAllFormData(null,filter);
	            List<Jxspm> jxspms=new ArrayList<>();
	            double zjf=0.0;
	            for (int j = 0; j < c7_List.size(); j++) {
	            	Jxspm jxspm=new Jxspm();
	            	jxspm.setId(c7_List.get(j).get("_id").toString());
	            	jxspm.setJf(ObjectUtils.getObjectToDouble(c7_List.get(j).get("_widget_1628477304461")));
	            	jxspms.add(jxspm);
	            	zjf+=ObjectUtils.getObjectToDouble(c7_List.get(j).get("_widget_1628477304461"));
				}
	    		LinkedHashMap<String,Integer> jfpm=new LinkedHashMap<>();
	            List<Entry<Double, List<Jxspm>>> list = jxspms.stream()
	                    .collect(Collectors.groupingBy(Jxspm::getJf))
	                    .entrySet()
	                    .stream()
	                    .sorted((s1, s2) -> -Double.compare(s1.getKey(), s2.getKey()))
	                    .collect(Collectors.toList());
	            int index = 1;
	            int num=0;
	            for (Entry<Double, List<Jxspm>> entry : list) {
	            	for (int j = 0; j < entry.getValue().size(); j++) {
	            		jfpm.put(entry.getValue().get(j).getId(), index);
	            		num++;
	    			}
	                index+=num;
	                num=0;
	            }
	            
	            for (Map.Entry<String, Integer> entry : jfpm.entrySet()) {
        			Map<String, Object> rawData = new HashMap<String, Object>();
        			Map<String, Object> m1 = new HashMap<String, Object>();
        			m1.put("value",entry.getValue());
        			rawData.put("_widget_1628477304402", m1);// 总积分排名
        			c7_api.updateData(entry.getKey(), rawData);
        	    }
	            
	            //保存到dznljf_tb表
	            DznljfTb dznljfTb=new DznljfTb();
	            dznljfTb.setPp(pp.get(i));
            	dznljfTb.setNy(month);
            	dznljfTb.setZrs(c7_List.size());
            	dznljfTb.setZjf(zjf);
            	dznljfTb.setRjjf(Double.valueOf(df.format(zjf/c7_List.size())));
            	DznljfTbExample example=new DznljfTbExample();
            	Criteria criteria=example.createCriteria();
            	criteria.andNyEqualTo(month);
            	criteria.andPpEqualTo(pp.get(i));
            	List<DznljfTb> dznljfTbs=dznljfTbMapper.selectByExample(example);
            	if(dznljfTbs.size()==1){
            		dznljfTbMapper.updateByExample(dznljfTb,example);
            	}else if(dznljfTbs.size()==0){
            		dznljfTbMapper.insert(dznljfTb);
            	}
			}
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> addDate(String year,String yearMonth,Map<String, Object> map,String ppdjpm,Map<String,String> pmfzMap,Double ddje,String mrch,Integer jf,Integer cxhdjf,Double tbgxjf,String mdrs){
		Map<String, Object> rawData = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("value",year);
		rawData.put("_widget_1627905992838", m1);// 评分年
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("value",yearMonth);
		rawData.put("_widget_1627905992820", m2);// 评分年月
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("value",map.get("_widget_1627887110072"));
		rawData.put("_widget_1627887110072", m3);// 门店名称
		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("value",map.get("_widget_1627886455424"));
		rawData.put("_widget_1627886455424", m4);// 门店编码
		Map<String, Object> m5 = new HashMap<String, Object>();
		m5.put("value",map.get("_widget_1627886455851"));
		rawData.put("_widget_1627886455851", m5);// 店长-员工名称
		Map<String, Object> m6 = new HashMap<String, Object>();
		m6.put("value",map.get("_widget_1627886455833"));
		rawData.put("_widget_1627886455833", m6);// 店长-员工编码
		Map<String, Object> m7 = new HashMap<String, Object>();
		m7.put("value",map.get("_widget_1627886455555"));
		rawData.put("_widget_1627886455555", m7);// 经销商名称
		Map<String, Object> m8 = new HashMap<String, Object>();
		m8.put("value",map.get("_widget_1627886455604"));
		rawData.put("_widget_1627886455604", m8);// 经销商编码
		Map<String, Object> m9 = new HashMap<String, Object>();
		m9.put("value",map.get("_widget_1627886457648"));
		rawData.put("_widget_1627886457648", m9);// 品牌名称
		Map<String, Object> m10 = new HashMap<String, Object>();
		m10.put("value",map.get("_widget_1627886457630"));
		rawData.put("_widget_1627886457630", m10);// 品牌编码
		Map<String, Object> m11 = new HashMap<String, Object>();
		m11.put("value",map.get("_widget_1627983375792"));
		rawData.put("_widget_1627983869919", m11);// 区域
		Map<String, Object> m12 = new HashMap<String, Object>();
		m12.put("value",map.get("_widget_1627983375215"));
		rawData.put("_widget_1627983869991", m12);// 省名称
		Map<String, Object> m13 = new HashMap<String, Object>();
		m13.put("value",map.get("_widget_1627983375197"));
		rawData.put("_widget_1627983869973", m13);// 省编码
		Map<String, Object> m14 = new HashMap<String, Object>();
		m14.put("value",map.get("_widget_1627983375251"));
		rawData.put("_widget_1627983869955", m14);// 市名称
		Map<String, Object> m15 = new HashMap<String, Object>();
		m15.put("value",map.get("_widget_1627983375233"));
		rawData.put("_widget_1627983869937", m15);// 市编码
		Map<String, Object> m16 = new HashMap<String, Object>();
		m16.put("value",map.get("_widget_1627887109634"));
		rawData.put("_widget_1627887109634", m16);// 省市名称
		Map<String, Object> m17 = new HashMap<String, Object>();
		m17.put("value",map.get("_widget_1627887109616"));
		rawData.put("_widget_1627887109616", m17);// 省市编码
		Map<String, Object> m18 = new HashMap<String, Object>();
		m18.put("value",map.get("_widget_1627887109748"));
		rawData.put("_widget_1627887109748", m18);// 城市等级
		Map<String, Object> m19 = new HashMap<String, Object>();
		m19.put("value",map.get("_widget_1627886456425"));
		rawData.put("_widget_1627886456425", m19);// P01运营员工名称
		Map<String, Object> m20 = new HashMap<String, Object>();
		m20.put("value",map.get("_widget_1627886456443"));
		rawData.put("_widget_1627886456443", m20);// P01运营员工编码
		Map<String, Object> m21 = new HashMap<String, Object>();
		m21.put("value",map.get("_widget_1628169392527"));
		rawData.put("_widget_1628169595445", m21);// P02运营员工名称
		Map<String, Object> m22 = new HashMap<String, Object>();
		m22.put("value",map.get("_widget_1628169392779"));
		rawData.put("_widget_1628169595535", m22);// P02运营员工编码
		Map<String, Object> m23 = new HashMap<String, Object>();
		m23.put("value",map.get("_widget_1628169392583"));
		rawData.put("_widget_1628169595623", m23);// P03运营员工名称
		Map<String, Object> m24 = new HashMap<String, Object>();
		m24.put("value",map.get("_widget_1628169392851"));
		rawData.put("_widget_1628169595711", m24);//P03运营员工编码
		Map<String, Object> m25 = new HashMap<String, Object>();
		m25.put("value",map.get("_widget_1628169392671"));
		rawData.put("_widget_1628169596127", m25);//P04运营员工名称
		Map<String, Object> m26 = new HashMap<String, Object>();
		m26.put("value",map.get("_widget_1628169392971"));
		rawData.put("_widget_1628169596215", m26);// P04运营员工编码
		Map<String, Object> m27 = new HashMap<String, Object>();
		m27.put("value",map.get("_widget_1627886456461"));
		rawData.put("_widget_1627886456461", m27);// 工厂跟单-员工名称
		Map<String, Object> m28 = new HashMap<String, Object>();
		m28.put("value",map.get("_widget_1627886456479"));
		rawData.put("_widget_1627886456479", m28);// 工厂跟单-员工编码
		Map<String, Object> m29 = new HashMap<String, Object>();
		m29.put("value",map.get("_widget_1627886456497"));
		rawData.put("_widget_1627886456497", m29);// 业务-员工名称
		Map<String, Object> m30 = new HashMap<String, Object>();
		m30.put("value",map.get("_widget_1627886456515"));
		rawData.put("_widget_1627886456515", m30);// 业务-员工编码
		double zjf=0.0;//总积分
		if(ppdjpm==null || "".equals(ppdjpm)){
			Map<String, Object> m31 = new HashMap<String, Object>();
			m31.put("value",0);
			rawData.put("_widget_1628240778489", m31);// 月回款额(元)
			Map<String, Object> m32 = new HashMap<String, Object>();
			m32.put("value",0);
			rawData.put("_widget_1628240778527", m32);// 月回款排名(分级)
			Map<String, Object> m33 = new HashMap<String, Object>();
			m33.put("value",0);
			rawData.put("_widget_1628240778831", m33);// 【积分】-月回款排名(分级)
		}else{
			Map<String, Object> m31 = new HashMap<String, Object>();
			m31.put("value",ppdjpm.substring(0, ppdjpm.indexOf("&")));
			rawData.put("_widget_1628240778489", m31);// 月回款额(元)
			Map<String, Object> m32 = new HashMap<String, Object>();
			m32.put("value",ppdjpm.substring(ppdjpm.indexOf("&")+1,ppdjpm.length()));
			rawData.put("_widget_1628240778527", m32);// 月回款排名(分级)
			Map<String, Object> m33 = new HashMap<String, Object>();
			m33.put("value",pmfzMap.get(map.get("_widget_1627886457630")+ppdjpm.substring(ppdjpm.indexOf("&")+1,ppdjpm.length())));
			rawData.put("_widget_1628240778831", m33);// 【积分】-月回款排名(分级)
			zjf=Double.valueOf(pmfzMap.get(map.get("_widget_1627886457630")+ppdjpm.substring(ppdjpm.indexOf("&")+1,ppdjpm.length())));
		}
		if(ddje == null){
			Map<String, Object> m34 = new HashMap<String, Object>();
			m34.put("value",0);
			rawData.put("_widget_1628240779121", m34);// 月销售额(门店业绩:元)
			Map<String, Object> m35 = new HashMap<String, Object>();
			m35.put("value",0);
			rawData.put("_widget_1628240779469", m35);// 【积分】-月销售额(门店业绩:元)
		}else{
			Map<String, Object> m34 = new HashMap<String, Object>();
			m34.put("value",ddje);
			rawData.put("_widget_1628240779121", m34);// 月销售额(门店业绩:元)
			Map<String, Object> m35 = new HashMap<String, Object>();
			Double d=ddje/10000;
			m35.put("value",d.intValue()*2);
			rawData.put("_widget_1628240779469", m35);// 【积分】-月销售额(门店业绩:元)
			zjf+=(d.intValue()*2);
		}
		if(mrch == null){
			Map<String, Object> m36 = new HashMap<String, Object>();
			m36.put("value",0);
			rawData.put("_widget_1628240779615", m36);// 店员配置(月累计人数)
			Map<String, Object> m37 = new HashMap<String, Object>();
			m37.put("value",0);
			rawData.put("_widget_1628240779922", m37);// 店员配置(日均人数)
			Map<String, Object> m38 = new HashMap<String, Object>();
			m38.put("value",0);
			rawData.put("_widget_1628240779960", m38);// 【积分】-店员配置(月累计人数)
			Map<String, Object> m39 = new HashMap<String, Object>();
			m39.put("value",0);
			rawData.put("_widget_1628240780341", m39);// 每日晨会
			Map<String, Object> m40 = new HashMap<String, Object>();
			m40.put("value",0);
			rawData.put("_widget_1628240780378", m40);// 【积分】-每日晨会
		}else{
			List<String> list=Arrays.asList(mrch.split("/"));
			Map<String, Object> m36 = new HashMap<String, Object>();
			m36.put("value",list.get(0));
			rawData.put("_widget_1628240779615", m36);// 店员配置(月累计人数)
			Map<String, Object> m37 = new HashMap<String, Object>();
			m37.put("value",Integer.valueOf(list.get(0))/DateUtils.getCurrentMonthDay());
			rawData.put("_widget_1628240779922", m37);// 店员配置(日均人数)
			Map<String, Object> m38 = new HashMap<String, Object>();
			m38.put("value",list.get(1));
			rawData.put("_widget_1628240779960", m38);// 【积分】-店员配置(月累计人数)
			Map<String, Object> m39 = new HashMap<String, Object>();
			m39.put("value",list.get(2));
			rawData.put("_widget_1628240780341", m39);// 每日晨会
			Map<String, Object> m40 = new HashMap<String, Object>();
			m40.put("value",list.get(2));
			rawData.put("_widget_1628240780378", m40);// 【积分】-每日晨会
			zjf+=(Double.valueOf(list.get(1))+Double.valueOf(list.get(2)));
		}
		Map<String, Object> m41 = new HashMap<String, Object>();
		m41.put("value",jf!=null?jf:0);
		rawData.put("_widget_1628240780782", m41);// 【积分】-专业知识视频
		Map<String, Object> m42 = new HashMap<String, Object>();
		m42.put("value",cxhdjf!=null?cxhdjf>=50?50:cxhdjf:0);
		rawData.put("_widget_1628240780930", m42);// 【积分】-促销活动
		Map<String, Object> m43 = new HashMap<String, Object>();
		m43.put("value",tbgxjf!=null?tbgxjf:0);
		rawData.put("_widget_1628240781172", m43);// 【积分】-特别贡献
		zjf+=(Double.valueOf(m41.get("value").toString())+Double.valueOf(m42.get("value").toString())+Double.valueOf(m43.get("value").toString()));
		Map<String, Object> m44 = new HashMap<String, Object>();
		m44.put("value",zjf);
		rawData.put("_widget_1628477304461", m44);// 总积分
		if(mdrs!=null){
			Map<String, Object> m45 = new HashMap<String, Object>();
			m45.put("value",mdrs);
			rawData.put("_widget_1628479756474", m45);// 店员配置(最近一天提报的人数)
		}
		
		return rawData;
	}
	
	//按城市等级和品牌，每个经销商的门店店均排名
	public Map<String,String> getMap1(List<String> pp,String month){
		Map<String,String> totals=new HashMap<>();
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
			String[] str=new String[2];
			str[0]="null";
			str[1]=DateUtils.getLastDay(month, DateUtils.FORMAT_STRING1_MINUTE);
			Map<String, Object> map = new HashMap<String, Object>();//实际开业时间：小于当前日期
			map.put("field", "_widget_1578996437131");
			map.put("type", "text");
			map.put("method", "range");
			map.put("value",str);
			condList0.add(map);
			Map<String, Object> filter0 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList0);
				}
			};
			//获取所有营业中的门店
	        List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
	        //根据品牌获取当月的收款单
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
			for (int i = 0; i < pp.size(); i++) {
            	final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
            	List<String> list=new ArrayList<>();
            	list.add("2022年1月");
            	list.add("2022年2月");
        		Map<String, Object> map1 = new HashMap<String, Object>();
        		map1.put("field", "_widget_1548049038941");//收款年月
        		map1.put("type", "text");
        		map1.put("method", "in");
        		map1.put("value", list);
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
                
                
        		Set<String> jxsbm_A=new HashSet<String>();//A级城市中的经销商
        		Set<String> jxsbm_B=new HashSet<String>();//B级城市中的经销商
        		Set<String> jxsbm_C=new HashSet<String>();//C级城市中的经销商
        		for (int j = 0; j < formData.size(); j++) {
        			if("A".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_A.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}else if("B".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_B.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}else if("C".equals(ObjectUtils.getString(formData.get(j).get("_widget_1569114309696")))){
        				jxsbm_C.add(ObjectUtils.getString(formData.get(j).get("_widget_1548037673508")));
        			}
        		}
        		//按品牌、城市等级对门店的排名
        		Map<String, String> map_A=getpm(jxsbm_A, mapKdsq, formData);
        		Map<String, String> map_B=getpm(jxsbm_B, mapKdsq, formData);
        		Map<String, String> map_C=getpm(jxsbm_C, mapKdsq, formData);
        		totals.putAll(map_A);
        		totals.putAll(map_B);
        		totals.putAll(map_C);
        		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
	}
	
	
	//每个门店当月的订单金额汇总
	public Map<String,Double> getMap2(String month){
		Map<String,Double> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DS2, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		List<String> list=new ArrayList<>();
        	list.add("2022年1月");
        	list.add("2022年2月");
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1563246850783");//开单年月
    		map0.put("type", "text");
    		map0.put("method", "in");
    		map0.put("value", list);
    		condList.add(map0);
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
            
    		Set<String> mdbms=new HashSet<String>();//城市门店
    		for (int i = 0; i < formData.size(); i++) {
    			mdbms.add(ObjectUtils.getString(formData.get(i).get("_widget_1563246847900")));
    		}
    		for (String mdbm : mdbms) {
    			double num=0.0;
    			for (int i = 0; i < formData.size(); i++) {
    				if(mdbm.equals(ObjectUtils.getString(formData.get(i).get("_widget_1563246847900")))){
    					num+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1563246851087")));
    				}
    			}
    			map.put(mdbm, num);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//C2每日晨会
	public Map<String,String> getMap3(String month){
		Map<String,String> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C2_ENTRYID, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		List<String> list=new ArrayList<>();
        	list.add("2022年1月");
        	list.add("2022年2月");
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1627905992838");//年月
    		map0.put("type", "text");
    		map0.put("method", "in");
    		map0.put("value", list);
    		condList.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		
            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
            
    		Set<String> mdbms=new HashSet<String>();
    		for (int i = 0; i < formData.size(); i++) {
    			mdbms.add(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")));
    		}
    		for (String mdbm : mdbms) {
    			int rs=0;
    			double rsjf=0;
    			int zpjf=0;
    			for (int i = 0; i < formData.size(); i++) {
    				if(mdbm.equals(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")))){
    					rs+=ObjectUtils.getObjectToInteger(ObjectUtils.getString(formData.get(i).get("_widget_1627905993153")));
    					rsjf+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1627909375168")));
    					zpjf+=ObjectUtils.getObjectToInteger(ObjectUtils.getString(formData.get(i).get("_widget_1627909375148")));
    				}
    			}
    			map.put(mdbm, rs+"/"+rsjf+"/"+zpjf);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	//C1.1门店人员进群,门店人员计数器-合计
	public Map<String,String> getMap3_1(){
		Map<String,String> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C1_1_ENTRYID, APIKEY);
    		
            List<Map<String, Object>> formData = api.getAllFormData(null,null);
            
            for (int i = 0; i < formData.size(); i++) {
            	map.put(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")), ObjectUtils.getString(formData.get(i).get("_widget_1631151630231")));
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	//C3专业知识视频
	public Map<String,Integer> getMap4(String month){
		Map<String,Integer> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C3_ENTRYID, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		List<String> list1=new ArrayList<>();
        	list1.add("2022年1月");
        	list1.add("2022年2月");
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1627905992838");//年月
    		map0.put("type", "text");
    		map0.put("method", "in");
    		map0.put("value", list1);
    		condList.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		
            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
            
    		Set<String> mdbms=new HashSet<String>();
    		for (int i = 0; i < formData.size(); i++) {
    			mdbms.add(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")));
    		}
    		for (String mdbm : mdbms) {
    			int jf=0;
    			for (int i = 0; i < formData.size(); i++) {
    				if(mdbm.equals(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")))){
    					List<Map<String, Object>> list=(List<Map<String, Object>>)formData.get(i).get("_widget_1627982109519");
    					for (int j = 0; j < list.size(); j++) {
    						jf+=ObjectUtils.getObjectToInteger(ObjectUtils.getString(list.get(j).get("_widget_1627982109844")));
						}
    					
    				}
    			}
    			map.put(mdbm, jf);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	//C4促销活动
	public Map<String,Integer> getMap5(String month){
		Map<String,Integer> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C4_ENTRYID, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		List<String> list=new ArrayList<>();
        	list.add("2022年1月");
        	list.add("2022年2月");
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1627905992820");//年月
    		map0.put("type", "text");
    		map0.put("method", "in");
    		map0.put("value", list);
    		condList.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		
            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
            
    		Set<String> mdbms=new HashSet<String>();
    		for (int i = 0; i < formData.size(); i++) {
    			mdbms.add(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")));
    		}
    		for (String mdbm : mdbms) {
    			int jf=0;
    			for (int i = 0; i < formData.size(); i++) {
    				if(mdbm.equals(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")))){
    					jf+=ObjectUtils.getObjectToInteger(ObjectUtils.getString(formData.get(i).get("_widget_1627985533320")));
    				}
    			}
    			map.put(mdbm, jf);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	//C5特别贡献
	public Map<String,Double> getMap6(String month){
		Map<String,Double> map=new HashMap<>();
		try {
			JDYAPIUtils api = new JDYAPIUtils(APPID, C5_ENTRYID, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		List<String> list=new ArrayList<>();
        	list.add("2022年1月");
        	list.add("2022年2月");
    		Map<String, Object> map0 = new HashMap<String, Object>();
    		map0.put("field", "_widget_1627905992838");//年月
    		map0.put("type", "text");
    		map0.put("method", "in");
    		map0.put("value", list);
    		condList.add(map0);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		
            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
            
    		Set<String> mdbms=new HashSet<String>();
    		for (int i = 0; i < formData.size(); i++) {
    			mdbms.add(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")));
    		}
    		for (String mdbm : mdbms) {
    			Double jf=0.0;
    			for (int i = 0; i < formData.size(); i++) {
    				if(mdbm.equals(ObjectUtils.getString(formData.get(i).get("_widget_1627886455424")))){
    					jf+=ObjectUtils.getObjectToDouble(ObjectUtils.getString(formData.get(i).get("_widget_1627985533320")));
    				}
    			}
    			map.put(mdbm, jf);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String,String> getpm(Set<String> jxsbms, Map<String,List<String>> mapKdsq,List<Map<String, Object>> formData){
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
        		 map.put(entry.getValue().get(i).getMdbm(), entry.getValue().get(i).getDj()+"&"+index);
        		 num++;
			}
            index+=num;
            num=0;
        }
		return map;
	}

}
