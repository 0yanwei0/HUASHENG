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
import com.jxszj.mapper.sap.SapScrkwlTbMapper;
import com.jxszj.mapper.sap.SapXsddpdscTbMapper;
import com.jxszj.pojo.sap.SapScrkwlTb;
import com.jxszj.pojo.sap.SapScrkwlTbExample;
import com.jxszj.pojo.sap.SapScrkwlTbExample.Criteria;
import com.jxszj.pojo.sap.SapXsddpdscTb;
import com.jxszj.pojo.sap.SapXsddpdscTbExample;
import com.jxszj.utils.DateUtils;

/**
 * 
 * <pre>
 * <b>Description:</b> 
 *    定时任务：生产入库物料凭证列表API
 * <b>Author:</b> yanwei
 * <b>Date:</b> 2021年3月16日上午10:19:32
 * </pre>
 */
@Service
public class ScrkwlQuartz {
	
	@Autowired
	private SapScrkwlTbMapper sapScrkwlTbMapper;
	
	@Autowired
	private SapXsddpdscTbMapper sapXsddpdscTbMapper;
	
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
    	List<SapScrkwlTb> sapScrkwlTbs=getJSONArray();
    	List<SapScrkwlTb> lists=new ArrayList<>();
    	
    	for(Map.Entry<String, String> map:maps.entrySet()){
  			 SapScrkwlTb sapScrkwlTb=new SapScrkwlTb();
  			 int rksl=0;//循环每个物料组当日的总交货数
				 for(SapScrkwlTb rkrb:sapScrkwlTbs){
					 if(map.getKey().equals(rkrb.getWlzbm())){
						 rksl+=rkrb.getDrrk();
					 }
				 }
				 sapScrkwlTbMapper.deleteByPrimaryKey(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
				 List<Integer> list=getDays(map.getKey());
				 sapScrkwlTb.setId(map.getKey()+DateUtils.getNowDateToString(DateUtils.FORMAT_INTEGER));
				 sapScrkwlTb.setWlzbm(map.getKey());
				 sapScrkwlTb.setWlzmc(map.getValue());
				 sapScrkwlTb.setDylj(list.get(0)+rksl);
				 sapScrkwlTb.setDyrj((list.get(0)+rksl)/(list.get(1)+1));
				 sapScrkwlTb.setGzrq(DateUtils.getNowDateToString());
				 sapScrkwlTb.setDrrk(rksl);
				 lists.add(sapScrkwlTb);
				 sapScrkwlTbMapper.update(map.getKey(),DateUtils.getNowDateToString("yyyy-MM")+"%", list.get(0)+rksl, (list.get(0)+rksl)/(list.get(1)+1));
  		 }
  		 sapScrkwlTbMapper.insertOrUpdateByBatch(lists);
    	
    	//更新销售订单的生产排单
    	int number=0;
    	for (int i = 0; i < lists.size(); i++) {
    		//更新到排单生产
			if("311".equals(lists.get(i).getWlzbm())){
				updatePdsc("311",lists.get(i).getDrrk());
			}else if("313".equals(lists.get(i).getWlzbm())){
				updatePdsc("313",lists.get(i).getDrrk());
			}else if("312".equals(lists.get(i).getWlzbm()) || "317".equals(lists.get(i).getWlzbm())){
				number+=lists.get(i).getDrrk();
			}
		}
    	updatePdsc("312317",number);
    }
    
    public void updatePdsc(String wlzbm,int sl){
    	SapXsddpdscTbExample sapXsddpdscTbExample=new SapXsddpdscTbExample();
		SapXsddpdscTbExample.Criteria criteria =sapXsddpdscTbExample.createCriteria();
		criteria.andPdrqEqualTo(DateUtils.getNowDateToString());
		criteria.andWlzLike("%"+wlzbm+"%");
		List<SapXsddpdscTb> sapXsddpdscTb=sapXsddpdscTbMapper.selectByExample(sapXsddpdscTbExample);
		if(sapXsddpdscTb.size()==1){
			sapXsddpdscTb.get(0).setRksl(sl);
			sapXsddpdscTbMapper.updateByExample(sapXsddpdscTb.get(0), sapXsddpdscTbExample);
		}
    }
    
    
    public List<Integer> getDays(String wlzbm){
    	List<Integer> list=new ArrayList<>();
    	SapScrkwlTbExample example=new SapScrkwlTbExample();
        Criteria criteria=example.createCriteria();
        criteria.andGzrqLike(DateUtils.getNowDateToString("yyyy-MM")+"%");
        criteria.andWlzbmEqualTo(wlzbm);
    	List<SapScrkwlTb> lists=sapScrkwlTbMapper.selectByExample(example);
    	//当月每个物料的总交货数量
    	int total=0;
    	for(SapScrkwlTb sapScrkwlTb:lists){
    		total+=sapScrkwlTb.getDrrk();
    	}
    	list.add(total);
    	list.add(lists.size());
    	return list;
    }
    
    
    public List<SapScrkwlTb> getJSONArray(){
    	JSONArray  array=new JSONArray();
    	List<SapScrkwlTb> sapScrkwlTbs=new ArrayList<>();
    	try {
    		//获取当天入库的物料
    		CloseableHttpClient httpClient = HttpClientBuilder.create().build();   
    		 HttpGet httpGet = new HttpGet("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_MANUFMADOCITEMLISTAPI_CDS/YY1_ManuFMaDocItemListAPI?$filter=PostingDate%20eq%20datetime'" + DateUtils.getNowDateToString() + "T00:00:00'");
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
		    		SapScrkwlTb sapScrkwlTb=new SapScrkwlTb();
		    		sapScrkwlTb.setGzrq(DateUtils.getLongToString(array.getJSONObject(i).getString("PostingDate"),DateUtils.FORMAT_1_STRING));
		    		sapScrkwlTb.setWlzbm(array.getJSONObject(i).getString("ProductGroup"));
		    		sapScrkwlTb.setWlzmc(array.getJSONObject(i).getString("MaterialGroupName"));
		    		sapScrkwlTb.setDrrk(array.getJSONObject(i).getDouble("QuantityInBaseUnit").intValue());
		    		sapScrkwlTbs.add(sapScrkwlTb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return sapScrkwlTbs;
    }
    
}
