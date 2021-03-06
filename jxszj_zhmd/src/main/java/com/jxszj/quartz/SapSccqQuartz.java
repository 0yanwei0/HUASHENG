package com.jxszj.quartz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.dingtalk.api.request.OapiRobotSendRequest.Btns;
import com.jxszj.mapper.sap.SapConditionCqTbMapper;
import com.jxszj.mapper.sap.SapFxddCqTbMapper;
import com.jxszj.mapper.sap.SapWlpzqdCqTbMapper;
import com.jxszj.mapper.sap.SapXsddCqTbMapper;
import com.jxszj.pojo.sap.SapConditionCqTb;
import com.jxszj.pojo.sap.SapConditionCqTbExample;
import com.jxszj.pojo.sap.SapFxddCqTb;
import com.jxszj.pojo.sap.SapWlpzqdCqTb;
import com.jxszj.pojo.sap.SapXsddCqTb;
import com.jxszj.pojo.sap.SapXsddCqTbExample;
import com.jxszj.pojo.sap.SapXsddCqTbExample.Criteria;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;
import com.jxszj.utils.ObjectUtils;

@Service
public class SapSccqQuartz {

	@Autowired
	private SapFxddCqTbMapper sapFxddCqTbMapper;
	
	@Autowired
	private SapXsddCqTbMapper sapXsddCqTbMapper;
	
	@Autowired
	private SapWlpzqdCqTbMapper sapWlpzqdCqTbMapper;
	
	@Autowired
	private SapConditionCqTbMapper sapConditionCqTbMapper;
	
	
	public void execute() {
		//??????????????????????????????
		Map<String,String> wlzMap=new HashMap<String,String>();
		wlzMap.put("311", "????????????");
		wlzMap.put("312", "????????????");
		wlzMap.put("313", "???????????????");
		wlzMap.put("316", "?????????????????????");
		wlzMap.put("317", "????????????");
		wlzMap.put("318", "???????????????");
		
		//??????????????????,???????????????J1????????????????????????
		String jxszj_appId = "5cc110c3b3c41744aaa12b2e";
		String jxszj_entryId = "5e7ec57478cb560006d32863";
		String jxszj_apiKey = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
		JDYAPIUtils jxszj_api=  new JDYAPIUtils(jxszj_appId, jxszj_entryId, jxszj_apiKey);
		List<Map<String, Object>> jxszjList= jxszj_api.getAllFormData(null, null);
		Map<String,String> kh=new HashMap<>();
		for (int i = 0; i < jxszjList.size(); i++) {
			kh.put(jxszjList.get(i).get("_widget_1585380393487").toString(), jxszjList.get(i).get("_widget_1585380393515").toString());
		}
		
		List<SapConditionCqTb> sapConditionCqTbs=sapConditionCqTbMapper.selectByExample(new SapConditionCqTbExample());
		
		try {
			//????????????????????????
			List<SapXsddCqTb> sapXsddCqTbs=new ArrayList<>();
			Set<String> xspzs=new HashSet<>();//??????????????????
			JSONArray jSONArray=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrder?$filter=CreationDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'%20and%20SalesOrderType%20eq%20'OR'");
			for (int i = 0; i < jSONArray.size(); i++) {
				if("100206".equals(jSONArray.getJSONObject(i).getString("SoldToParty"))){
					continue;
				}
				if(!"B001".equals(jSONArray.getJSONObject(i).getString("SalesOrganization"))){
					continue;
				}
				//???????????????????????????
				JSONArray  jSONArray1=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrder('"+jSONArray.getJSONObject(i).getString("SalesOrder")+"')/to_Item");
				for (int j = 0; j < jSONArray1.size(); j++) {
					String wlms=jSONArray1.getJSONObject(j).getString("SalesOrderItemText");
					String wlz=jSONArray1.getJSONObject(j).getString("MaterialGroup");
					if(wlzMap.get(wlz)==null){
						continue;
					}
					//???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????+?????????
					boolean make=false;
					for(SapConditionCqTb sapConditionCqTb:sapConditionCqTbs){
						if(wlms.contains(sapConditionCqTb.getCondiname())){
							make=true;
						}
					}
					if(make){
						continue;
					}
					JSONObject  jSONObject=getItem("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrderScheduleLine(SalesOrder='"+jSONArray.getJSONObject(i).getString("SalesOrder")+"',SalesOrderItem='"+jSONArray1.getJSONObject(j).getString("SalesOrderItem")+"',ScheduleLine='1')");
					
					SapXsddCqTb sapXsddCqTb=new SapXsddCqTb();
					sapXsddCqTb.setId(jSONArray.getJSONObject(i).getString("SalesOrder")+jSONArray1.getJSONObject(j).getInteger("SalesOrderItem"));
					sapXsddCqTb.setXspz(jSONArray.getJSONObject(i).getString("SalesOrder"));
					sapXsddCqTb.setXspzxm(jSONArray1.getJSONObject(j).getInteger("SalesOrderItem"));
					sapXsddCqTb.setWl(jSONArray1.getJSONObject(j).getString("Material"));
					sapXsddCqTb.setSl(jSONArray1.getJSONObject(j).getDouble("RequestedQuantity").intValue());
					sapXsddCqTb.setKhck(jSONArray.getJSONObject(i).getString("PurchaseOrderByCustomer"));
					sapXsddCqTb.setSdf(kh.get(jSONArray.getJSONObject(i).getString("SoldToParty")));
					sapXsddCqTb.setWlms(jSONArray1.getJSONObject(j).getString("SalesOrderItemText"));
					sapXsddCqTb.setXszz(jSONArray.getJSONObject(i).getString("SalesOrganization"));
					sapXsddCqTb.setJjyy(jSONArray1.getJSONObject(j).getString("SalesDocumentRjcnReason"));
					sapXsddCqTb.setJhrq(jSONObject!=null?DateUtils.getLongToString(jSONObject.getString("RequestedDeliveryDate"), "yyyy-MM-dd"):DateUtils.getLongToString(jSONArray.getJSONObject(i).getString("RequestedDeliveryDate"), "yyyy-MM-dd"));
					sapXsddCqTb.setWlz(wlzMap.get(wlz));
					if(wlz.equals("311")){
						sapXsddCqTb.setSsfz("?????????");
					}else if(wlz.equals("313")){
						sapXsddCqTb.setSsfz("?????????");
					}else if(wlz.equals("317")){
						sapXsddCqTb.setSsfz("?????????");
					}else if(wlz.equals("318")){
						sapXsddCqTb.setSsfz("?????????");
					}else if(wlz.equals("312")){
						sapXsddCqTb.setSsfz("?????????");
					}else if(wlz.equals("316")){
						if(wlms.contains("????????????") || wlms.contains("??????") || wlms.contains("??????")){
							sapXsddCqTb.setSsfz("?????????");
						}else if(wlms.contains("??????") || wlms.contains("?????????")){
							sapXsddCqTb.setSsfz("?????????");
						}else{
							sapXsddCqTb.setSsfz("?????????");
						}
					}
					sapXsddCqTb.setCjrq(DateUtils.getLongToString(jSONArray.getJSONObject(i).getString("CreationDate"), "yyyy-MM-dd"));
					sapXsddCqTb.setXgrq(DateUtils.getLongToString(jSONArray.getJSONObject(i).getString("LastChangeDate"), "yyyy-MM-dd"));
					sapXsddCqTb.setTcrq("");
					sapXsddCqTb.setYy("");
					sapXsddCqTbs.add(sapXsddCqTb);
					xspzs.add(jSONArray.getJSONObject(i).getString("SalesOrder"));
				}
			}
			if(sapXsddCqTbs.size()!=0){
				sapXsddCqTbMapper.insertByBatch(sapXsddCqTbs);
			}
//			????????????????????????????????????
			jSONArray=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrder?$filter=LastChangeDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'%20and%20SalesOrderType%20eq%20'OR'");
			for (int i = 0; i < jSONArray.size(); i++) {
				
				if("100206".equals(jSONArray.getJSONObject(i).getString("SoldToParty"))){
					continue;
				}
				if(!"B001".equals(jSONArray.getJSONObject(i).getString("SalesOrganization"))){
					continue;
				}
				//???????????????????????????
				JSONArray  jSONArray1=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrder('"+jSONArray.getJSONObject(i).getString("SalesOrder")+"')/to_Item");
				for (int j = 0; j < jSONArray1.size(); j++) {
					String wlms=jSONArray1.getJSONObject(j).getString("SalesOrderItemText");
					String wlz=jSONArray1.getJSONObject(j).getString("MaterialGroup");
					if(wlzMap.get(wlz)==null){
						continue;
					}
					//???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????+?????????
					boolean make=false;
					for(SapConditionCqTb sapConditionCqTb:sapConditionCqTbs){
						if(wlms.contains(sapConditionCqTb.getCondiname())){
							make=true;
						}
					}
					if(make){
						continue;
					}
					JSONObject  jSONObject=getItem("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_SALES_ORDER_SRV/A_SalesOrderScheduleLine(SalesOrder='"+jSONArray.getJSONObject(i).getString("SalesOrder")+"',SalesOrderItem='"+jSONArray1.getJSONObject(j).getString("SalesOrderItem")+"',ScheduleLine='1')");
					//??????????????????????????????
					SapXsddCqTb sapXsddCqTb=sapXsddCqTbMapper.selectByPrimaryKey(jSONArray.getJSONObject(i).getString("SalesOrder")+jSONArray1.getJSONObject(j).getInteger("SalesOrderItem"));
					if(sapXsddCqTb!=null){
						//???????????????????????????
						sapXsddCqTb.setSl(jSONArray1.getJSONObject(j).getDouble("RequestedQuantity").intValue());
						sapXsddCqTb.setKhck(jSONArray.getJSONObject(i).getString("PurchaseOrderByCustomer"));
						sapXsddCqTb.setSdf(kh.get(jSONArray.getJSONObject(i).getString("SoldToParty")));
						sapXsddCqTb.setJjyy(jSONArray1.getJSONObject(j).getString("SalesDocumentRjcnReason"));
						sapXsddCqTb.setJhrq(jSONObject!=null?DateUtils.getLongToString(jSONObject.getString("RequestedDeliveryDate"), "yyyy-MM-dd"):DateUtils.getLongToString(jSONArray.getJSONObject(i).getString("RequestedDeliveryDate"), "yyyy-MM-dd"));
						sapXsddCqTb.setXgrq(DateUtils.getLongToString(jSONArray.getJSONObject(i).getString("LastChangeDate"), "yyyy-MM-dd"));
						sapXsddCqTbMapper.updateByPrimaryKey(sapXsddCqTb);
					}
					xspzs.add(jSONArray.getJSONObject(i).getString("SalesOrder"));
				}
			}
			
			//????????????????????????
			List<SapWlpzqdCqTb> sapWlpzqdCqTbs=new ArrayList<>();
			JSONArray wlpzqdjSONArray=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_MATERIALDOCUMENT_CDS/YY1_MaterialDocument?$filter=CreationDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'");
			for (int i = 0; i < wlpzqdjSONArray.size(); i++) {
				JSONObject json=getItem("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_MATERIAL_DOCUMENT_SRV/A_MaterialDocumentItem(MaterialDocumentYear='"+wlpzqdjSONArray.getJSONObject(i).getString("MaterialDocumentYear")+"',MaterialDocument='"+wlpzqdjSONArray.getJSONObject(i).getString("MaterialDocument")+"',MaterialDocumentItem='"+wlpzqdjSONArray.getJSONObject(i).getInteger("MaterialDocumentItem")+"')");
				SapWlpzqdCqTb sapWlpzqdCqTb=new SapWlpzqdCqTb();
				sapWlpzqdCqTb.setCcdd(wlpzqdjSONArray.getJSONObject(i).getString("StorageLocation"));
				sapWlpzqdCqTb.setYdlx(wlpzqdjSONArray.getJSONObject(i).getString("GoodsMovementType"));
				sapWlpzqdCqTb.setTskc(wlpzqdjSONArray.getJSONObject(i).getString("InventorySpecialStockType"));
				sapWlpzqdCqTb.setLrrq(DateUtils.getLongToString(wlpzqdjSONArray.getJSONObject(i).getString("CreationDate"), "yyyy-MM-dd"));
				sapWlpzqdCqTb.setWl(wlpzqdjSONArray.getJSONObject(i).getString("Material"));
				sapWlpzqdCqTb.setSl(wlpzqdjSONArray.getJSONObject(i).getDouble("QuantityInBaseUnit").intValue());
				sapWlpzqdCqTb.setWlpz(wlpzqdjSONArray.getJSONObject(i).getString("MaterialDocument"));
				sapWlpzqdCqTb.setWlpzxm(wlpzqdjSONArray.getJSONObject(i).getInteger("MaterialDocumentItem"));
				sapWlpzqdCqTb.setYear(wlpzqdjSONArray.getJSONObject(i).getString("MaterialDocumentYear"));
				sapWlpzqdCqTb.setId(json.getString("SpecialStockIdfgSalesOrder")+json.getInteger("SpecialStockIdfgSalesOrderItem"));
				sapWlpzqdCqTb.setXsdd(json.getString("SpecialStockIdfgSalesOrder"));
				sapWlpzqdCqTb.setXsddxm(json.getInteger("SpecialStockIdfgSalesOrderItem"));
				sapWlpzqdCqTbs.add(sapWlpzqdCqTb);
			}
			if(sapWlpzqdCqTbs.size()!=0){
				sapWlpzqdCqTbMapper.insertByBatch(sapWlpzqdCqTbs);
			}
			
			//??????????????????
			List<SapFxddCqTb> sapFxddCqTbs=new ArrayList<>();
			JSONArray fxddjSONArray=getItems("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_CUSTOMER_RETURN_SRV/A_CustomerReturn?$filter=CreationDate%20eq%20datetime'"+DateUtils.getNowDateToString()+"T00:00:00'");
			for (int i = 0; i < fxddjSONArray.size(); i++) {
				SapFxddCqTb sapFxddCqTb=new SapFxddCqTb();
				sapFxddCqTb.setXspz(fxddjSONArray.getJSONObject(i).getString("CustomerReturn"));
				sapFxddCqTb.setCjrq(DateUtils.getLongToString(fxddjSONArray.getJSONObject(i).getString("CreationDate"), "yyyy-MM-dd"));
//				sapFxddCqTb.setYdrq(DateUtils.getLongToString(fxddjSONArray.getJSONObject(i).getString("ActualGoodsMovementDate"), "yyyy-MM-dd"));
				sapFxddCqTbs.add(sapFxddCqTb);
			}
			if(sapFxddCqTbs.size()!=0){
				sapFxddCqTbMapper.insertByBatch(sapFxddCqTbs);
			}
			
			
			
			if(xspzs.size()!=0){
				//???????????????????????????????????????
				SapXsddCqTbExample sapXsddCqTbExample = new SapXsddCqTbExample();
				Criteria criteria=sapXsddCqTbExample.createCriteria();
				criteria.andXspzIn(new ArrayList<>(xspzs));
				criteria.andKhckLike("%???%");
				List<SapXsddCqTb> listSapXsddCqTb=sapXsddCqTbMapper.selectByExample(sapXsddCqTbExample);
				String stringDate="";
				for (int i = 0; i < listSapXsddCqTb.size(); i++) {
					SapXsddCqTb sapXsddCqTb=listSapXsddCqTb.get(i);
					List<String> fxdds=getFxdds(sapXsddCqTb.getKhck());
					//???????????????????????????
					sapFxddCqTbs = sapFxddCqTbMapper.selectByFxdd(fxdds);
					if(sapFxddCqTbs!=null && sapFxddCqTbs.size()!=0){
						stringDate=DateUtils.getStringDateAddDay(sapFxddCqTbs.get(0).getCjrq(),7);
					}
					//????????????????????????????????????
					if(!"".equals(stringDate)){
						sapXsddCqTb.setJhrq(stringDate);
						sapXsddCqTbMapper.updateByPrimaryKey(sapXsddCqTb);
					}else if("".equals(stringDate) && "".equals(sapXsddCqTb.getJhrq())){
						sapXsddCqTb.setJhrq("2000-01-01");
						sapXsddCqTbMapper.updateByPrimaryKey(sapXsddCqTb);
					}
					
				}
				//?????????????????????????????????????????????????????????????????????,????????????????????????
				for (String xspz:xspzs) {
					SapXsddCqTb sapXsddCqTb=sapXsddCqTbMapper.selectMaxjhrq(xspz);
					sapXsddCqTbMapper.updateNjhrq(sapXsddCqTb);
				}
			}
			
			
			List<String> days=DateUtils.getDays();
			LinkedHashMap<String,List<Map<String, Object>>> map=new LinkedHashMap<>();
			for (int i = 0; i < days.size(); i++) {
				List<Map<String, Object>> lists=new ArrayList<>();
				//??????????????????????????????
				sapXsddCqTbMapper.createXsddView(days.get(i), DateUtils.getBeforeThree(days.get(i)));
				//??????????????????????????????
				sapWlpzqdCqTbMapper.createWlpzqdView(days.get(i));
				
				List<Map<String, Object>> list1=sapXsddCqTbMapper.selectCqXsdd1();
				
				for (int j = 0; j < list1.size(); j++) {
					if(!"".equals(ObjectUtils.getString(list1.get(j).get("tcrq"))) && DateUtils.compareDateString(days.get(i), ObjectUtils.getString(list1.get(j).get("tcrq")))){
						list1.remove(j);
						j--;
					}
				}
				List<Map<String, Object>> list2=sapXsddCqTbMapper.selectCqXsdd2();
				for (int j = 0; j < list2.size(); j++) {
					if(!"".equals(ObjectUtils.getString(list2.get(j).get("tcrq"))) && DateUtils.compareDateString(days.get(i), ObjectUtils.getString(list2.get(j).get("tcrq")))){
						list2.remove(j);
						j--;
					}
				}
				
				lists.addAll(list1);
				lists.addAll(list2);
				map.put(days.get(i), lists);
				sapXsddCqTbMapper.dropView();
				sapWlpzqdCqTbMapper.dropView();
			}
			String str=getXSSFWorkbook(map);
			//?????????????????????????????????
			List<String> urls=new ArrayList<>();
    		urls.add("https://oapi.dingtalk.com/robot/send?access_token=1fc6e3796fadda50d78c9264d9a92ae87292298ba364fced0c44d8dd91af014a");
    		urls.add("https://oapi.dingtalk.com/robot/send?access_token=5c15bdd890ab387f6663f6d4d62d40cff8a7a37a32a168c905b28b078c744090");
    		urls.add("https://oapi.dingtalk.com/robot/send?access_token=9ca7726af64f24d491871c444151f39b0cc16846e0aa7f13263824b2327f217e");
			urls.add("https://oapi.dingtalk.com/robot/send?access_token=f499b56400a19b942137d1cfca9cfd916a37fc38365e394ef5546228820ee4e7");
    		for (int i = 0; i < urls.size(); i++) {
    			DingTalkClient client = new DefaultDingTalkClient(urls.get(i));
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle("??????????????????");
        		String json="??????"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n **????????????** \n "+str;
        		
        		actioncard.setText(json);
        		List<Btns> btns=new ArrayList<Btns>();
        		Btns btn1=new Btns();
        		btn1.setTitle("??????????????????");
        		btn1.setActionURL("http://www.huasheng999.com/downloadExcel?strDate="+DateUtils.getNowDateToString(DateUtils.FORMAT_2_STRING));
        		btns.add(btn1);
        		
        		actioncard.setBtns(btns);
        		actioncard.setBtnOrientation("0");
        		request.setActionCard(actioncard);
        		client.execute(request);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getFxdds(String khck){
		khck=khck.trim();
		String fxdd=khck.substring(khck.indexOf("???")+1,khck.indexOf("???"));
		List<String> list=Arrays.asList(fxdd.split("???"));
		return list;
	}
	
	public static JSONArray getItems(String url){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();   
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		JSONArray  jSONArray=new JSONArray();
		try {
			httpGet.setHeader("Content-Type","application/json");
			httpGet.setHeader("Accept","application/json");
			httpGet.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
			// ??????????????????(??????)Get??????
			response = httpClient.execute(httpGet);
			// ????????????????????????????????????
			HttpEntity responseEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode()==200) {
				JSONObject jsonObject1=JSON.parseObject(EntityUtils.toString(responseEntity));
				Object obj1 = jsonObject1.get("d");
				JSONObject jsonObject2=(JSONObject)JSON.toJSON(obj1);
				String str=jsonObject2.get("results").toString();
				jSONArray = JSONObject.parseArray(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jSONArray;
	}
	
	
	
	public JSONObject getItem(String url){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();   
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		JSONObject  jsonObject1=null;;
		try {
			httpGet.setHeader("Content-Type","application/json");
			httpGet.setHeader("Accept","application/json");
			httpGet.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
			// ??????????????????(??????)Get??????
			response = httpClient.execute(httpGet);
			// ????????????????????????????????????
			HttpEntity responseEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode()==200) {
				JSONObject jsonObject=JSON.parseObject(EntityUtils.toString(responseEntity));
				Object obj = jsonObject.get("d");
				jsonObject1=(JSONObject)JSON.toJSON(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject1;
	}
	
	public int getTotal(List<SapWlpzqdCqTb> sapWlpzqdCqTbs){
		int total=0;
		for (int i = 0; i < sapWlpzqdCqTbs.size(); i++) {
			total+=sapWlpzqdCqTbs.get(i).getSl();
		}
		return total;
	}
	
	public String getXSSFWorkbook(LinkedHashMap<String,List<Map<String, Object>>> map){  
		StringBuilder sb=new StringBuilder();
		try {
			//??????Excel??????     
			// E:\\work\\jxszj_zhmd\\src\\main\\webapp\\WEB-INF\\excel\\??????.xlsx      
			// /root/opt/jxszj/apache-tomcat-7.0.105/webapps/jxszj_zhmd/WEB-INF/excel/??????.xlsx
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(new File("/root/opt/jxszj/apache-tomcat-7.0.105/webapps/jxszj_zhmd/WEB-INF/excel/??????.xlsx")));
			XSSFSheet sheet=workbook.getSheetAt(0);//???????????????sheet
			int rowIndex = 8;
			
			Set<String> set=map.keySet();
			for (String day:set) {
				List<Map<String, Object>> list=map.get(day);
				for (int j = 0; j < list.size(); j++) {
					XSSFRow row = sheet.getRow(rowIndex);
					if (null == row) {
						row = sheet.createRow(rowIndex);
					}
					XSSFCell cell0 = row.getCell(0);
					if (null == cell0) {
						cell0 = row.createCell(0);
					}
					cell0.setCellValue(day);

					XSSFCell cell1 = row.getCell(1);
					if (null == cell1) {
						cell1 = row.createCell(1);
					}
					cell1.setCellValue(ObjectUtils.getString(list.get(j).get("xspz")));
					
					XSSFCell cell2 = row.getCell(2);
					if (null == cell2) {
						cell2 = row.createCell(2);
					}
					cell2.setCellValue(ObjectUtils.getString(list.get(j).get("sdf")));

					XSSFCell cell3 = row.getCell(3);
					if (null == cell3) {
						cell3 = row.createCell(3);
					}
					cell3.setCellValue(ObjectUtils.getString(list.get(j).get("khck")));

					XSSFCell cell4 = row.getCell(4);
					if (null == cell4) {
						cell4 = row.createCell(4);
					}
					cell4.setCellValue(ObjectUtils.getString(list.get(j).get("xszz")));
					
					XSSFCell cell5 = row.getCell(5);
					if (null == cell5) {
						cell5 = row.createCell(5);
					}
					cell5.setCellValue(ObjectUtils.getString(list.get(j).get("xspzxm")));
					
					XSSFCell cell6 = row.getCell(6);
					if (null == cell6) {
						cell6 = row.createCell(6);
					}
					cell6.setCellValue(ObjectUtils.getString(list.get(j).get("wlms")));
					
					XSSFCell cell7 = row.getCell(7);
					if (null == cell7) {
						cell7 = row.createCell(7);
					}
					cell7.setCellValue(ObjectUtils.getString(list.get(j).get("wl")));
					
					XSSFCell cell8 = row.getCell(8);
					if (null == cell8) {
						cell8 = row.createCell(8);
					}
					cell8.setCellValue(ObjectUtils.getString(list.get(j).get("wlz")));
					
					XSSFCell cell9 = row.getCell(9);
					if (null == cell9) {
						cell9 = row.createCell(9);
					}
					cell9.setCellValue(ObjectUtils.getString(list.get(j).get("ssfz")));
					
					XSSFCell cell10 = row.getCell(10);
					if (null == cell10) {
						cell10 = row.createCell(10);
					}
					cell10.setCellValue(ObjectUtils.getString(list.get(j).get("sl")));
					
					XSSFCell cell11 = row.getCell(11);
					if (null == cell11) {
						cell11 = row.createCell(11);
					}
					cell11.setCellValue(ObjectUtils.getString(list.get(j).get("njhrq")));
					rowIndex++;
				}
			}
			
			//???????????????sheet
			XSSFSheet sheet1=workbook.getSheetAt(1);
			// ??????
			XSSFRow row0 = sheet1.getRow(0);
			if (null == row0) {
				row0 = sheet1.createRow(0);
			}

			XSSFCell rq = row0.getCell(0);
			if (null == rq) {
				rq = row0.createCell(0);
			}
			rq.setCellValue(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE)+"????????????");
			
			XSSFCell rq1 = row0.getCell(4);
			if (null == rq1) {
				rq1 = row0.createCell(4);
			}
			rq1.setCellValue(DateUtils.getNowDateToString(DateUtils.FORMAT_STRING_MINUTE2));
			
			List<List<String>> lists=new ArrayList<>();//???????????????????????????
			
			List<String> item=new ArrayList<>();
			List<String> item1=new ArrayList<>();
			List<String> item2=new ArrayList<>();
			int num=0;
			for (String day:set) {
				item.add(day);
				Set<String> sets=new HashSet<>();//??????
				List<Map<String, Object>> list=map.get(day);
				for (int j = 0; j < list.size(); j++) {
					sets.add(ObjectUtils.getString(list.get(j).get("xspz")));
				}
				item1.add(String.valueOf(sets.size()));
				num+=sets.size();
				item2.add(String.valueOf(num));
			}
			lists.add(item);
			lists.add(item1);
			lists.add(item2);
			lists.addAll(getList(map,"?????????"));
			lists.addAll(getList(map,"?????????"));
			lists.addAll(getList(map,"?????????"));
			
			//?????????????????????
			XSSFRow row1 = sheet1.getRow(1);
			if (null == row1) {
				row1 = sheet1.createRow(1);
			}

			XSSFCell cell5 = row1.getCell(5);
			if (null == cell5) {
				cell5 = row1.createCell(5);
			}
			cell5.setCellValue(lists.get(1).get(lists.get(1).size()-1));
			
			XSSFCell cell6 = row1.getCell(6);
			if (null == cell6) {
				cell6 = row1.createCell(6);
			}
			cell6.setCellValue(lists.get(3).get(lists.get(3).size()-1));
			
			XSSFCell cell7 = row1.getCell(7);
			if (null == cell7) {
				cell7 = row1.createCell(7);
			}
			cell7.setCellValue(lists.get(5).get(lists.get(5).size()-1));
			
			XSSFCell cell8 = row1.getCell(8);
			if (null == cell8) {
				cell8 = row1.createCell(8);
			}
			cell8.setCellValue(lists.get(7).get(lists.get(7).size()-1));
			
			XSSFRow row2 = sheet1.getRow(2);
			if (null == row2) {
				row2 = sheet1.createRow(2);
			}
			XSSFCell cell9 = row2.getCell(5);
			if (null == cell9) {
				cell9 = row2.createCell(5);
			}
			cell9.setCellValue(lists.get(2).get(lists.get(2).size()-1));
			
			XSSFCell cell10 = row2.getCell(6);
			if (null == cell10) {
				cell10 = row2.createCell(6);
			}
			cell10.setCellValue(lists.get(4).get(lists.get(4).size()-1));
			
			XSSFCell cell11 = row2.getCell(7);
			if (null == cell11) {
				cell11 = row2.createCell(7);
			}
			cell11.setCellValue(lists.get(6).get(lists.get(6).size()-1));
			
			XSSFCell cell12 = row2.getCell(8);
			if (null == cell12) {
				cell12 = row2.createCell(8);
			}
			cell12.setCellValue(lists.get(8).get(lists.get(8).size()-1));
			
			sb.append("  \n ------------------");
    		sb.append("  \n                   ????????????           ????????????");
    		sb.append("  \n ------------------");
			sb.append("  \n	?????????           "+getStr(2,lists.get(1).get(lists.get(1).size()-1))+lists.get(2).get(lists.get(2).size()-1));
			sb.append("  \n ------------------");
			sb.append("  \n	?????????           "+getStr(2,lists.get(3).get(lists.get(3).size()-1))+lists.get(4).get(lists.get(4).size()-1));
			sb.append("  \n ------------------");
			sb.append("  \n	?????????           "+getStr(2,lists.get(5).get(lists.get(5).size()-1))+lists.get(6).get(lists.get(6).size()-1));
			sb.append("  \n ------------------");
			sb.append("  \n	?????????           "+getStr(2,lists.get(7).get(lists.get(7).size()-1))+lists.get(8).get(lists.get(8).size()-1));
			
			//???????????????????????????
			rowIndex=5;
			for (int i = 0; i < lists.size(); i++) {
				XSSFRow row = sheet1.getRow(rowIndex);
				if (null == row) {
					row = sheet1.createRow(rowIndex);
				}
				List<String> data=lists.get(i);
				for (int j = 0; j < data.size(); j++) {
					XSSFCell cell = row.getCell(j+2);
					if (null == cell) {
						cell = row.createCell(j+2);
					}
					cell.setCellValue(data.get(j));
				}
				rowIndex++;
			}
			
			// 
			FileOutputStream fos = new FileOutputStream("/root/excel/"+DateUtils.getNowDateToString(DateUtils.FORMAT_2_STRING)+"????????????.xlsx");  
			workbook.write(fos);//?????????
			fos.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	//?????????????????????????????????????????????
	public List<List<String>> getList(LinkedHashMap<String,List<Map<String, Object>>> map,String ssfz){
		List<List<String>> lists=new ArrayList<>();
		List<String> item1=new ArrayList<>();
		List<String> item2=new ArrayList<>();
		int num=0;
		Set<String> set=map.keySet();
		for (String day:set) {
			Set<String> sets=new HashSet<>();//??????
			List<Map<String, Object>> list=map.get(day);
			for (int j = 0; j < list.size(); j++) {
				if(ssfz.equals(ObjectUtils.getString(list.get(j).get("ssfz")))){
					sets.add(ObjectUtils.getString(list.get(j).get("xspz")));
				}
				
			}
			item1.add(String.valueOf(sets.size()));
			num+=sets.size();
			item2.add(String.valueOf(num));
		}
		lists.add(item1);
		lists.add(item2);
		return lists;
	}

    public String getStr(int length,String str){
    	StringBuilder sb=new StringBuilder();
    	if(length>str.length()){
    		for (int i = 0; i < length-str.length(); i++) {
				sb.append(" ");
			}
    	}
    	return str+sb.toString()+"                     ";
    }
    
}
