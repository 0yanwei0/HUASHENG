package com.jxszj.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.request.OapiRobotSendRequest.Actioncard;
import com.dingtalk.api.request.OapiRobotSendRequest.Btns;
import com.jxszj.mapper.sap.SapJdrbTbMapper;
import com.jxszj.mapper.sap.SapScjhwlTbMapper;
import com.jxszj.mapper.sap.SapScrkwlTbMapper;
import com.jxszj.pojo.sap.SapJdrbTb;
import com.jxszj.pojo.sap.SapJdrbTbExample;
import com.jxszj.pojo.sap.SapScjhwlTb;
import com.jxszj.pojo.sap.SapScjhwlTbExample;
import com.jxszj.pojo.sap.SapScrkwlTb;
import com.jxszj.pojo.sap.SapScrkwlTbExample;
import com.jxszj.pojo.sap.SapScrkwlTbExample.Criteria;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.JDYAPIUtils;

/**
 * 
 * <pre>
 * <b>Description:</b> 
 *    定时任务：交货日报，入库日报，接单日报播报
 * <b>Author:</b> yanwei
 * <b>Date:</b> 2021年3月16日上午10:19:32
 * </pre>
 */
@Service
public class JdjhrkPushQuartz {
	
	@Autowired
	private SapScrkwlTbMapper sapScrkwlTbMapper;
	
	@Autowired
	private SapJdrbTbMapper sapJdrbTbMapper;
	
	@Autowired
	private SapScjhwlTbMapper sapScjhwlTbMapper;
	
	// 简道云
	private static final  String APP_ID = "5c048a8379332d0978a68b8e";
	private static final  String API_KEY = "SGmAqjtntz3q5M0rZqm2b4nGlRpSlah6";
	
	//华生接单日报
	private static final  String ENTRY_JDRB = "60826b230c27c4000934e6ed";
	
	//MES生产入库明细表
	private static final  String ENTRY_RKRB = "605afe3f1fe053000706ff47";
	
	//MES发货日报
	private static final  String ENTRY_JHRB = "60822f25aa402f000850a7d7";

    public void execute(){
    	List<String> urls=new ArrayList<>();
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=1fc6e3796fadda50d78c9264d9a92ae87292298ba364fced0c44d8dd91af014a");
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=5c15bdd890ab387f6663f6d4d62d40cff8a7a37a32a168c905b28b078c744090");
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=9ca7726af64f24d491871c444151f39b0cc16846e0aa7f13263824b2327f217e");
		urls.add("https://oapi.dingtalk.com/robot/send?access_token=f499b56400a19b942137d1cfca9cfd916a37fc38365e394ef5546228820ee4e7");
		pushrkrb(urls);
		pushjdrb(urls);
		pushjhrb(urls);
    }
    
    //钉钉机器人
    public void pushrkrb(List<String> urls){
    	try {
    		JDYAPIUtils api = new JDYAPIUtils(APP_ID, ENTRY_RKRB, API_KEY);
    		StringBuilder sb=new StringBuilder();
    		SapScrkwlTbExample example=new SapScrkwlTbExample();
			Criteria Criteria=example.createCriteria();
	    	Criteria.andGzrqEqualTo(DateUtils.getNowDateToString());
	    	List<SapScrkwlTb> list=sapScrkwlTbMapper.selectByExample(example);
	    	for (SapScrkwlTb sapScrkwlTb:list) {
	    		Map<String, Object>rawData = new HashMap<String, Object>();
	    		Map<String, Object> m1 = new HashMap<String, Object>();
	    		m1.put("value", sapScrkwlTb.getGzrq());
	    		rawData.put("_widget_1616576063843", m1);// 过账日期
	    		Map<String, Object> m2 = new HashMap<String, Object>();
	    		m2.put("value", sapScrkwlTb.getWlzmc());
	    		rawData.put("_widget_1616576063867", m2);// 物料组名称
	    		Map<String, Object> m3 = new HashMap<String, Object>();
	    		m3.put("value", sapScrkwlTb.getWlzbm());
	    		rawData.put("_widget_1617849191061", m3);// 物料组编码
	    		Map<String, Object> m4 = new HashMap<String, Object>();
	    		m4.put("value", sapScrkwlTb.getDrrk());
	    		rawData.put("_widget_1618224607833", m4);// 入库数量
	    		Map<String, Object> m5 = new HashMap<String, Object>();
	    		m5.put("value", sapScrkwlTb.getId());
	    		rawData.put("_widget_1634378461225	", m5);// 主键
	    		
	    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
	    		Map<String, Object> map0 = new HashMap<String, Object>();
	    		map0.put("field", "_widget_1634378461225");
	    		map0.put("type", "text");
	    		map0.put("method", "eq");
	    		map0.put("value", sapScrkwlTb.getId());
	    		condList.add(map0);
	    		Map<String, Object> filter = new HashMap<String, Object>() {
	    			{
	    				put("rel", "and");
	    				put("cond", condList);
	    			}
	    		};
	    		
	            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
	            if(formData.size()==0){
	            	api.createCpData(rawData);
	            }else{
	            	api.updateData(formData.get(0).get("_id").toString(), rawData);
	            }
	    		
	    		//当月每个物料的总入库数量
		    	sb.append("  \n ------------------");
				sb.append("  \n	"+sapScrkwlTb.getWlzmc()+"  \n	"+getStr(4,String.valueOf(sapScrkwlTb.getDrrk()))+"累"+getStr(5,String.valueOf(sapScrkwlTb.getDylj()))+"均"+sapScrkwlTb.getDyrj());
			}
    		for (int i = 0; i < urls.size(); i++) {
            	DingTalkClient client = new DefaultDingTalkClient(urls.get(i));
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle("当日入库信息");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n **自制入库日报**  \n "+sb.toString();
        		
        		actioncard.setText(json);
        		List<Btns> btns=new ArrayList<Btns>();
        		Btns btn1=new Btns();
        		btn1.setTitle("点击查看更多自制入库");
        		btn1.setActionURL("https://dingtalk.jiandaoyun.com/dashboard#/app/5c048a8379332d0978a68b8e/dash/607421a51dbfc00008a0930b");
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
    
    
    public void pushjdrb(List<String> urls){
    	try {
    		StringBuilder sb=new StringBuilder();
    		JDYAPIUtils api = new JDYAPIUtils(APP_ID, ENTRY_JDRB, API_KEY);
            SapJdrbTbExample example=new SapJdrbTbExample();
            com.jxszj.pojo.sap.SapJdrbTbExample.Criteria criteria=example.createCriteria();
            criteria.andRqEqualTo(DateUtils.getNowDateToString());
            List<SapJdrbTb> sapJdrbTbs=sapJdrbTbMapper.selectByExample(example);
        	
    		for (int i = 0; i < sapJdrbTbs.size(); i++) {
    			Map<String, Object>rawData = new HashMap<String, Object>();
	    		Map<String, Object> m1 = new HashMap<String, Object>();
	    		m1.put("value", sapJdrbTbs.get(i).getId());
	    		rawData.put("_widget_1634377368843", m1);// 主键
	    		Map<String, Object> m2 = new HashMap<String, Object>();
	    		m2.put("value", sapJdrbTbs.get(i).getRq());
	    		rawData.put("_widget_1616576063843", m2);// 接单日期
	    		Map<String, Object> m3 = new HashMap<String, Object>();
	    		m3.put("value", sapJdrbTbs.get(i).getWlz());
	    		rawData.put("_widget_1617849191061", m3);// 物料组编码
	    		Map<String, Object> m4 = new HashMap<String, Object>();
	    		m4.put("value", sapJdrbTbs.get(i).getWlzmc());
	    		rawData.put("_widget_1616576063867", m4);// 物料组名称
	    		Map<String, Object> m5 = new HashMap<String, Object>();
	    		m5.put("value", sapJdrbTbs.get(i).getDrjd());
	    		rawData.put("_widget_1618224607833", m5);// 接单数量
	    		Map<String, Object> m6 = new HashMap<String, Object>();
	    		m6.put("value", sapJdrbTbs.get(i).getDylj());
	    		rawData.put("_widget_1634377368691", m6);// 当月累计
	    		Map<String, Object> m7 = new HashMap<String, Object>();
	    		m7.put("value", sapJdrbTbs.get(i).getDyrj());
	    		rawData.put("_widget_1634377368710", m7);// 当月日均
	    		api.createCpData(rawData);
    			
	    		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
	    		Map<String, Object> map0 = new HashMap<String, Object>();
	    		map0.put("field", "_widget_1634377368843");
	    		map0.put("type", "text");
	    		map0.put("method", "eq");
	    		map0.put("value", sapJdrbTbs.get(i).getId());
	    		condList.add(map0);
	    		Map<String, Object> filter = new HashMap<String, Object>() {
	    			{
	    				put("rel", "and");
	    				put("cond", condList);
	    			}
	    		};
	    		
	            List<Map<String, Object>> formData = api.getAllFormData(null,filter);
	            if(formData.size()==0){
	            	api.createCpData(rawData);
	            }else{
	            	api.updateData(formData.get(0).get("_id").toString(), rawData);
	            }
	    		
	            //当月每个物料的总入库数量
		    	sb.append("  \n ------------------");
				sb.append("  \n	"+sapJdrbTbs.get(i).getWlzmc()+"  \n	"+getStr(4,String.valueOf(sapJdrbTbs.get(i).getDrjd()))+"累"+getStr(5,String.valueOf(sapJdrbTbs.get(i).getDylj()))+"均"+sapJdrbTbs.get(i).getDyrj());
			}
			
    		for (int i = 0; i < urls.size(); i++) {
            	DingTalkClient client = new DefaultDingTalkClient(urls.get(i));
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle("当日接单信息");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n **订单接单日报** \n "+sb.toString();
        		
        		actioncard.setText(json);
        		List<Btns> btns=new ArrayList<Btns>();
        		Btns btn1=new Btns();
        		btn1.setTitle("点击查看更多接单信息");
        		btn1.setActionURL("https://dingtalk.jiandaoyun.com/dashboard#/app/5c048a8379332d0978a68b8e/dash/609911436779b50007e2af8a");
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
    
    
    public void pushjhrb(List<String> urls){
    	try {
        	StringBuilder sb=new StringBuilder();
        	JDYAPIUtils api = new JDYAPIUtils(APP_ID, ENTRY_JHRB, API_KEY);
        	//查询当天已交货的物料组
        	SapScjhwlTbExample example=new SapScjhwlTbExample();
        	com.jxszj.pojo.sap.SapScjhwlTbExample.Criteria Criteria=example.createCriteria();
        	Criteria.andGzrqEqualTo(DateUtils.getNowDateToString());
        	List<SapScjhwlTb> sapScjhwlTbs=sapScjhwlTbMapper.selectByExample(example);
        	for (SapScjhwlTb sapScjhwlTb:sapScjhwlTbs) {
            	Map<String, Object>rawData = new HashMap<String, Object>();
        		Map<String, Object> m1 = new HashMap<String, Object>();
        		m1.put("value", sapScjhwlTb.getGzrq());
        		rawData.put("_widget_1616576063843", m1);// 过账日期
        		Map<String, Object> m2 = new HashMap<String, Object>();
        		m2.put("value", sapScjhwlTb.getWlzmc());
        		rawData.put("_widget_1616576063867", m2);// 物料组名称
        		Map<String, Object> m3 = new HashMap<String, Object>();
        		m3.put("value", sapScjhwlTb.getWlzbm());
        		rawData.put("_widget_1617849191061", m3);// 物料组编码
        		Map<String, Object> m4 = new HashMap<String, Object>();
        		m4.put("value", sapScjhwlTb.getDrjh());
        		rawData.put("_widget_1618224607833", m4);// 交货数量
        		Map<String, Object> m5 = new HashMap<String, Object>();
        		m5.put("value", sapScjhwlTb.getId());
        		rawData.put("_widget_1634378707561", m5);// 主键
        		api.createCpData(rawData);
        		
        		final List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
        		Map<String, Object> map0 = new HashMap<String, Object>();
        		map0.put("field", "_widget_1634378707561");
        		map0.put("type", "text");
        		map0.put("method", "eq");
        		map0.put("value", sapScjhwlTb.getId());
        		condList.add(map0);
        		Map<String, Object> filter = new HashMap<String, Object>() {
        			{
        				put("rel", "and");
        				put("cond", condList);
        			}
        		};
        		
                List<Map<String, Object>> formData = api.getAllFormData(null,filter);
                if(formData.size()==0){
                	api.createCpData(rawData);
                }else{
                	api.updateData(formData.get(0).get("_id").toString(), rawData);
                }
                sb.append("  \n ------------------");
    			sb.append("  \n	"+sapScjhwlTb.getWlzmc()+"  \n	"+getStr(4,String.valueOf(sapScjhwlTb.getDrjh()))+"累"+getStr(5,String.valueOf(sapScjhwlTb.getDylj()))+"均"+sapScjhwlTb.getDyrj());
                
    		}
        	
    		for (int i = 0; i < urls.size(); i++) {
            	DingTalkClient client = new DefaultDingTalkClient(urls.get(i));
        		OapiRobotSendRequest request = new OapiRobotSendRequest();
        		request.setMsgtype("actionCard");
        		Actioncard actioncard=new Actioncard();
        		actioncard.setTitle("当日发货信息");
        		String json="截至"+DateUtils.getNowDateToString(DateUtils.FORMAT_3_STRING)+"  \n **发货日报** \n "+sb.toString();
        		
        		actioncard.setText(json);
        		List<Btns> btns=new ArrayList<Btns>();
        		Btns btn1=new Btns();
        		btn1.setTitle("点击查看更多自制发货");
        		btn1.setActionURL("https://dingtalk.jiandaoyun.com/dashboard#/app/5c048a8379332d0978a68b8e/dash/608245c2a9e6fd00084ad4d8");
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
    
    
    public String getStr(int length,String str){
    	StringBuilder sb=new StringBuilder();
    	if(length>str.length()){
    		for (int i = 0; i < length-str.length(); i++) {
				sb.append("  ");
			}
    	}
    	return str+sb.toString()+"            ";
    }
}
