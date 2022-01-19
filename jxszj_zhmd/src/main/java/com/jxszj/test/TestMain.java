package com.jxszj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;

public class TestMain {

	
	private static final String APPID = "5cc110c3b3c41744aaa12b2e";
	private static final String APIKEY = "uWEAujuxvzv5fMVifOvMRzlIJcPLgYkv";
	
	 private static final String KDSQ = "5d102d3f2144352834656205";
	 
	 private static final String ENTRYID_DZJQ = "61079376b4cdc700085a8dd8";
	public static void main(String[] args) {
//		JDYAPIUtils api = new JDYAPIUtils(APPID, KDSQ, APIKEY);
//		List<Map<String, Object>> df = api.getAllFormData(null, null);
//		Map<String,String> map=new HashMap<>();
//		for (int i = 0; i < df.size(); i++) {
//			map.put(df.get(i).get("_widget_1543818219389").toString(), df.get(i).get("_widget_1543818219658").toString());
//		}
//		System.out.println(df.size());
		
		
		JDYAPIUtils api1 = new JDYAPIUtils(APPID, ENTRYID_DZJQ, APIKEY);
		List<Map<String, Object>> dzjq = api1.getAllFormData(null, null);
		System.out.println(dzjq.size());
		
		
		for (int i = 0; i < dzjq.size(); i++) {
			Map<String, Object>rawData = new HashMap<String, Object>();
			Map<String, Object> m0 = new HashMap<String, Object>();
			m0.put("value", "2022-01-17");
			rawData.put("_widget_1631175594703", m0);
			
			
			api1.updateData(dzjq.get(i).get("_id").toString(), rawData);
			System.out.println(i);
		}

	}

}
