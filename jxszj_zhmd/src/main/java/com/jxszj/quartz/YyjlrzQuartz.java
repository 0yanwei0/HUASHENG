package com.jxszj.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceListRecordRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiAttendanceListRecordResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/*
 * 运营经理每日日志
 */
public class YyjlrzQuartz {

	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

	//门店数据
    private static final String ENTRYID_MDSJ = "61d67ee8ffdf9d00080a0946";
    
    //运营经理工作日志
    private static final String ENTRYID_RZ="61528f58d8111b0008415b1f";
    
    //C6门店实时销售提报
    private static final String ENTRYID_C6="5d2d229eee266915714e9e1e";
    
    //运营经理钉钉编码对照表
    private static final String ENTRYID_DD="616135f81908e700083afa91";
    
    //Y5运营能力月度评分表
    private static final String ENTRYID_Y5 = "6119fe197085790007ab77e5";
    
    //C1.1门店人员进群
    private static final String ENTRYIDC1_1 = "613965b6976a2c00084d636a";
    
    //周计划
    private static final String ZJH_ENTRYID = "61724ea4e11d57000706ea12";
    
	//DF1-销售收款单
    private static final String ENTRYID_DF1 = "5d3bc22704614439fd55e71d";
    
  //M3月度目标维护
  	private static final String ENTRYID_YDMB="609a4176637de90009c21f63";
  	
    //固定人员固定月目标
  	private static final String ENTRYID_GDMB="61d6d852eef9180007ec63ed";
  	
	//开店申请
    private static final String KDSQ_ENTRYID = "5d102d3f2144352834656205";
    

	public void execute() {
		JDYAPIUtils rz = new JDYAPIUtils(APPID, ENTRYID_RZ, APIKEY);
		DecimalFormat df = new DecimalFormat("#0.00%");
		List<String> pps=new ArrayList<>();
		pps.add("MS");
		pps.add("PD");
		pps.add("HMW");
		Map<String,Double> tbmaps=getMap1();//经销商对应的提报数据
		Map<String, String> yyjfpm=getMap2(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE)); //返回的map为运营员工编码对应的总积分/排名
		Map<String,String> kqdk=checkWork();//钉钉的打卡记录
		JDYAPIUtils dd = new JDYAPIUtils(APPID, ENTRYID_DD, APIKEY);
		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1635997338620");
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "Y");
		condList.add(map0);
		Map<String, Object> filter = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList);
			}
		};
		List<Map<String, Object>> dddzb = dd.getAllFormData(null,filter);
		Map<String,String> ddMap=new HashMap<>();//员工编码所对应的钉钉编码
		for (int i = 0; i < dddzb.size(); i++) {
			ddMap.put(dddzb.get(i).get("_widget_1633760760830").toString(), dddzb.get(i).get("_widget_1633760760777").toString());
		}
		
		//周计划
		JDYAPIUtils zjhAPI = new JDYAPIUtils(APPID, ZJH_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
		map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1639205132548");
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", "是");
		condList1.add(map0);
		Map<String, Object> filte1 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList1);
			}
		};
		List<Map<String, Object>> zjh = zjhAPI.getAllFormData(null,filte1);
		Map<String,String> zjhMap=new HashMap<>();
		for (int i = 0; i < zjh.size(); i++) {
			zjhMap.put(zjh.get(i).get("_widget_1632800603235").toString(), zjh.get(i).get("_widget_1639205132257").toString());
		}
		
		for (String pp:pps) {
			Map<String,String> maps=getMap(pp);//返回的map为运营员工对应的目标/回款/门店数/店均
			Set<String> p01=new HashSet<String>();
			Set<String> p02=new HashSet<String>();
			Map<String, Integer> sjrs=getMap3(pp);
			Map<String, Integer> sjds=getSjds(pp);
			List<Map<String, Object>> formData0=getDate(pp,DateUtils.getNowDateToString());
			Map<String, String> yyjls=new HashMap<String, String>();//运营经理对应的名称
    		for (int i = 0; i < formData0.size(); i++) {
				if(pp.equals("PD") ||pp.equals("HMW") || ObjectUtils.getString(formData0.get(i).get("_widget_1641447146019")).equals("H0362")){
	    			p02.add(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146015")));//p02运营经理编码
					yyjls.put(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146015")), ObjectUtils.getString(formData0.get(i).get("_widget_1641447146013")));
				}
				p01.add(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146011")));//p01运营经理编码
				yyjls.put(ObjectUtils.getString(formData0.get(i).get("_widget_1641447146011")), ObjectUtils.getString(formData0.get(i).get("_widget_1641447146009")));
			}
			
			//运营经理对应的经销商
			Map<String, Set<String>> yyjljxs=new HashMap<String, Set<String>>();
			//运营经理对应的门店
			Map<String, Integer> yyjlmd=new HashMap<>();
			for(String yyjlbm:p01) {
				Set<String> set1=new HashSet<String>();
				int num=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(yyjlbm.equals(formData0.get(i).get("_widget_1641447146011").toString())) {
						set1.add(formData0.get(i).get("_widget_1641447146001").toString());
						num++;
					}
				}
				yyjljxs.put(yyjlbm, set1);
				yyjlmd.put(yyjlbm, num);
			}
			for(String yyjlbm:p02) {
				Set<String> set1=new HashSet<String>();
				int num=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(yyjlbm.equals(formData0.get(i).get("_widget_1641447146015").toString())) {
						set1.add(formData0.get(i).get("_widget_1641447146001").toString());
						num++;
					}
				}
				yyjljxs.put(yyjlbm, set1);
				yyjlmd.put(yyjlbm, num);
			}
			
			Map<String,Double> yyjltb=new HashMap<>();
			for(Map.Entry<String, Set<String>> map:yyjljxs.entrySet()) {
				Double tb=0.0;
				//获取每一个运营经理下的经销商
    			Set<String> set=map.getValue();
    			//经销商
    			for (String jxsbm:set) {
    				tb+=tbmaps.get(jxsbm)!=null?tbmaps.get(jxsbm):0;
    			}
    			yyjltb.put(map.getKey(), tb);
			}
			
			for(Map.Entry<String, Set<String>> map:yyjljxs.entrySet()) {
//				String str=map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR)+week;
				Map<String, Object>rawData = new HashMap<String, Object>();
				Map<String, Object> m0 = new HashMap<String, Object>();
				m0.put("value", ddMap.get(map.getKey()));
				rawData.put("_widget_1632801394682", m0);
				Map<String, Object> m1 = new HashMap<String, Object>();
				m1.put("value", yyjls.get(map.getKey()));
				rawData.put("_widget_1632800603215", m1);// 员工姓名
				Map<String, Object> m2 = new HashMap<String, Object>();
				m2.put("value", map.getKey());
				rawData.put("_widget_1632800603235", m2);// 员工编码
				Map<String, Object> m3 = new HashMap<String, Object>();
				m3.put("value", DateUtils.getNowDateToString()+"T00:00:00.000Z");
				rawData.put("_widget_1634884780427", m3);// 提报日期
//				Map<String, Object> m4 = new HashMap<String, Object>();
//				m4.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR));
//				rawData.put("_widget_1633664138148", m4);// 提报日期-年
				Map<String, Object> m5 = new HashMap<String, Object>();
				m5.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
				rawData.put("_widget_1633664138196", m5);// 提报日期-年-月
				Map<String, Object> m6 = new HashMap<String, Object>();
				m6.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_1_STRING));
				rawData.put("_widget_1633664138216", m6);// 提报日期-年-月-日
				Map<String, Object> m7 = new HashMap<String, Object>();
				m7.put("value", DateUtils.getAfterDay()+"T02:00:00.000Z");
				rawData.put("_widget_1633936286769", m7);// 运营审批截止时间
				Map<String, Object> m8 = new HashMap<String, Object>();
				m8.put("value", DateUtils.getAfterDay()+"T02:00:00.000Z");
				rawData.put("_widget_1633936286782", m8);// 领导审批截止时间
				Map<String, Object> m9 = new HashMap<String, Object>();
				m9.put("value", maps.get(map.getKey()).split("/")[0]); 
				rawData.put("_widget_1633664141750", m9);// 月回款目标(合计)
				Map<String, Object> m10 = new HashMap<String, Object>();
				m10.put("value", maps.get(map.getKey()).split("/")[1]);
				rawData.put("_widget_1633664141730", m10);// 月累计回款(合计)
				Double mb=Double.valueOf(maps.get(map.getKey()).split("/")[0]);
				Double hk=Double.valueOf(maps.get(map.getKey()).split("/")[1]);
				Map<String, Object> m11 = new HashMap<String, Object>();
				m11.put("value", mb!=0?df.format(hk/mb):0);
				rawData.put("_widget_1633769884088", m11);// 月回款率(合计)
				Map<String, Object> m12 = new HashMap<String, Object>();
				m12.put("value", yyjltb.get(map.getKey()));
				rawData.put("_widget_1633664141923", m12);// 月累计报单(合计)
				Map<String, Object> m13 = new HashMap<String, Object>();
				m13.put("value", yyjfpm.get(map.getKey()).split("/")[0]);
				rawData.put("_widget_1634714352040", m13);// 运营积分
				Map<String, Object> m14 = new HashMap<String, Object>();
				m14.put("value", yyjfpm.get(map.getKey()).split("/")[1]);
				rawData.put("_widget_1634714352077", m14);// 运营排名
//				Map<String, Object> m15 = new HashMap<String, Object>();
//				m15.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_YEAR)+week+"周");
//				rawData.put("_widget_1634884780654", m15);// 提报日期-年-周
				Map<String, Object> m16 = new HashMap<String, Object>();
				m16.put("value", zjhMap.get(map.getKey()));
				rawData.put("_widget_1634884780865", m16);// 与周计划的关联主键
				Map<String, Object> m17 = new HashMap<String, Object>();
				m17.put("value",  yyjlmd.get(map.getKey())*4);
				rawData.put("_widget_1635226380651", m17);// 标准人数
				Map<String, Object> m18 = new HashMap<String, Object>();
				m18.put("value",  sjrs.get(map.getKey()));
				rawData.put("_widget_1635226380671", m18);// 实际人数
				
				Map<String, Object> m25 = new HashMap<String, Object>();
				m25.put("value", kqdk.get(map.getKey())!=null?kqdk.get(map.getKey()).split("/")[0]:"");
				rawData.put("_widget_1633664143364", m25);//打卡时间
				Map<String, Object> m26 = new HashMap<String, Object>();
				m26.put("value", kqdk.get(map.getKey())!=null?kqdk.get(map.getKey()).split("/")[1]:"");
				rawData.put("_widget_1634105683262", m26);//打卡地址
				Map<String, Object> m27 = new HashMap<String, Object>();
				m27.put("value", sjds.get(map.getKey()));
				rawData.put("_widget_1635598709818", m27);//实际店数
				Map<String, Object> m28 = new HashMap<String, Object>();
				m28.put("value", Integer.valueOf(maps.get(map.getKey()).split("/")[3]));
				rawData.put("_widget_1635598709856", m28);//店均回款
				Map<String, Object> m29 = new HashMap<String, Object>();
				m29.put("value", Integer.valueOf(maps.get(map.getKey()).split("/")[2]));
				rawData.put("_widget_1641803484754", m29);//核准店数
    			rz.createDataByworkflow(rawData);
			}
			
		}

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
	
	
	//返回的map为运营员工对应的目标/回款/门店数/店均
	public Map<String, String> getMap(String pp){
		Map<String,String> maps=new HashMap<>();//员工编码对应的员工名称
		JDYAPIUtils mdsjAPI = new JDYAPIUtils(APPID, ENTRYID_MDSJ, APIKEY);
		try {
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			String[] str=new String[2];
			str[0]="null";
			str[1]=DateUtils.getLastDay(DateUtils.getNowDateToString(),DateUtils.FORMAT_1_STRING);
			Map<String, Object> map1 = new HashMap<String, Object>();//实际开业时间：小于当月最后一天
			map1.put("field", "_widget_1641447146029");
			map1.put("type", "text");
			map1.put("method", "range");
			map1.put("value",str);
			condList.add(map1);
			Map<String, Object> map2 = new HashMap<String, Object>();//品牌
			map2.put("field", "_widget_1641447146003");
			map2.put("type", "text");
			map2.put("method", "eq");
			map2.put("value",pp);
			condList.add(map2);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Map<String, Object>> formData0 = mdsjAPI.getAllFormData(null,filter);
			Set<String> set=new HashSet<>();//对应品牌下所有运营员工名称(员工编码)
			for (int i = 0; i < formData0.size(); i++) {
				set.add(formData0.get(i).get("_widget_1641447146011").toString());
				set.add(formData0.get(i).get("_widget_1641447146015").toString());
			}
			
			Map<String,Set<String>> mdMaps=new HashMap<>();
			Map<String,Set<String>> jxsMaps=new HashMap<>();
			Set<String> p01=new HashSet<>();
			Set<String> p02=new HashSet<>();
			for (int i = 0; i < formData0.size(); i++) {
				p01.add(formData0.get(i).get("_widget_1641447146011").toString());
				p02.add(formData0.get(i).get("_widget_1641447146015").toString());
			}
			for(String yyyg:p01){
				Set<String> md=new HashSet<>();
				Set<String> jxs=new HashSet<>();
				for(int i=0;i<formData0.size();i++){
					if(yyyg.equals(formData0.get(i).get("_widget_1641447146011").toString())){
						md.add(formData0.get(i).get("_widget_1641447146025").toString());
						jxs.add(formData0.get(i).get("_widget_1641447146001").toString());
					}
				}
				mdMaps.put(yyyg, md);
				jxsMaps.put(yyyg, jxs);
			}
			
			for(String yyyg:p02){
				Set<String> md=new HashSet<>();
				Set<String> jxs=new HashSet<>();
				for(int i=0;i<formData0.size();i++){
					if(yyyg.equals(formData0.get(i).get("_widget_1641447146015").toString())){
						md.add(formData0.get(i).get("_widget_1641447146025").toString());
						jxs.add(formData0.get(i).get("_widget_1641447146001").toString());
					}
				}
				mdMaps.put(yyyg, md);
				jxsMaps.put(yyyg, jxs);
			}
			
			
			//找出当月有收款单的门店
			JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_DF1, APIKEY);
			final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
    		map1 = new HashMap<String, Object>();
    		map1.put("field", "_widget_1548049038941");//收款年月
    		map1.put("type", "text");
    		map1.put("method", "eq");
    		map1.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
    		condList1.add(map1);
    	    map2 = new HashMap<String, Object>();
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
			final List<Map<String, Object>> condList2 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("field", "_widget_1620722144569");
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", "启用");
			condList2.add(map);
			Map<String, Object> filter2 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList2);
				}
			};
			api = new JDYAPIUtils(APPID, ENTRYID_YDMB, APIKEY);
			List<Map<String, Object>> list=api.getAllFormData(null, filter2);
			Map<String,Integer> ydmb=new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				ydmb.put(list.get(i).get("_widget_1620722144565").toString(), ObjectUtils.getObjectToInteger(list.get(i).get("_widget_1620722145500"))+ObjectUtils.getObjectToInteger(list.get(i).get("_widget_1637561518698")));
			}
			
			final List<Map<String, Object>> condList3 = new ArrayList<Map<String, Object>>();
			map = new HashMap<String, Object>();
			map.put("field", "_widget_1641470066319");
			map.put("type", "text");
			map.put("method", "eq");
			map.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
			condList3.add(map);
			Map<String, Object> filter3 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList3);
				}
			};
			api = new JDYAPIUtils(APPID, ENTRYID_GDMB, APIKEY);
			list=api.getAllFormData(null, filter3);
			Map<String,Integer> gdmb=new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				gdmb.put(list.get(i).get("_widget_1620722144573").toString(), ObjectUtils.getObjectToInteger(list.get(i).get("_widget_1620722145500")));
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
            	mb=gdmb.get(entry.getKey())!=null?gdmb.get(entry.getKey()):mb;
        		maps.put(entry.getKey(),mb+"/"+hk+"/"+mds+"/"+dj);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	public Map<String, Integer> getSjds(String pp){
		JDYAPIUtils kdsq_api = new JDYAPIUtils(APPID, KDSQ_ENTRYID, APIKEY);
		Map<String,Integer> mdMaps=new HashMap<>();
		try {
			final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1560998925033");//运营状态：营业中
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", "营业中");
			condList.add(map0);
			String[] str=new String[2];
			str[0]="null";
			str[1]=DateUtils.getLastDay(DateUtils.getNowDateToString(),DateUtils.FORMAT_1_STRING);
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
			map2.put("value",pp);
			condList.add(map2);
			Map<String, Object> filter = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList);
				}
			};
			List<Map<String, Object>> formData0 = kdsq_api.getAllFormData(null,filter);
			
			Set<String> p01=new HashSet<>();
			for (int i = 0; i < formData0.size(); i++) {
				p01.add(formData0.get(i).get("_widget_1560906554863").toString());
			}
			for(String yyyg:p01){
				int num=0;
				for(int i=0;i<formData0.size();i++){
					if(yyyg.equals(formData0.get(i).get("_widget_1560906554863").toString())){
						num++;
					}
				}
				mdMaps.put(yyyg, num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mdMaps;
	}
	
	
	//返回的map为经销商编码对应的提报
	public Map<String, Double> getMap1(){
		Map<String, Double> maps=new HashMap<>();
		try {
    		JDYAPIUtils api = new JDYAPIUtils(APPID, ENTRYID_C6, APIKEY);
    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
    		Map<String, Object> map = new HashMap<String, Object>();//流程已完成
    		map.put("field", "_widget_1563246850783");
    		map.put("type", "text");
    		map.put("method", "eq");
    		map.put("value", DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE1));
    		condList.add(map);
    		Map<String, Object> filter = new HashMap<String, Object>() {
    			{
    				put("rel", "and");
    				put("cond", condList);
    			}
    		};
    		List<Map<String, Object>> formData0 = api.getAllFormData(null,filter);
    		
    		Set<String> set=new HashSet<>();
    		for (int i = 0; i < formData0.size(); i++) {
    			set.add(formData0.get(i).get("_widget_1563246848148").toString());
			}
    		
    		for (String jxs:set) {
    			Double tb=0.0;
    			for (int i = 0; i < formData0.size(); i++) {
    				if(jxs.equals(formData0.get(i).get("_widget_1563246848148").toString())){
    					tb+=Double.valueOf(formData0.get(i).get("_widget_1563246851087").toString());
    				}
    			}
    			maps.put(jxs, tb);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	
	
	public Map<String, String> getMap2(String ny){
		Map<String, String> maps=new HashMap<>();
		try {
			JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYID_Y5, APIKEY);
			final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1627905992820");//评分年月
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", ny);
			condList0.add(map0);
			Map<String, Object> filter0 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList0);
				}
			};
			List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
			for (int i = 0; i < formData0.size(); i++) {
				maps.put(formData0.get(i).get("_widget_1627886456443").toString(), formData0.get(i).get("_widget_1628477304461").toString()+"/"+formData0.get(i).get("_widget_1628477304402").toString());
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
	
	
	public Map<String, Integer> getMap3(String pp){
		Map<String, Integer> yyjlmdrs=new HashMap<>();
		try {
			JDYAPIUtils kdsq = new JDYAPIUtils(APPID, ENTRYIDC1_1, APIKEY);
			final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
			Map<String, Object> map0 = new HashMap<String, Object>();
			map0.put("field", "_widget_1631788528636");//使用标识
			map0.put("type", "text");
			map0.put("method", "eq");
			map0.put("value", "启用");
			condList0.add(map0);
			Map<String, Object> filter0 = new HashMap<String, Object>() {
				{
					put("rel", "and");
					put("cond", condList0);
				}
			};
			List<Map<String, Object>> formData0 = kdsq.getAllFormData(null,filter0);
			Set<String> p01=new HashSet<String>();
			Set<String> p02=new HashSet<String>();
    		for (int i = 0; i < formData0.size(); i++) {
				if(pp.equals("PD") ||pp.equals("HMW") || ObjectUtils.getString(formData0.get(i).get("_widget_1628169392851")).equals("H0362")){
	    			p02.add(ObjectUtils.getString(formData0.get(i).get("_widget_1628169392779")));//p02运营经理编码
				}
				p01.add(ObjectUtils.getString(formData0.get(i).get("_widget_1627886456443")));//p01运营经理编码
			}
			
			//运营经理对应的门店人数
			for(String yyjlbm:p01) {
				int rs=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(yyjlbm.equals(formData0.get(i).get("_widget_1627886456443").toString())) {
						rs+=ObjectUtils.getObjectToInteger(formData0.get(i).get("_widget_1631151630231"));
					}
				}
				yyjlmdrs.put(yyjlbm, rs);
			}
			for(String yyjlbm:p02) {
				int rs=0;
				for (int i = 0; i < formData0.size(); i++) {
					if(yyjlbm.equals(formData0.get(i).get("_widget_1628169392779").toString())) {
						rs+=ObjectUtils.getObjectToInteger(formData0.get(i).get("_widget_1631151630231"));
					}
				}
				yyjlmdrs.put(yyjlbm, rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yyjlmdrs;
	}
	
	//获取营运经理得考勤打卡记录
	public static Map<String,String> checkWork(){
		Map<String,String> maps=new HashMap<>();
		try {
			//获取运用token
			DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
			OapiGettokenRequest req = new OapiGettokenRequest();
			req.setAppkey("dingrkwmsjxy49yuetoj"); //华生大家居的考勤
			req.setAppsecret("uubZjKClwdM3F47EAE2zFH5vkVOKE59dgx4aFX1VLzh8kEsHgsYws6KFG-OjxRdR");
			req.setHttpMethod("GET");
			OapiGettokenResponse rsp = client.execute(req);
			String token=JSONObject.parseObject(rsp.getBody()).getString("access_token");
			JDYAPIUtils dd = new JDYAPIUtils(APPID, ENTRYID_DD, APIKEY);
			List<Map<String, Object>> dddzb =dd.getAllFormData(null, null);
			Map<String,String> ddMap=new HashMap<>();
			for (int i = 0; i < dddzb.size(); i++) {
				ddMap.put(dddzb.get(i).get("_widget_1633760760830").toString(), dddzb.get(i).get("_widget_1634107736212").toString());
			}
			List<String> list=null;
			for(Map.Entry<String, String> map:ddMap.entrySet()){
				list=new ArrayList<>();
				list.add(map.getValue());
				client = new DefaultDingTalkClient("https://oapi.dingtalk.com/attendance/listRecord");
				OapiAttendanceListRecordRequest req1 = new OapiAttendanceListRecordRequest();
				req1.setUserIds(list);
				req1.setCheckDateFrom(DateUtils.getNowDateToString()+" 00:00:00");
				req1.setCheckDateTo(DateUtils.getNowDateToString()+" 23:59:59");
				OapiAttendanceListRecordResponse rsp1 = client.execute(req1, token);
				JSONArray array=JSONObject.parseObject(rsp1.getBody()).getJSONArray("recordresult");
				for(int i=0;i<array.size();i++){
					if("OnDuty".equals(array.getJSONObject(i).getString("checkType"))){
						maps.put(map.getKey(), DateUtils.getLongToString(array.getJSONObject(i).getString("userCheckTime"),DateUtils.FORMAT_STRING2)+"/"+array.getJSONObject(i).getString("userAddress"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}
}
