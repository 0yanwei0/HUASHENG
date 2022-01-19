package com.jxszj.test;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;

public class DM1 {

	private static final String APPID = "5c048a8379332d0978a68b8e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
 	
 	private static final String ENTRYID = "61c936676abe0700076556e2";
 	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		Map<String, Object> rawData = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("value","测试");
		rawData.put("_widget_1641434422035", m1);// 评分年
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("value","1");
		rawData.put("_widget_1641434422016", m2);// 评分年月
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("data", rawData);
		String strJson=JSON.toJSONString(data);
		StringEntity entity=new StringEntity(strJson, Charset.forName("UTF-8"));

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost("https://api.jiandaoyun.com/api/v3/app/5cc110c3b3c41744aaa12b2e/entry/61d64d34727a980007d5e13b/data_create");
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Authorization","Bearer "+APIKEY);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// 从响应模型中获取响应实体
		HttpEntity responseEntity = response.getEntity();
		String strEntity=EntityUtils.toString(responseEntity);
		System.out.println(strEntity);

	}

}
