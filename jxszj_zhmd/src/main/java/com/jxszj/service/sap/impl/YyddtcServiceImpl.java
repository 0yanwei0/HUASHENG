package com.jxszj.service.sap.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxszj.mapper.sap.HsXsdddjysTbMapper;
import com.jxszj.mapper.sap.HsYygdtcTbMapper;
import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.pojo.sap.HsYygdtcTb;
import com.jxszj.pojo.sap.HsYygdtcTbExample;
import com.jxszj.pojo.sap.HsYygdtcTbExample.Criteria;
import com.jxszj.service.sap.IYyddtcService;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;
@Service
public class YyddtcServiceImpl implements IYyddtcService {
	
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

	//门店数据
	private static final String ENTRYID_MDSJ = "61d67ee8ffdf9d00080a0946";
	
	//DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
	//DF3-意向金转货款申请
    private static final String ENTRYID_DF3 = "5d63a0c109f85f24f98f23cd";
    
    //上月结余预收款金额
    private static final String JYYSK="61307132b362fc000a99b66e";
    
    @Autowired
	private HsYygdtcTbMapper hsYygdtcTbMapper;
    
    @Autowired
	private HsXsdddjysTbMapper hsXsdddjysTbMapper;

	@Override
	public EUDataGridResult getYyddtcList(int page, int rows, String yyddtcrq) {
		HsYygdtcTbExample example=new HsYygdtcTbExample();
		if(yyddtcrq!=null && !"".equals(yyddtcrq)){
			Criteria criteria=example.createCriteria();
			criteria.andNyEqualTo(DateUtils.getDateStringToStringFormat1(yyddtcrq,DateUtils.FORMAT_STRING_MINUTE1));
		}
		// 分页处理
		PageHelper.startPage(page, rows);
		List<HsYygdtcTb> item=hsYygdtcTbMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(item);
		// 取记录总条数
		PageInfo<HsYygdtcTb> pageInfo = new PageInfo<>(item);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


	@Override
	public void updateYyddtc(String ny) {
		List<HsYygdtcTb> hsYygdtcTbs=new ArrayList<>();
		List<String> pps=new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#0.00");
		Map<String, Double> yskMap=getRcfdjelMap("预收款",ny);
		Map<String, Double> xsskMap=getRcfdjelMap("销售收款",ny);
		
		Map<String, Double> yxjMap=getYxjMap(ny); //意向金
		
		Map<String, Double> jyyskMap=getJyyskMap(ny);//结余预收款
		
		Map<String, String> jxsMap=getDateJxs();//经销商编码，经销商名称
		pps.add("MS");
		pps.add("PD");
		pps.add("HMW");
		try {
			for(String pp:pps) {
				
				List<Map<String, Object>> formData0=getDate(pp,ny);
				
				//经销商名称所对应的运营经理
	    		Map<String, String> map0=new HashMap<String, String>();
	    		Set<String> set1=new HashSet<String>();
	    		for (int i = 0; i < formData0.size(); i++) {
					set1.add(formData0.get(i).get("_widget_1641447145997").toString());//获取所有的经销商
					String str=formData0.get(i).get("_widget_1641447146009").toString()+"/"+formData0.get(i).get("_widget_1641447146013").toString()+"/"+formData0.get(i).get("_widget_1641447146013").toString();
					map0.put(formData0.get(i).get("_widget_1641447145997").toString(), str);
				}
	    		
	    		Set<String> p01=new HashSet<String>();
	    		Set<String> p02=new HashSet<String>();
	    		Map<String, String> yyjls=new HashMap<String, String>();//运营经理对应的名称
	    		for (int i = 0; i < formData0.size(); i++) {
					p02.add(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146015")));//p02运营经理
					yyjls.put(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146015")), ObjectUtils.getString(formData0.get(i).get("_widget_1641447146013")));
					
					p01.add(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146011")));//p01运营经理
					yyjls.put(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146011")), ObjectUtils.getString(formData0.get(i).get("_widget_1641447146009")));
				}
	    		
	    		//经销商的门店数
	    		Map<String, Integer> jxsmds=new HashMap<String, Integer>();
	    		for(String jxsbm:set1) {
	    			int number=0;
	    			for (int i = 0; i < formData0.size(); i++) {
	    				if(jxsbm.equals(formData0.get(i).get("_widget_1641447145997").toString())) {
	    					number++;
	    				}
	    			}
	    			jxsmds.put(jxsbm, number);
	    		}
	    		//运营经理对应的经销商
	    		Map<String, Set<String>> yyjljxs=new HashMap<String, Set<String>>();
	    		//运营经理对应的门店数
	    		Map<String, Integer> yyjlmds=new HashMap<String, Integer>();
	    		for(String yyjlbm:p01) {
	    			Set<String> set=new HashSet<String>();
	    			int number=0;
	    			for (int i = 0; i < formData0.size(); i++) {
	    				if(yyjlbm.equals(formData0.get(i).get("_widget_1641447146011").toString())) {
	    					set.add(formData0.get(i).get("_widget_1641447145997").toString());
	    					number++;
	    				}
	    			}
	    			yyjljxs.put(yyjlbm, set);
	    			yyjlmds.put(yyjlbm, number);
	    		}
	    		for(String yyjlbm:p02) {
	    			Set<String> set=new HashSet<String>();
	    			int number=0;
	    			for (int i = 0; i < formData0.size(); i++) {
	    				if(yyjlbm.equals(formData0.get(i).get("_widget_1641447146015").toString())) {
	    					set.add(formData0.get(i).get("_widget_1641447145997").toString());
	    					number++;
	    				}
	    			}
	    			yyjljxs.put(yyjlbm, set);
	    			yyjlmds.put(yyjlbm, number);
	    		}
	    		
	    		if(pp.equals("PD") || pp.equals("HMW")) {
		    		//计算下单金额
		    		for(Map.Entry<String, Set<String>> map:yyjljxs.entrySet()) {
//		    			//获取每一个运营经理下的经销商
		    			Set<String> set=map.getValue();
		    			//运营经理销售金额与店均
		    			Double yyjldj=getDj(set, map.getKey(), yskMap, xsskMap, yyjlmds,ny,yxjMap,jyyskMap);
		    			double tcbl=0.0;
		    			if(yyjldj>=40000 && yyjldj<60000) {
        					tcbl=0.005;
        				}else if(yyjldj>=60000 && yyjldj<90000) {
        					tcbl=0.01;
        				}else if(yyjldj>=90000) {
        					tcbl=0.02;
        				}
	        			
		    			
		    			//经销商
		    			for (String jxsbm:set) {
		    				HsYygdtcTb hsYygdtcTb=new HsYygdtcTb();
		        			double xsje=0.0;
		        			Double jxsxdje=hsXsdddjysTbMapper.selectXdje(jxsbm,DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
		        			//判断比较预收款金额，下单金额取最小
		        			double d=ObjectUtils.getObjectToDouble(yskMap.get(jxsbm))+ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm))+ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm));
		        			if(d>=jxsxdje) {
		        				xsje=jxsxdje+ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm));
		        			}else {
		        				xsje=d+ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm));
		    				}
		        			
		        			//经销商店均
		        			Double jxsdj=0.0;;
		        			if(ObjectUtils.getObjectToInteger(jxsmds.get(jxsbm))!=0) {
		        				jxsdj=Double.valueOf(df.format(xsje/ObjectUtils.getObjectToInteger(jxsmds.get(jxsbm))));
		        			}
		        			double tc=xsje*tcbl;
		        			hsYygdtcTb.setJxs(jxsMap.get(jxsbm));
		        			hsYygdtcTb.setNy(DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
		        			hsYygdtcTb.setMds(jxsmds.get(jxsbm));
		        			hsYygdtcTb.setP01(map0.get(jxsbm).split("/")[0]);
		        			hsYygdtcTb.setP02(map0.get(jxsbm).split("/")[1]);
		        			hsYygdtcTb.setP03(map0.get(jxsbm).split("/")[2]);
		        			hsYygdtcTb.setXdje(Double.valueOf(df.format(jxsxdje)));
		        			hsYygdtcTb.setYskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(yskMap.get(jxsbm)))));
		        			hsYygdtcTb.setXsskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm)))));
		        			hsYygdtcTb.setXsje(Double.valueOf(df.format(xsje)));
		        			hsYygdtcTb.setDjjxs(jxsdj);
		        			hsYygdtcTb.setDjqyjl(yyjldj);
		        			hsYygdtcTb.setDdtcxs(tcbl);
		        			hsYygdtcTb.setDdxstc(Double.valueOf(df.format(tc)));
		        			hsYygdtcTb.setYyjl(yyjls.get(map.getKey()));
		        			hsYygdtcTb.setYxj(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm)))));
		        			hsYygdtcTb.setJyysk(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm)))));
		        			hsYygdtcTb.setPp(pp);
		        			hsYygdtcTbs.add(hsYygdtcTb);
						}
		    			
		    		}
	    		}else {
		    		//计算下单金额
		    		for(Map.Entry<String, Set<String>> map:yyjljxs.entrySet()) {
		    			//获取每一个运营经理下的经销商
		    			Set<String> set=map.getValue();
		    			//运营经理店均
		    			Double yyjldj=getDj(set, map.getKey(), yskMap, xsskMap, yyjlmds,ny,yxjMap,jyyskMap);
		    			
		    			double tcbl=0.0;
		    			if(map.getKey().equals("H0362")) {
		    				if(yyjldj>=40000 && yyjldj<60000) {
	        					tcbl=0.005;
	        				}else if(yyjldj>=60000 && yyjldj<90000) {
	        					tcbl=0.01;
	        				}else if(yyjldj>=90000) {
	        					tcbl=0.02;
	        				}
		    			}else {
		    				if(yyjldj>=40000 && yyjldj<60000) {
	        					tcbl=0.005;
	        				}else if(yyjldj>=60000 && yyjldj<90000) {
	        					tcbl=0.015;
	        				}else if(yyjldj>=90000) {
	        					tcbl=0.03;
	        				}
		    			}
		    			
		    			//经销商
		    			for (String jxsbm:set) {
		    				HsYygdtcTb hsYygdtcTb=new HsYygdtcTb();
		        			Double xsje=0.0;
		        			Double jxsxdje=hsXsdddjysTbMapper.selectXdje(jxsbm,DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
		        			//判断比较预收款金额，下单金额取最小
		        			double d=ObjectUtils.getObjectToDouble(yskMap.get(jxsbm))+ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm))+ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm));
		        			if(d>=jxsxdje) {
		        				xsje=jxsxdje+ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm));
		        			}else {
		        				xsje=d+ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm));
		    				}
		        			
		        			//经销商店均
		        			Double jxsdj=0.0;;
		        			if(ObjectUtils.getObjectToInteger(jxsmds.get(jxsbm))!=0) {
		        				jxsdj=Double.valueOf(df.format(xsje/ObjectUtils.getObjectToInteger(jxsmds.get(jxsbm))));
		        			}
		        			double tc=xsje*tcbl;
//		        			double ewtc=0.0;
		        			hsYygdtcTb.setJxs(jxsMap.get(jxsbm));
		        			hsYygdtcTb.setNy(DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
		        			hsYygdtcTb.setMds(jxsmds.get(jxsbm));
		        			hsYygdtcTb.setP01(map0.get(jxsbm).split("/")[0]);
		        			hsYygdtcTb.setP02(map0.get(jxsbm).split("/")[1]);
		        			hsYygdtcTb.setP03(map0.get(jxsbm).split("/")[2]);
		        			hsYygdtcTb.setXdje(Double.valueOf(df.format(jxsxdje)));
		        			hsYygdtcTb.setYskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(yskMap.get(jxsbm)))));
		        			hsYygdtcTb.setXsskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(xsskMap.get(jxsbm)))));
		        			hsYygdtcTb.setXsje(Double.valueOf(df.format(xsje)));
		        			hsYygdtcTb.setDjjxs(jxsdj);
		        			hsYygdtcTb.setDjqyjl(yyjldj);
		        			hsYygdtcTb.setDdtcxs(tcbl);
		        			hsYygdtcTb.setDdxstc(Double.valueOf(df.format(tc)));
//		        			hsYygdtcTb.setDdewtcxs(ewtcbls.get(map0.get(jxs).split("/")[0])==null?0:ewtcbls.get(map0.get(jxs).split("/")[0]));
//		        			hsYygdtcTb.setDdewxstc(ewtcbls.get(map0.get(jxs).split("/")[0])==null?0:Double.valueOf(df.format(xsje*ewtcbls.get(map0.get(jxs).split("/")[0]))));
		        			hsYygdtcTb.setYyjl(yyjls.get(map.getKey()));
		        			hsYygdtcTb.setYxj(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm)))));
		        			hsYygdtcTb.setJyysk(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm)))));
		        			hsYygdtcTb.setPp(pp);
		        			hsYygdtcTbs.add(hsYygdtcTb);
						}
		    		}
	    		}
	    		
			}
			HsYygdtcTbExample example=new HsYygdtcTbExample();
			Criteria  criteria = example.createCriteria();
			criteria.andNyEqualTo(DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
    		hsYygdtcTbMapper.deleteByExample(example);
    		
    		hsYygdtcTbMapper.insertByBatch(hsYygdtcTbs);
    		
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//当月收款的运营经理的预收款
	public Map<String, Double> getRcfdjelMap(String skyt,String ny){
		ny=DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1);
		Map<String, Double> map=new HashMap<String, Double>();
		try {
    		//预收款金额
    		JDYAPIUtils ysk = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
    		final List<Map<String, Object>> condList2 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map6 = new HashMap<String, Object>();//收款年月：本月
    		map6.put("field", "_widget_1548049038941");
    		map6.put("type", "text");
    		map6.put("method", "eq");
    		map6.put("value", ny);
    		condList2.add(map6);
    		Map<String, Object> map7 = new HashMap<String, Object>();//凭证编号:不为空
    		map7.put("field", "_widget_1593141119943");
    		map7.put("type", "text");
    		map7.put("method", "not_empty");
    		condList2.add(map7);
    		Map<String, Object> map8 = new HashMap<String, Object>();//收款用途：预收款/销售收款
    		map8.put("field", "_widget_1548049038566");
    		map8.put("type", "text");
    		map8.put("method", "eq");
    		map8.put("value", skyt);
    		condList2.add(map8);
    		Map<String, Object> map9 = new HashMap<String, Object>();//单据状态：正常
    		map9.put("field", "_widget_1630029105685");
    		map9.put("type", "radiogroup");
    		map9.put("method", "eq");
    		map9.put("value", "正常");
    		condList2.add(map9);
    		Map<String, Object> filter2 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList2);
    			}
    		};
    		List<Map<String, Object>> formData2 = ysk.getAllFormData(null,filter2);
    		
    		//经销商的日常返单金额
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			set.add(formData2.get(i).get("_widget_1593141121904").toString());
			}
    		for(String jxsbm:set) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(jxsbm.equals(formData2.get(i).get("_widget_1593141121904").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1564390193051"));
					}
				}
    			map.put(jxsbm, number); 
    		}
    		
    		//运营经理的返单金额
    		Set<String> p01=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p01.add(formData2.get(i).get("_widget_1628220748244").toString());
			}
    		for(String yyjlbm:p01) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1628220748244").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1564390193051"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
    		Set<String> p02=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p02.add(formData2.get(i).get("_widget_1628220748710").toString());
			}
    		for(String yyjlbm:p02) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1628220748710").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1564390193051"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	public List<Map<String, Object>> getDate(String pp,String ny){
		//查询营业中的门店,且实际开业时间小于当前日期
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_MDSJ, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		String[] str=new String[2];
		str[0]="null";
		str[1]=ny;
		Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当前日期
		map1.put("field", "_widget_1641447146029");
		map1.put("type", "text");
		map1.put("method", "range");
		map1.put("value",str);
		condList0.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();//品牌
		map2.put("field", "_widget_1641447146003");
		map2.put("type", "text");
		map2.put("method", "eq");
		map2.put("value",pp);
		condList0.add(map2);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
		return formData0;
	}
	
	//获取经销商编码和名称
	public Map<String, String> getDateJxs(){
		Map<String,String> map=new HashMap<>();
		JDYAPIUtils jxs = new JDYAPIUtils(APPID, ENTRYID_MDSJ, APIKEY);
		List<Map<String, Object>> formData0 = jxs.getAllFormData(null,null);
		for (int i = 0; i < formData0.size(); i++) {
			map.put(formData0.get(i).get("_widget_1641447145997").toString(), formData0.get(i).get("_widget_1641447145999").toString());
		}
		return map;
	}
	
	//计算运营经理的店均
	public Double getDj(Set<String> set,String yyjlbm,Map<String, Double> yyjlyskMap,Map<String, Double> yyjlxsskMap,Map<String, Integer> yyjlmds,String ny,Map<String, Double> yxjMap,Map<String, Double> jyyskMap) {
		ny=DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1);
		double yyjlxdje=0.0;
		DecimalFormat df = new DecimalFormat("#0.00");
		//获取每一个运营经理下的经销商
		for (String jxsbm:set) {
			yyjlxdje+=hsXsdddjysTbMapper.selectXdje(jxsbm,ny);
		}
		
		Double xsje=0.0;
		//判断比较预收款金额，下单金额取最小
		double d=ObjectUtils.getObjectToDouble(yyjlyskMap.get(yyjlbm))+ObjectUtils.getObjectToDouble(yxjMap.get(yyjlbm))+ObjectUtils.getObjectToDouble(jyyskMap.get(yyjlbm));
		if(d>=yyjlxdje) {
			xsje=yyjlxdje+ObjectUtils.getObjectToDouble(yyjlxsskMap.get(yyjlbm));
		}else {
			xsje=d+ObjectUtils.getObjectToDouble(yyjlxsskMap.get(yyjlbm));
		}
		//运营经理店均
		Double yyjldj=0.0;
		if(ObjectUtils.getObjectToInteger(yyjlmds.get(yyjlbm))!=0) {
			yyjldj=Double.valueOf(df.format(xsje/ObjectUtils.getObjectToInteger(yyjlmds.get(yyjlbm))));
		}
		return yyjldj;
	}
	
	
	//经销商/运营经理意向金转货款申请
	public Map<String, Double> getYxjMap(String ny){
		ny=DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1);
		Map<String, Double> map=new HashMap<String, Double>();
		try {
    		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF3, APIKEY);
    		final List<Map<String, Object>> condList2 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map6 = new HashMap<String, Object>();//流程已完成
    		map6.put("field", "flowState");
    		map6.put("type", "text");
    		map6.put("method", "eq");
    		map6.put("value", 1);
    		condList2.add(map6);
    		Map<String, Object> map7 = new HashMap<String, Object>();
    		map7.put("field", "_widget_1630634659508");
    		map7.put("type", "text");
    		map7.put("method", "eq");
    		map7.put("value", ny);
    		condList2.add(map7);
    		Map<String, Object> filter2 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList2);
    			}
    		};
    		List<Map<String, Object>> formData2 = api.getAllFormData(null,filter2);
    		
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			set.add(formData2.get(i).get("_widget_1630634657306").toString());
			}
    		for(String jxsbm:set) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(jxsbm.equals(formData2.get(i).get("_widget_1630634657306").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1566810306999"));
					}
				}
    			map.put(jxsbm, number);
    		}
    		
    		Set<String> p01=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p01.add(formData2.get(i).get("_widget_1630572802093").toString());
			}
    		for(String yyjlbm:p01) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1630572802093").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1566810306999"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
    		Set<String> p02=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p02.add(formData2.get(i).get("_widget_1630572802135").toString());
			}
    		for(String yyjlbm:p02) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1630572802135").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1566810306999"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	//经销商/运营经理上月结余预收款金额
	public Map<String, Double> getJyyskMap(String ny){
		ny=DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1);
		Map<String, Double> map=new HashMap<String, Double>();
		try {
    		JDYAPIUtils api = new JDYAPIUtils(APPID, JYYSK, APIKEY);
    		final List<Map<String, Object>> condList2 = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map7 = new HashMap<String, Object>();
    		map7.put("field", "_widget_1627905992820");
    		map7.put("type", "text");
    		map7.put("method", "eq");
    		map7.put("value", ny);
    		condList2.add(map7);
    		Map<String, Object> filter2 = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList2);
    			}
    		};
    		List<Map<String, Object>> formData2 = api.getAllFormData(null,filter2);
    		
    		Set<String> set=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			set.add(formData2.get(i).get("_widget_1630564717593").toString());
			}
    		for(String jxsbm:set) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(jxsbm.equals(formData2.get(i).get("_widget_1630564717593").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1630564716832"));
					}
				}
    			map.put(jxsbm, number);
    		}
    		
    		Set<String> p01=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p01.add(formData2.get(i).get("_widget_1627886456443").toString());
			}
    		for(String yyjlbm:p01) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1627886456443").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1630564716832"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
    		Set<String> p02=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p02.add(formData2.get(i).get("_widget_1628170323350").toString());
			}
    		for(String yyjlbm:p02) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1628170323350").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1630564716832"));
					}
				}
    			map.put(yyjlbm, number);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
