package com.jxszj.service.sap.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxszj.mapper.sap.HsXsdddjysTbMapper;
import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.pojo.sap.HsXsdddjysTb;
import com.jxszj.pojo.sap.HsXsdddjysTbExample;
import com.jxszj.service.sap.IGdtcService;
import com.jxszj.service.sap.IXsdddjysService;
import com.jxszj.service.sap.IYyddtcService;
import com.jxszj.utils.DateUtils;
@Service
public class XsdddjysServiceImpl implements IXsdddjysService {
	
	@Autowired
	private HsXsdddjysTbMapper hsXsdddjysTbMapper;
	
	@Autowired
	private IYyddtcService yyddtcService;
	
	@Autowired
	private IGdtcService gdtcService;

	@Override
	public EUDataGridResult getSapXsdddjysTbList(int page, int rows) {
		HsXsdddjysTbExample example=new HsXsdddjysTbExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		List<HsXsdddjysTb> item=hsXsdddjysTbMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(item);
		// 取记录总条数
		PageInfo<HsXsdddjysTb> pageInfo = new PageInfo<>(item);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public int updateSapXsdddjysTb(String ny) {
		String daytime=DateUtils.getLastDay(ny,"yyyy-M");
		//获取当天新增的数据
		List<HsXsdddjysTb> list=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=CreationDate%20ge%20datetime'"+ny+"-01T00:00:00'%20and%20CreationDate%20le%20datetime'"+daytime+"T00:00:00'");
		int i=hsXsdddjysTbMapper.insertOrUpdateByBatch(list);
		//获取当天修改的数据
		list=getHsXsdddjysTbs("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_SOPEAPI_CDS/YY1_SOPEAPI?$filter=LastChangeDate%20ge%20datetime'"+ny+"-01T00:00:00'%20and%20LastChangeDate%20le%20datetime'"+daytime+"T00:00:00'");
		i+=hsXsdddjysTbMapper.insertOrUpdateByBatch(list);
		
		yyddtcService.updateYyddtc(daytime);//更新运营督导的提成
		
		gdtcService.updateGdtc(daytime);//更新订单提成
		
		return i;
	}
	
	public List<HsXsdddjysTb> getHsXsdddjysTbs(String url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		List<HsXsdddjysTb> hsXsdddjysTbs=new ArrayList<>();
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
					HsXsdddjysTb hsXsdddjysTb=new HsXsdddjysTb();
					hsXsdddjysTb.setId(array.getJSONObject(i).getString("SalesDocument")+array.getJSONObject(i).getString("SalesDocumentItem"));
					hsXsdddjysTb.setXspz(array.getJSONObject(i).getString("SalesDocument"));
					hsXsdddjysTb.setXspzxm(array.getJSONObject(i).getString("SalesDocumentItem"));
					hsXsdddjysTb.setWlz(array.getJSONObject(i).getString("MaterialGroup"));
					hsXsdddjysTb.setDdsl(array.getJSONObject(i).getDouble("OrderQuantity"));
					hsXsdddjysTb.setXsdw(array.getJSONObject(i).getString("OrderQuantityUnit"));
					hsXsdddjysTb.setDhlx(array.getJSONObject(i).getString("YY1_DHLX_SDI"));
					hsXsdddjysTb.setCjptcdgd(array.getJSONObject(i).getString("YY1_CJPTCDGD_SDI"));
					hsXsdddjysTb.setCjptcj(array.getJSONObject(i).getString("YY1_CJPTCJ_SDI"));
					hsXsdddjysTb.setQt(array.getJSONObject(i).getString("YY1_DHQTBZ_SDI"));
					hsXsdddjysTb.setGcgd(array.getJSONObject(i).getString("YY1_SalesPerson_SDI"));
					hsXsdddjysTb.setCpbm(array.getJSONObject(i).getString("Product"));
					hsXsdddjysTb.setJj(array.getJSONObject(i).getDouble("NetPriceAmount"));
					hsXsdddjysTb.setJz(array.getJSONObject(i).getDouble("NetAmount"));
					hsXsdddjysTb.setPzhb(array.getJSONObject(i).getString("TransactionCurrency"));
					hsXsdddjysTb.setCjrq(DateUtils.getLongToString(array.getJSONObject(i).getString("CreationDate"), DateUtils.FORMAT_1_STRING));
					hsXsdddjysTb.setCjny(DateUtils.getLongToString(array.getJSONObject(i).getString("CreationDate"), DateUtils.FORMAT_STRING_MINUTE1));
					hsXsdddjysTb.setXszz(array.getJSONObject(i).getString("SalesOrganization"));
					hsXsdddjysTb.setFxqd(array.getJSONObject(i).getString("DistributionChannel"));
					hsXsdddjysTb.setJxskhbm(array.getJSONObject(i).getString("SoldToParty"));
					hsXsdddjysTb.setDhdh(array.getJSONObject(i).getString("PurchaseOrderByCustomer"));
					hsXsdddjysTb.setTh(array.getJSONObject(i).getString("IsReturnsItem"));
					hsXsdddjysTb.setJjzt(array.getJSONObject(i).getString("SDDocumentRejectionStatus"));
					hsXsdddjysTb.setQxyy(array.getJSONObject(i).getString("SalesContractCanclnReason"));
					hsXsdddjysTb.setThyy(array.getJSONObject(i).getString("ReturnReason"));
					hsXsdddjysTb.setJjyy(array.getJSONObject(i).getString("SalesDocumentRjcnReason"));
					hsXsdddjysTb.setCpms(array.getJSONObject(i).getString("ProductName"));
					hsXsdddjysTb.setWlzms(array.getJSONObject(i).getString("MaterialGroupName"));
					hsXsdddjysTb.setJxskhmc(array.getJSONObject(i).getString("CustomerName"));
					hsXsdddjysTb.setBzjgtjjz(array.getJSONObject(i).getDouble("ConditionBaseValue"));
					hsXsdddjysTb.setBzjgje(array.getJSONObject(i).getDouble("ConditionRateValue"));
					hsXsdddjysTb.setKhzktjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_01"));
					hsXsdddjysTb.setKhzkje(array.getJSONObject(i).getDouble("ConditionRateValue_01"));
					hsXsdddjysTb.setSyfltjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_02"));
					hsXsdddjysTb.setSyflje(array.getJSONObject(i).getDouble("ConditionRateValue_02"));
					hsXsdddjysTb.setCdbltjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_03"));
					hsXsdddjysTb.setCdblje(array.getJSONObject(i).getDouble("ConditionRateValue_03"));
					hsXsdddjysTb.setXxstjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_04"));
					hsXsdddjysTb.setXsje(array.getJSONObject(i).getDouble("ConditionRateValue_04"));
					hsXsdddjysTb.setBzcbgjtjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_05"));
					hsXsdddjysTb.setBzcbgjje(array.getJSONObject(i).getDouble("ConditionRateValue_05"));
					hsXsdddjysTb.setJsjtjjz(array.getJSONObject(i).getDouble("ConditionBaseValue_06"));
					hsXsdddjysTb.setJsjje(array.getJSONObject(i).getDouble("ConditionRateValue_06"));
					if(array.getJSONObject(i).getString("ProductName").split("/").length==1) {
						hsXsdddjysTb.setPp(array.getJSONObject(i).getString("ProductName").split("/")[0]);
					}else {
						hsXsdddjysTb.setPp(array.getJSONObject(i).getString("ProductName").split("/")[0]);
						hsXsdddjysTb.setCpmc(array.getJSONObject(i).getString("ProductName").split("/")[1]);
					}
					hsXsdddjysTb.setGgrq(DateUtils.getLongToString(array.getJSONObject(i).getString("LastChangeDate"), DateUtils.FORMAT_1_STRING));
					hsXsdddjysTb.setXspzlx(array.getJSONObject(i).getString("SalesDocumentType"));
					hsXsdddjysTbs.add(hsXsdddjysTb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hsXsdddjysTbs;
	}


}
