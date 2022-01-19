package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxszj.mapper.sap.SapHbcpfxTbMapper;
import com.jxszj.pojo.sap.SapHbcpfxTb;
import com.jxszj.pojo.sap.SapHbcpfxTbExample;
import com.jxszj.pojo.sap.SapHbcpfxTbExample.Criteria;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

/**
 * 红包产品分析
 * @author Administrator
 *
 */
public class HbcpfxQuartz {
	
	@Autowired
	private SapHbcpfxTbMapper sapHbcpfxTbMapper;
	
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";

    private static final String C6_ENTRYID = "5d2d229eee266915714e9e1e";
    
    //C6.4报单下单产品系列对账表
    private static final String ENTRYID = "619dda8e10bfac000731df4e";
    
    //C6.5未领红包报单产品清单
    private static final String C65_ENTRYID = "61a073b02f54bb0007b3afe1";
	
	public void execute() {
		SapHbcpfxTbExample example =new SapHbcpfxTbExample();
		Criteria criteria=example.createCriteria();
		criteria.andNyEqualTo(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE));
		sapHbcpfxTbMapper.deleteByExample(example);
		
		String month=DateUtils.getNowDateToString(DateUtils.FORMAT_STRING1_MINUTE);
		//获取当月新增的订单数据
		JSONArray array=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=YY1_DHLX_SDI%20eq%20'日常返单'%20and%20SDDocumentRejectionStatus%20eq%20'A'%20and%20CreationDate%20ge%20datetime'"+DateUtils.getStringToMonthOneDay()+"T00:00:00'");
		
		//查询营业中的门店,且实际开业时间小于当前日期
		JDYAPIUtils api = new JDYAPIUtils(APPID, C6_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList0 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1563246850783");//开单年月
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", month);
		condList0.add(map0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("field", "flowState");//审批状态：审批通过
		map1.put("type", "text");
		map1.put("method", "eq");
		map1.put("value", 1);
		condList0.add(map1);
		Map<String, Object> filter0 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList0);
			}
		};
		Set<String> set=new HashSet<>();
		List<Map<String, Object>> formDatas = api.getAllFormData(null,filter0);
		for (int i = 0; i < formDatas.size(); i++) {
			if("CUST0443".equals(formDatas.get(i).get("_widget_1563246848148").toString())){
				continue;
			}
			List<Map<String, Object>> formData =(List<Map<String, Object>>)formDatas.get(i).get("_widget_1628480645184");
			for (int j = 0; j < formData.size(); j++) {
				set.add(formDatas.get(i).get("_widget_1637805769032").toString()+formData.get(j).get("_widget_1628480645296").toString());
			}
		}
		
		api = new JDYAPIUtils(APPID, C65_ENTRYID, APIKEY);
		final List<Map<String, Object>> condList1 = new ArrayList<Map<String, Object>>();
		map0 = new HashMap<String, Object>();
		map0.put("field", "_widget_1563246850783");//开单年月
		map0.put("type", "text");
		map0.put("method", "eq");
		map0.put("value", month);
		condList1.add(map0);
		Map<String, Object> filter1 = new HashMap<String, Object>() {
			{
				put("rel", "and");
				put("cond", condList1);
			}
		};
		List<Map<String, Object>> formDatas1 = api.getAllFormData(null,filter1);
		Map<String,Integer> maps=new HashMap<>();
		for (int i = 0; i < formDatas1.size(); i++) {
			int num=ObjectUtils.getObjectToInteger(formDatas1.get(i).get("_widget_1637905453422"));
			if(maps.get(formDatas1.get(i).get("_widget_1637805769032").toString()+formDatas1.get(i).get("_widget_1637905453350").toString())!=null){
				num=maps.get(formDatas1.get(i).get("_widget_1637805769032").toString()+formDatas1.get(i).get("_widget_1637905453350").toString())+num;
			}
			maps.put(formDatas1.get(i).get("_widget_1637805769032").toString()+formDatas1.get(i).get("_widget_1637905453350").toString(), num);
		}

		for(String str:set){
			int bdsl=0;
			int jldj=0;
			int jlje=0;
			String jxsmc="";
			String jxsbm="";
			String wlz="";
			String wlmc="";
			String rq="";
			String ny="";
			SapHbcpfxTb sapHbcpfxTb=new SapHbcpfxTb();
			for (int i = 0; i < formDatas.size(); i++) {
				List<Map<String, Object>> formData =(List<Map<String, Object>>)formDatas.get(i).get("_widget_1628480645184");
				for (int j = 0; j < formData.size(); j++) {
					if(str.equals(formDatas.get(i).get("_widget_1637805769032").toString()+formData.get(j).get("_widget_1628480645296").toString())){
						bdsl+=ObjectUtils.getObjectToInteger(formData.get(j).get("_widget_1628480645320"));
						jldj=ObjectUtils.getObjectToInteger(formData.get(j).get("_widget_1628480645492"));
						jlje+=ObjectUtils.getObjectToInteger(formData.get(j).get("_widget_1628480645752"));
						jxsmc=formDatas.get(i).get("_widget_1563246848132").toString();
						jxsbm=formDatas.get(i).get("_widget_1637805769032").toString();
						wlz=formData.get(j).get("_widget_1628480645253").toString();
						wlmc=formData.get(j).get("_widget_1628480645296").toString();
						rq=formDatas.get(i).get("_widget_1601374424302").toString();
						ny=formDatas.get(i).get("_widget_1563246850783").toString();
					}
				}
			}
			sapHbcpfxTb.setJxsbm(jxsbm);
			sapHbcpfxTb.setJxsmc(jxsmc);
			sapHbcpfxTb.setWlz(wlz);
			sapHbcpfxTb.setWlmc(wlmc);
			sapHbcpfxTb.setJldj(jldj);
			sapHbcpfxTb.setBdsl(bdsl);
			sapHbcpfxTb.setJlje(jlje);
			sapHbcpfxTb.setRq(rq);
			sapHbcpfxTb.setNy(ny);
			sapHbcpfxTb.setBmwl(str);
			sapHbcpfxTb.setDdsl(0);
			sapHbcpfxTb.setWlsl(maps.get(str)!=null?maps.get(str):0);
			sapHbcpfxTbMapper.insert(sapHbcpfxTb);
		}
		api = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		formDatas = api.getAllFormData(null,null);
		Map<String,String> map=new HashMap<>();
		for (int i = 0; i < formDatas.size(); i++) {
			map.put(formDatas.get(i).get("_widget_1637735054480").toString(), formDatas.get(i).get("_widget_1637735054461").toString());
		}
		
		for(String str:set){
			int ddsl=0;
			for (int i = 0; i < array.size(); i++) {
				if(!array.getJSONObject(i).getString("ProductName").contains("/")){
					continue;
				}
				String wlbm="";
				if(map.get(array.getJSONObject(i).getString("ProductName").split("/")[1])!=null){
					wlbm=array.getJSONObject(i).getString("SoldToParty")+map.get(array.getJSONObject(i).getString("ProductName").split("/")[1]);
				}else{
					wlbm=array.getJSONObject(i).getString("SoldToParty")+array.getJSONObject(i).getString("ProductName").split("/")[1];
				}
				if(str.equals(wlbm)){
					ddsl+=array.getJSONObject(i).getDouble("OrderQuantity").intValue();
				}
			}
			sapHbcpfxTbMapper.updateByBmwl(ddsl, month, str);
		}
	}
	
	public JSONArray getHsXsdddjysTbs(String url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		JSONArray  array = new JSONArray();
		try {
			httpGet.setHeader("Content-Type","application/json");
			httpGet.setHeader("Accept","application/json");
			httpGet.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			if(response.getStatusLine().getStatusCode()==200) {
				JSONObject jsonObject=JSON.parseObject(EntityUtils.toString(responseEntity));
				jsonObject = jsonObject.getJSONObject("d");
				array = jsonObject.getJSONArray("results");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
}
