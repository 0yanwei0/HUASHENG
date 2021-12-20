package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.List;

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
import com.jxszj.mapper.sap.HsJxsfhmxTbMapper;
import com.jxszj.pojo.sap.HsJxsfhmxTb;
import com.jxszj.utils.DateUtils;

public class JxsfhmxQuartz {	
	@Autowired
	private HsJxsfhmxTbMapper hsJxsfhmxTbMapper;
	
	public void execute() {

		//获取当天新增的数据
		List<HsJxsfhmxTb> list=getHsJxsfhmxTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_DEALEROUTDETAIL1API_CDS/YY1_DealerOutDetail1API?$filter=ActualGoodsMovementDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'");
				if(list.size()!=0){
					hsJxsfhmxTbMapper.insertOrUpdateByBatch(list);
				}
		//获取当天修改的数据
		list=getHsJxsfhmxTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_DEALEROUTDETAIL1API_CDS/YY1_DealerOutDetail1API?$filter=LastChangeDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'");
				if(list.size()!=0){
					hsJxsfhmxTbMapper.insertOrUpdateByBatch(list);
				}
		
	}
	
	public List<HsJxsfhmxTb> getHsJxsfhmxTbs(String url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		List<HsJxsfhmxTb> hsJxsfhmxTbs=new ArrayList<>();
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
					HsJxsfhmxTb hsJxsfhmxTb=new HsJxsfhmxTb();
					hsJxsfhmxTb.setId(array.getJSONObject(i).getString("OutboundDelivery")+array.getJSONObject(i).getString("OutboundDeliveryItem"));
					hsJxsfhmxTb.setCkjh(array.getJSONObject(i).getString("OutboundDelivery"));
					hsJxsfhmxTb.setWxjhxm(array.getJSONObject(i).getString("OutboundDeliveryItem"));
					hsJxsfhmxTb.setXspz(array.getJSONObject(i).getString("SalesDocument"));
					hsJxsfhmxTb.setXspzxm(array.getJSONObject(i).getString("SalesDocumentItem"));
					hsJxsfhmxTb.setXszz(array.getJSONObject(i).getString("SalesOrganization"));
					hsJxsfhmxTb.setJxskhbm(array.getJSONObject(i).getString("SoldToParty"));
					hsJxsfhmxTb.setJxskhmc(array.getJSONObject(i).getString("CustomerName"));
					hsJxsfhmxTb.setDhdh(array.getJSONObject(i).getString("PurchaseOrderByCustomer"));
					hsJxsfhmxTb.setCpbm(array.getJSONObject(i).getString("Product"));
					hsJxsfhmxTb.setCpms(array.getJSONObject(i).getString("ProductName"));
					hsJxsfhmxTb.setWlz(array.getJSONObject(i).getString("MaterialGroup"));
					hsJxsfhmxTb.setCpzms(array.getJSONObject(i).getString("MaterialGroupName"));
					hsJxsfhmxTb.setDdsl(array.getJSONObject(i).getDouble("OrderQuantity"));
					hsJxsfhmxTb.setXsdw(array.getJSONObject(i).getString("OrderQuantityUnit"));
					hsJxsfhmxTb.setDhlx(array.getJSONObject(i).getString("YY1_DHLX_SDI"));
					hsJxsfhmxTb.setCjptcdgd(array.getJSONObject(i).getString("YY1_CJPTCDGD_SDI"));
					hsJxsfhmxTb.setCjptcj(array.getJSONObject(i).getString("YY1_CJPTCJ_SDI"));
					hsJxsfhmxTb.setQt(array.getJSONObject(i).getString("YY1_DHQTBZ_SDI").getBytes());
					hsJxsfhmxTb.setGcgd(array.getJSONObject(i).getString("YY1_SalesPerson_SDI"));
					hsJxsfhmxTb.setJjzt(array.getJSONObject(i).getString("SDDocumentRejectionStatus"));
					hsJxsfhmxTb.setQxyy(array.getJSONObject(i).getString("SalesContractCanclnReason"));
					hsJxsfhmxTb.setThyy(array.getJSONObject(i).getString("ReturnReason"));
					hsJxsfhmxTb.setJjyy(array.getJSONObject(i).getString("SalesDocumentRjcnReason"));
					hsJxsfhmxTb.setTh(array.getJSONObject(i).getString("IsReturnsItem"));
					hsJxsfhmxTb.setGgrq(DateUtils.getLongToString(array.getJSONObject(i).getString("LastChangeDate"), DateUtils.FORMAT_1_STRING));
					hsJxsfhmxTb.setXspzlx(array.getJSONObject(i).getString("SalesDocumentType"));
					hsJxsfhmxTb.setJhlx(array.getJSONObject(i).getString("DeliveryDocumentType"));
					hsJxsfhmxTb.setSjhwydrq(DateUtils.getLongToString(array.getJSONObject(i).getString("ActualGoodsMovementDate"), DateUtils.FORMAT_1_STRING));
					hsJxsfhmxTb.setHwydzt(array.getJSONObject(i).getString("OverallGoodsMovementStatus"));
					hsJxsfhmxTb.setJhsl(array.getJSONObject(i).getDouble("ActualDeliveryQuantity"));
					hsJxsfhmxTb.setHwydlx(array.getJSONObject(i).getString("GoodsMovementType"));
					hsJxsfhmxTbs.add(hsJxsfhmxTb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hsJxsfhmxTbs;
	}
}
