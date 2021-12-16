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
import com.jxszj.mapper.sap.HsGdtcTbMapper;
import com.jxszj.mapper.sap.HsXsdddjysTbMapper;
import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.pojo.sap.HsGdtcTb;
import com.jxszj.pojo.sap.HsGdtcTbExample;
import com.jxszj.pojo.sap.HsGdtcTbExample.Criteria;
import com.jxszj.service.sap.IGdtcService;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;
@Service
public class GdtcServiceImpl implements IGdtcService {
	
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
	
	//3-开店申请
    private static final String ENTRYID_KDSQ = "5d102d3f2144352834656205";
	
	//DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
    
	//DF3-意向金转货款申请
    private static final String ENTRYID_DF3 = "5d63a0c109f85f24f98f23cd";
    
    //上月结余预收款金额
    private static final String JYYSK="61307132b362fc000a99b66e";
    
    @Autowired
	private HsXsdddjysTbMapper hsXsdddjysTbMapper;
    
    @Autowired
    private HsGdtcTbMapper hsGdtcTbMapper;

	@Override
	public EUDataGridResult getGdtcList(int page, int rows, String gdtcrq) {
		HsGdtcTbExample example=new HsGdtcTbExample();
		if(gdtcrq!=null && !"".equals(gdtcrq)){
			Criteria criteria=example.createCriteria();
			criteria.andNyEqualTo(DateUtils.getDateStringToStringFormat1(gdtcrq,DateUtils.FORMAT_STRING_MINUTE1));
		}
		// 分页处理
		PageHelper.startPage(page, rows);
		List<HsGdtcTb> item=hsGdtcTbMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(item);
		// 取记录总条数
		PageInfo<HsGdtcTb> pageInfo = new PageInfo<>(item);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


	@Override
	public void updateGdtc(String ny) {
		try {
			double tcbl=0.003;//提成系数
			DecimalFormat df = new DecimalFormat("#0.00");
			List<HsGdtcTb> hsGdtcTbs=new ArrayList<>();
			Map<String, Double> jxsyskMap=getJxsMap("预收款",ny);
			Map<String, Double> jxsxsskMap=getJxsMap("销售收款",ny);
			List<Map<String, Object>> formData0=getDate(ny);
			Map<String, String> jxsMap=getDateJxs();
			
			Map<String, Double> yxjMap=getYxjMap(ny); //意向金
			
			Map<String, Double> jyyskMap=getJyyskMap(ny);//结余预收款
			
			try {
			//经销商名称所对应的工厂跟单
			Map<String, String> gcgdjxs=new HashMap<String, String>();
			Set<String> set1=new HashSet<String>();
			for (int i = 0; i < formData0.size(); i++) {
				String jxsAll=formData0.get(i).get("_widget_1620615201243").toString();
				String gcgdAll=formData0.get(i).get("_widget_1569290359369").toString();
				set1.add(jxsAll);//获取所有的经销商
				gcgdjxs.put(jxsAll,gcgdAll);
			}
			
			//经销商名称所对应的门店数
			Map<String, Integer> jxsmds=new HashMap<String, Integer>();
			for(String jxsbm:set1) {
				int number=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(jxsbm.equals(formData0.get(i).get("_widget_1620615201243").toString())) {
						number++;
					}
				}
				jxsmds.put(jxsbm, number);
			}
			
			//计算销售金额
			//经销商
			for (String jxsbm:set1) {
				HsGdtcTb hsGdtcTb=new HsGdtcTb();
				double xsje=0.0;
				Double jxsxdje=hsXsdddjysTbMapper.selectGdXdje(jxsbm,DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
				//判断比较预收款金额，下单金额取最小
				double d=ObjectUtils.getObjectToDouble(jxsyskMap.get(jxsbm))+ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm))+ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm));
				if(d>=jxsxdje) {
					xsje=jxsxdje+ObjectUtils.getObjectToDouble(jxsxsskMap.get(jxsbm));
				}else {
					xsje=d+ObjectUtils.getObjectToDouble(jxsxsskMap.get(jxsbm));
				}
				double tc=xsje*tcbl;
				hsGdtcTb.setJxs(jxsMap.get(jxsbm));
				hsGdtcTb.setGd(gcgdjxs.get(jxsbm));
				hsGdtcTb.setMds(jxsmds.get(jxsbm));
				hsGdtcTb.setXdje(Double.valueOf(df.format(jxsxdje)));
				hsGdtcTb.setYskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(jxsyskMap.get(jxsbm)))));
				hsGdtcTb.setXsskje(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(jxsxsskMap.get(jxsbm)))));
				hsGdtcTb.setXsje(Double.valueOf(df.format(xsje)));
				hsGdtcTb.setTcxs(tcbl);
				hsGdtcTb.setXstc(Double.valueOf(df.format(tc)));
				hsGdtcTb.setNy(DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
				hsGdtcTb.setYxj(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(yxjMap.get(jxsbm)))));
				hsGdtcTb.setJyysk(Double.valueOf(df.format(ObjectUtils.getObjectToDouble(jyyskMap.get(jxsbm)))));
				hsGdtcTbs.add(hsGdtcTb);
			}
			
			HsGdtcTbExample example=new HsGdtcTbExample();
			Criteria criteria=example.createCriteria();
			criteria.andNyEqualTo(DateUtils.getDateStringToStringFormat1(ny,DateUtils.FORMAT_STRING_MINUTE1));
			hsGdtcTbMapper.deleteByExample(example);
			
			hsGdtcTbMapper.insertByBatch(hsGdtcTbs);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> getDate(String ny){
		//查询实际开业时间小于当前日期
		JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		String[] str=new String[2];
		str[0]="null";
		str[1]=ny;
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
		List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
		return formData0;
	}
	
	//当月收款的经销商的预收款
	public Map<String, Double> getJxsMap(String skyt,String ny){
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
    		
    		Set<String> jxs=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			jxs.add(formData2.get(i).get("_widget_1593141121904").toString());
			}
    		for(String str:jxs) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(str.equals(formData2.get(i).get("_widget_1593141121904").toString())) {
						number+=ObjectUtils.getObjectToDouble(formData2.get(i).get("_widget_1564390193051"));
					}
				}
    			map.put(str, number);
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
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
    		
    		Set<String> p03=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p03.add(formData2.get(i).get("_widget_1630572802177").toString());
			}
    		for(String yyjlbm:p03) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1630572802177").toString())) {
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
    		
    		Set<String> p03=new HashSet<String>();
    		for (int i = 0; i < formData2.size(); i++) {
    			p03.add(formData2.get(i).get("_widget_1628170323599").toString());
			}
    		for(String yyjlbm:p03) {
    			Double number=0.0;
    			for (int i = 0; i < formData2.size(); i++) {
					if(yyjlbm.equals(formData2.get(i).get("_widget_1628170323599").toString())) {
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

	
	
	//获取经销商编码和名称
	public Map<String, String> getDateJxs(){
		Map<String,String> map=new HashMap<>();
		JDYAPIUtils jxs = new JDYAPIUtils(APPID, ENTRYID_KDSQ, APIKEY);
		List<Map<String, Object>> formData0 = jxs.getAllFormData(null,null);
		for (int i = 0; i < formData0.size(); i++) {
			map.put(formData0.get(i).get("_widget_1620615201243").toString(), formData0.get(i).get("_widget_1543818219429").toString());
		}
		return map;
	}

}
