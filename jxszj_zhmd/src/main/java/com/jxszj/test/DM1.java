package com.jxszj.test;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;

public class DM1 {

	private static final String APPID = "5c048a8379332d0978a68b8e";
	private static final String APIKEY = "SGmAqjtntz3q5M0rZqm2b4nGlRpSlah6";
 	
 	private static final String ENTRYID = "61c936676abe0700076556e2";
 	
	public static void main(String[] args) {
		JDYAPIUtils dd = new JDYAPIUtils(APPID, ENTRYID, APIKEY);
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date());
    	int week=calendar.get(Calendar.WEEK_OF_YEAR);//得到当前周

		Map<String, Object> rawData = new HashMap<String, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("value","");
		rawData.put("_widget_1640576618529", m1);// 审批状态
		
		List<Map<String, Object>> lists=new ArrayList<>();
		for(int j=0;j<6;j++){
			Map<String, Object> item = new HashMap<String, Object>();
			Map<String, Object> m3 = new HashMap<String, Object>();
			m3.put("value", DateUtils.getStringDateAddDay(DateUtils.getNowDateToString(),j)+"T00:00:00.000Z");
			item.put("_widget_1640586139405", m3);// 日期
			lists.add(item);
		}
		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("value", lists);
		rawData.put("_widget_1640576618561", m4);
		
		dd.createData(rawData);
		

	}

}
