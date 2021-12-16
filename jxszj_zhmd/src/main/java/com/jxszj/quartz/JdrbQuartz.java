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
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxszj.mapper.sap.SapJdrbTbMapper;
import com.jxszj.pojo.sap.SapJdrbTb;
import com.jxszj.pojo.sap.SapJdrbTbExample;
import com.jxszj.pojo.sap.SapJdrbTbExample.Criteria;
import com.jxszj.utils.DateUtils;

/**
 * 
 * <pre>
 * <b>Description:</b> 
 *    定时任务：接单日报
 * <b>Author:</b> yanwei
 * <b>Date:</b> 2021年3月16日上午10:19:32
 * </pre>
 */
@Service
public class JdrbQuartz {
	
	@Autowired
	private SapJdrbTbMapper sapJdrbTbMapper;
	
    public void execute(){
    	try {
    		Map<String,String> maps=new HashMap<>();
        	maps.put("311", "床垫自制");
        	maps.put("312", "床架自制");
        	maps.put("313", "床头柜自制");
        	maps.put("314", "枕头自制");
        	maps.put("315", "床品自制");
        	maps.put("316", "自制家具、道具");
        	maps.put("317", "沙发自制");
        	maps.put("318", "电动床自制");
        	maps.put("412", "进口床垫");
        	List<SapJdrbTb> sapJdrbTbs=new ArrayList<>();
    		//获取当天新增的数据
    		List<SapJdrbTb> lists=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=SDDocumentRejectionStatus%20eq%20'A'%20and%20SalesDocumentType%20eq%20'OR'%20and%20CreationDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'",maps);
    		for(Map.Entry<String, String> map:maps.entrySet()){
				 SapJdrbTb sapJdrbTb=new SapJdrbTb();
				 int jdsl=0;//循环每个物料组当日的总接单数
				 for(SapJdrbTb jdrb:lists){
					 if(map.getKey().equals(jdrb.getWlz())){
						 jdsl+=jdrb.getDrjd();
					 }
				 }
				 sapJdrbTbMapper.deleteByPrimaryKey(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
				 List<Integer> list=getDays(map.getKey(),DateUtils.getNowDateToString());
				 sapJdrbTb.setId(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
				 sapJdrbTb.setWlz(map.getKey());
				 sapJdrbTb.setWlzmc(map.getValue());
				 sapJdrbTb.setDylj(list.get(0)+jdsl);
				 sapJdrbTb.setDyrj((list.get(0)+jdsl)/(list.get(1)+1));
				 sapJdrbTb.setRq(DateUtils.getNowDateToString());
				 sapJdrbTb.setDrjd(jdsl);
				 sapJdrbTbs.add(sapJdrbTb);
				 sapJdrbTbMapper.update(map.getKey(),DateUtils.getNowDateToString("yyyy-MM")+"%", list.get(0)+jdsl, (list.get(0)+jdsl)/(list.get(1)+1));
			 }
			sapJdrbTbMapper.insertOrUpdateByBatch(sapJdrbTbs);
    		Set<String> set=new HashSet<>();
    		//获取当天修改的数据
    		lists=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=SalesDocumentType%20eq%20'OR'%20and%20LastChangeDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'",maps);
    		for(SapJdrbTb sapJdrbTb:lists){
    			if(!sapJdrbTb.getRq().equals(DateUtils.getNowDateToString())){
    				set.add(sapJdrbTb.getRq());
    			}
    		}

    		for(String rq:set){
    			lists=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=SDDocumentRejectionStatus%20eq%20'A'%20and%20SalesDocumentType%20eq%20'OR'%20and%20CreationDate%20eq%20datetime'"+rq+"T00:00:00'",maps);
    			for(Map.Entry<String, String> map:maps.entrySet()){
    				SapJdrbTb sapJdrbTb=new SapJdrbTb();
    				int jdsl=0;//循环每个物料组当日的总接单数
    				 for(SapJdrbTb jdrb:lists){
    					 if(map.getKey().equals(jdrb.getWlz())){
    						 jdsl+=jdrb.getDrjd();
    					 }
    				 }
    				 sapJdrbTbMapper.deleteByPrimaryKey(map.getKey()+DateUtils.getDateStringToStringFormat1(rq,DateUtils.FORMAT_INTEGER));
    				 List<Integer> list=getDays(map.getKey(),rq);
    				 sapJdrbTb.setId(map.getKey()+DateUtils.getDateStringToStringFormat1(rq,DateUtils.FORMAT_INTEGER));
    				 sapJdrbTb.setWlz(map.getKey());
    				 sapJdrbTb.setWlzmc(map.getValue());
    				 sapJdrbTb.setDylj(list.get(0)+jdsl);
    				 sapJdrbTb.setDyrj((list.get(0)+jdsl)/(list.get(1)+1));
    				 sapJdrbTb.setRq(rq);
    				 sapJdrbTb.setDrjd(jdsl);
    				 sapJdrbTbs.add(sapJdrbTb);
    				 sapJdrbTbMapper.update(map.getKey(),DateUtils.getDateStringToStringFormat1(rq,"yyyy-MM")+"%", list.get(0)+jdsl, (list.get(0)+jdsl)/(list.get(1)+1));
    			}
    			sapJdrbTbMapper.insertOrUpdateByBatch(sapJdrbTbs);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public List<SapJdrbTb> getHsXsdddjysTbs(String url,Map<String,String> maps) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		List<SapJdrbTb> sapJdrbTbs=new ArrayList<>();
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
				JSONArray  array = jsonObject.getJSONArray("results");
				for (int i = 0; i < array.size(); i++) {
					if(maps.get(array.getJSONObject(i).getString("MaterialGroup"))!=null){
						SapJdrbTb sapJdrbTb=new SapJdrbTb();
						sapJdrbTb.setWlz(array.getJSONObject(i).getString("MaterialGroup"));
						sapJdrbTb.setDrjd(array.getJSONObject(i).getDouble("OrderQuantity").intValue());
						sapJdrbTb.setWlzmc(array.getJSONObject(i).getString("MaterialGroupName"));
						sapJdrbTb.setRq(DateUtils.getLongToString(array.getJSONObject(i).getString("CreationDate"), DateUtils.FORMAT_1_STRING));
						sapJdrbTbs.add(sapJdrbTb);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sapJdrbTbs;
	}
    
    public List<Integer> getDays(String wlzbm,String rq){
    	List<Integer> list=new ArrayList<>();
    	try {
        	SapJdrbTbExample example=new SapJdrbTbExample();
            Criteria criteria=example.createCriteria();
            criteria.andRqLike(DateUtils.getDateStringToStringFormat1(rq,"yyyy-MM")+"%");
            criteria.andWlzEqualTo(wlzbm);
        	List<SapJdrbTb> lists=sapJdrbTbMapper.selectByExample(example);
        	//当月每个物料的总交货数量
        	int total=0;
        	for(SapJdrbTb sapJdrbTb:lists){
        		total+=sapJdrbTb.getDrjd();
        	}
        	list.add(total);
        	list.add(lists.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return list;
    }
}
