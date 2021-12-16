package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
import com.jxszj.mapper.sap.SapScjhwlTbMapper;
import com.jxszj.pojo.sap.SapScjhwlTb;
import com.jxszj.pojo.sap.SapScjhwlTbExample;
import com.jxszj.pojo.sap.SapScjhwlTbExample.Criteria;
import com.jxszj.utils.DateUtils;

/**
 * 
 * <pre>
 * <b>Description:</b> 
 *    定时任务：生产交货物料凭证列表API
 * <b>Author:</b> yanwei
 * <b>Date:</b> 2021年3月16日上午10:19:32
 * </pre>
 */
@Service
public class ScjhwlQuartz {
	
	@Autowired
	private SapScjhwlTbMapper sapScjhwlTbMapper;
	
    public void execute(){
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
    	List<SapScjhwlTb> sapScjhwlTbs=getJSONArray();
    	List<SapScjhwlTb> lists=new ArrayList<SapScjhwlTb>();
    	for(Map.Entry<String, String> map:maps.entrySet()){
			 SapScjhwlTb sapScjhwlTb=new SapScjhwlTb();
			 int jhsl=0;//循环每个物料组当日的总交货数
			 for(SapScjhwlTb jhrb:sapScjhwlTbs){
				 if(map.getKey().equals(jhrb.getWlzbm())){
					 jhsl+=jhrb.getDrjh();
				 }
			 }
			 sapScjhwlTbMapper.deleteByPrimaryKey(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
			 List<Integer> list=getDays(map.getKey());
			 sapScjhwlTb.setId(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
			 sapScjhwlTb.setWlzbm(map.getKey());
			 sapScjhwlTb.setWlzmc(map.getValue());
			 sapScjhwlTb.setDylj(list.get(0)+jhsl);
			 sapScjhwlTb.setDyrj((list.get(0)+jhsl)/(list.get(1)+1));
			 sapScjhwlTb.setGzrq(DateUtils.getNowDateToString());
			 sapScjhwlTb.setDrjh(jhsl);
			 lists.add(sapScjhwlTb);
			 sapScjhwlTbMapper.update(map.getKey(),DateUtils.getNowDateToString("yyyy-MM")+"%", list.get(0)+jhsl, (list.get(0)+jhsl)/(list.get(1)+1));
		 }
		 sapScjhwlTbMapper.insertOrUpdateByBatch(lists);
    }
    public List<Integer> getDays(String wlzbm){
    	List<Integer> list=new ArrayList<>();
    	SapScjhwlTbExample example=new SapScjhwlTbExample();
        Criteria criteria=example.createCriteria();
        criteria.andGzrqLike(DateUtils.getNowDateToString("yyyy-MM")+"%");
        criteria.andWlzbmEqualTo(wlzbm);
    	List<SapScjhwlTb> lists=sapScjhwlTbMapper.selectByExample(example);
    	//当月每个物料的总交货数量
    	int total=0;
    	for(SapScjhwlTb sapScjhwlTb:lists){
    		total+=sapScjhwlTb.getDrjh();
    	}
    	list.add(total);
    	list.add(lists.size());
    	return list;
    }
    public List<SapScjhwlTb> getJSONArray(){
    	JSONArray  array=new JSONArray();
    	List<SapScjhwlTb> sapScjhwlTbs=new ArrayList<>();
    	try {
    		//获取当天入库的物料
    		CloseableHttpClient httpClient = HttpClientBuilder.create().build();   
    		HttpGet httpGet = new HttpGet("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_DELIVERYDOCUMENTSAPI_CDS/YY1_DeliveryDocumentsAPI?$filter=ActualGoodsMovementDate%20eq%20datetime'" + DateUtils.getNowDateToString() + "T00:00:00'");
			CloseableHttpResponse response = null;
    		httpGet.setHeader("Content-Type","application/json");
			httpGet.setHeader("Accept","application/json");
			httpGet.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			if(response.getStatusLine().getStatusCode()==200){
				JSONObject jsonObject=JSON.parseObject(EntityUtils.toString(responseEntity));
				jsonObject= jsonObject.getJSONObject("d");
				array = jsonObject.getJSONArray("results");
		    	for (int i = 0; i < array.size(); i++) {
		    		SapScjhwlTb sapScjhwlTb=new SapScjhwlTb();
		    		sapScjhwlTb.setGzrq(DateUtils.getLongToString(array.getJSONObject(i).getString("ActualGoodsMovementDate"),DateUtils.FORMAT_1_STRING));
		    		sapScjhwlTb.setWlzbm(array.getJSONObject(i).getString("MaterialGroup"));
		    		sapScjhwlTb.setWlzmc(array.getJSONObject(i).getString("MaterialGroupText"));
		    		sapScjhwlTb.setDrjh(array.getJSONObject(i).getDouble("ActualDeliveryQuantity").intValue());
		    		sapScjhwlTbs.add(sapScjhwlTb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return sapScjhwlTbs;
    }
    
}
