package com.jxszj.controller.sap;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jxszj.utils.ExcelUtil;
import com.jxszj.utils.MessageResult;
import com.jxszj.utils.ObjectUtils;


//开启生产订单的删除标记
@Controller
@RequestMapping("/scdd")
public class DeletionFlagOrderController {
	
	
	@RequestMapping("/uploadscddExcel")
	@ResponseBody
	public MessageResult uploadscddExcel(@RequestParam("scddExcelFile") MultipartFile scddExcelFile,HttpServletRequest request, HttpServletResponse response){
		List<String> list=new ArrayList<>();
		List<List<Object>> listob = null;
		try {
			if (scddExcelFile==null) {
				return MessageResult.build(null,"上传Excel失败,请重试！");
			}
			InputStream in = null;
			in = scddExcelFile.getInputStream();
			listob = new ExcelUtil().getBankListByExcel(in, scddExcelFile.getOriginalFilename());
			for (int i = 0; i < listob.size(); i++) {
				int code=DeletionFlagOrder(ObjectUtils.getString(listob.get(i).get(0)));
				if(code!=200){
					list.add(ObjectUtils.getString(listob.get(i).get(0)));
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return MessageResult.build(200,list.size()==0?"标记完成，共标记"+listob.size()+"个订单":"标记完成，"+list+"标记失败");
	}
	
	public  int DeletionFlagOrder(String ManufacturingOrder){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_PRODUCTION_ORDER_2_SRV/A_ProductionOrder_2('"+ManufacturingOrder+"')");
		CloseableHttpResponse response = null;
		int code=0;
		try {
			httpGet.setHeader("Content-Type","application/json");
			httpGet.setHeader("Accept","application/json");
			httpGet.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
			httpGet.setHeader("x-csrf-token", "fetch");
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			code=response.getStatusLine().getStatusCode();
			if(code==200){
				String token="";
				String etag="";
				Header[] headers=response.getAllHeaders();
				for (Header h : headers) {
					if (h.getName().equals("x-csrf-token")) {
					   token=h.getValue();
					}
					if(h.getName().equals("etag")){
					   etag=h.getValue();
					}
					
				}
				HttpPost httpPost = new HttpPost("https://my300201-api.saps4hanacloud.cn/sap/opu/odata/sap/API_PRODUCTION_ORDER_2_SRV/DeletionFlagOrder?ManufacturingOrder='"+ManufacturingOrder+"'");
				httpPost.setHeader("Content-Type","application/json; charset=utf-8");
				httpPost.setHeader("Accept","application/json");
				httpPost.setHeader("Authorization", "Basic SkRZVVNFUjpIZmpUUD5UZ2ZxUU10SEVnaFpiVXhtZ2VOdnJmZlh3OUNvQm5BVGps");
				httpPost.setHeader("x-csrf-token",token);
				httpPost.setHeader("If-Match",etag);
				response = httpClient.execute(httpPost);
				code=response.getStatusLine().getStatusCode();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
	
}
