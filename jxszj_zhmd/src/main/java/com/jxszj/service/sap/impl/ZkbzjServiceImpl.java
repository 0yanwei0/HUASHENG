package com.jxszj.service.sap.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis2.Constants.Configuration;
import org.apache.axis2.databinding.types.Token;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxszj.mapper.sap.SapZkbzjTbMapper;
import com.jxszj.pojo.EUDataGridResult;
import com.jxszj.pojo.sap.SapZkbzjTb;
import com.jxszj.pojo.sap.SapZkbzjTbExample;
import com.jxszj.pojo.sap.SapZkbzjTbExample.Criteria;
import com.jxszj.service.sap.IZkbzjService;
import com.jxszj.utils.DateUtils;
import com.jxszj.utils.ExcelUtil;
import com.jxszj.utils.ObjectUtils;
import com.jxszj.utils.ServiceStub;
import com.jxszj.utils.ServiceStub.AccountingBusinessTransactionTypeCode;
import com.jxszj.utils.ServiceStub.AccountingDocumentTypeCode;
import com.jxszj.utils.ServiceStub.Amount;
import com.jxszj.utils.ServiceStub.BusinessDocumentMessageHeader;
import com.jxszj.utils.ServiceStub.BusinessDocumentMessageID;
import com.jxszj.utils.ServiceStub.BusinessPartnerInternalID;
import com.jxszj.utils.ServiceStub.BusinessTransactionDocumentItemID;
import com.jxszj.utils.ServiceStub.BusinessTransactionDocumentTypeCode;
import com.jxszj.utils.ServiceStub.CompanyCodeID;
import com.jxszj.utils.ServiceStub.CreatedByUser;
import com.jxszj.utils.ServiceStub.CurrencyCode;
import com.jxszj.utils.ServiceStub.Date;
import com.jxszj.utils.ServiceStub.DebitCreditCode;
import com.jxszj.utils.ServiceStub.DocumentHeaderText;
import com.jxszj.utils.ServiceStub.DocumentItemText;
import com.jxszj.utils.ServiceStub.GLOBAL_DateTime;
import com.jxszj.utils.ServiceStub.JournalEntryBulkCreateRequest;
import com.jxszj.utils.ServiceStub.JournalEntryCreateConfirmationMessage;
import com.jxszj.utils.ServiceStub.JournalEntryCreateRequestBulkMessage;
import com.jxszj.utils.ServiceStub.JournalEntryCreateRequestJournalEntry;
import com.jxszj.utils.ServiceStub.JournalEntryCreateRequestJournalEntryDebtorItem;
import com.jxszj.utils.ServiceStub.JournalEntryCreateRequestJournalEntryDownPayment;
import com.jxszj.utils.ServiceStub.JournalEntryCreateRequestMessage;
import com.jxszj.utils.ServiceStub.LogItem;
import com.jxszj.utils.ServiceStub.OriginalReferenceDocumentLogicalSystem;
import com.jxszj.utils.ServiceStub.SpecialGLCode;

@Service
public class ZkbzjServiceImpl implements IZkbzjService {
	
	@Autowired
	private SapZkbzjTbMapper sapZkbzjTbMapper;

	@Override
	public int uploadExcel(HttpServletRequest request, HttpServletResponse response, MultipartFile file)
			throws Exception {
		InputStream in = null;
		List<List<Object>> listob = null;
		int num=0;
		DecimalFormat df = new DecimalFormat("#0.00");
		try {
			in = file.getInputStream();
			listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
			
			List<SapZkbzjTb> list=new ArrayList<SapZkbzjTb>();
			for (int i = 1; i < listob.size(); i++) {
				SapZkbzjTb sapZkbzjTb=new SapZkbzjTb();
				sapZkbzjTb.setZz(ObjectUtils.getString(listob.get(i).get(0)));
				sapZkbzjTb.setKm(ObjectUtils.getString(listob.get(i).get(1)));
				sapZkbzjTb.setJe(df.format(ObjectUtils.getDouble(listob.get(i).get(2))));
				sapZkbzjTb.setCjr(ObjectUtils.getString(listob.get(i).get(3)));
				sapZkbzjTb.setDate(DateUtils.getNowDate());
				sapZkbzjTb.setPzrq(ObjectUtils.getString(listob.get(i).get(4)));
				sapZkbzjTb.setGzrq(ObjectUtils.getString(listob.get(i).get(5)));
				sapZkbzjTb.setHtext(ObjectUtils.getString(listob.get(i).get(6)));
				sapZkbzjTb.setText(ObjectUtils.getString(listob.get(i).get(7)));
				list.add(sapZkbzjTb);
			}
			
			List<SapZkbzjTb> lists=new ArrayList<SapZkbzjTb>();
			for (int i = 0; i < list.size(); i++) {
				lists.add(sendSAPPost(list.get(i)));
			}
			num=sapZkbzjTbMapper.insertByBatch(lists);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
//	@Override
//	public void sendPost(List<Integer> list) {
//		SapDskqzTbExample example = new SapDskqzTbExample();
//		Criteria criteria=example.createCriteria();
//		criteria.andIdIn(list);
//		List<SapDskqzTb> sapDskqzTbs=sapZkbzjTbMapper.selectByExample(example);
//		for (int i = 0; i < sapDskqzTbs.size(); i++) {
//			sapDskqzTbMapper.updateByPrimaryKey(sendSAPPost(sapDskqzTbs.get(i)));
//		}
//		
//	}
	
	
	
	//同步到SAP过账（含清账）
	public SapZkbzjTb sendSAPPost(SapZkbzjTb sapZkbzjTb){
		try {
			ServiceStub stub = new ServiceStub();
			Authenticator auth = new Authenticator();
			auth.setUsername("JDYUSER");
			auth.setPassword("HfjTP>TgfqQMtHEghZbUxmgeNvrffXw9CoBnATjl");
			stub._getServiceClient().getOptions().setProperty(HTTPConstants.AUTHENTICATE, auth);
			stub._getServiceClient().getOptions().setProperty(Configuration.CHARACTER_SET_ENCODING, "GBK");
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(300 * 1000);
			stub._getServiceClient().getOptions().setProperty(Configuration.HTTP_METHOD, HTTPConstants.HTTP_METHOD_POST);
			
			
			JournalEntryBulkCreateRequest journalEntryBulkCreateRequest=new JournalEntryBulkCreateRequest(); //最外层节点
			JournalEntryCreateRequestBulkMessage journalEntryCreateRequestBulkMessage=new JournalEntryCreateRequestBulkMessage();//包含头部MessageHeader和JournalEntryCreateRequest主体
			BusinessDocumentMessageHeader businessDocumentMessageHeader=new BusinessDocumentMessageHeader();//头部MessageHeader中的ID和CreationDateTime
			//组装头部MessageHeader中的ID
			BusinessDocumentMessageID businessDocumentMessageIDHeader=new BusinessDocumentMessageID();
			Token tokenHeader=new Token();
			tokenHeader.setValue("msg_"+System.currentTimeMillis());
			businessDocumentMessageIDHeader.setBusinessDocumentMessageIDContent(tokenHeader);
			businessDocumentMessageHeader.setID(businessDocumentMessageIDHeader);
			//组装头部MessageHeader中的CreationDateTime
			GLOBAL_DateTime gLOBAL_DateTimeHeader=new GLOBAL_DateTime();
			gLOBAL_DateTimeHeader.setGLOBAL_DateTime(DateUtils.getNowDateToString()+"T00:00:00.000Z");
			businessDocumentMessageHeader.setCreationDateTime(gLOBAL_DateTimeHeader);
			//添加头部MessageHeader信息
			journalEntryCreateRequestBulkMessage.setMessageHeader(businessDocumentMessageHeader);
			
			//组装JournalEntryCreateRequest主体数据
			JournalEntryCreateRequestMessage journalEntryCreateRequestMessage=new JournalEntryCreateRequestMessage();
			//添加JournalEntryCreateRequest主体的头部---------
			BusinessDocumentMessageHeader businessDocumentMessageHeaderEntry=new BusinessDocumentMessageHeader();
			//添加JournalEntryCreateRequest主体的头部ID
			BusinessDocumentMessageID businessDocumentMessageIDEntry=new BusinessDocumentMessageID();
			Token tokenEntry=new Token();
			tokenEntry.setValue("msg_"+System.currentTimeMillis());
			businessDocumentMessageIDEntry.setBusinessDocumentMessageIDContent(tokenEntry);
			businessDocumentMessageHeaderEntry.setID(businessDocumentMessageIDEntry);
			//添加JournalEntryCreateRequest主体的头部CreationDateTime
			GLOBAL_DateTime gLOBAL_DateTimeEntry=new GLOBAL_DateTime();
			gLOBAL_DateTimeEntry.setGLOBAL_DateTime(DateUtils.getNowDateToString()+"T00:00:00.000Z");
			businessDocumentMessageHeaderEntry.setCreationDateTime(gLOBAL_DateTimeEntry);
			journalEntryCreateRequestMessage.setMessageHeader(businessDocumentMessageHeaderEntry);
			
			//添加JournalEntryCreateRequest主体的内容-----------
			JournalEntryCreateRequestJournalEntry journalEntryCreateRequestJournalEntry=new JournalEntryCreateRequestJournalEntry();
			//开始组装主体数据
			BusinessTransactionDocumentTypeCode businessTransactionDocumentTypeCode=new BusinessTransactionDocumentTypeCode();
			Token token1=new Token();
			token1.setValue("BKPFF");
			businessTransactionDocumentTypeCode.setBusinessTransactionDocumentTypeCode(token1);
			journalEntryCreateRequestJournalEntry.setOriginalReferenceDocumentType(businessTransactionDocumentTypeCode);
			
//			ReferenceDocumentID referenceDocumentID=new ReferenceDocumentID();
//			Token token2=new Token();
//			token2.setValue("00001");
//			referenceDocumentID.setReferenceDocumentID(token2);
//			journalEntryCreateRequestJournalEntry.setOriginalReferenceDocument(referenceDocumentID);
			
			OriginalReferenceDocumentLogicalSystem originalReferenceDocumentLogicalSystem=new OriginalReferenceDocumentLogicalSystem();
			Token token3=new Token();
			token3.setValue("0M2S511");
			originalReferenceDocumentLogicalSystem.setOriginalReferenceDocumentLogicalSystem(token3);
			journalEntryCreateRequestJournalEntry.setOriginalReferenceDocumentLogicalSystem(originalReferenceDocumentLogicalSystem);
			
			AccountingBusinessTransactionTypeCode accountingBusinessTransactionTypeCode=new AccountingBusinessTransactionTypeCode();
			Token token4=new Token();
			token4.setValue("RFBU");
			accountingBusinessTransactionTypeCode.setAccountingBusinessTransactionTypeCode(token4);
			journalEntryCreateRequestJournalEntry.setBusinessTransactionType(accountingBusinessTransactionTypeCode);
			
			AccountingDocumentTypeCode accountingDocumentTypeCode=new AccountingDocumentTypeCode();
			Token token5=new Token();
			token5.setValue("SA");
			accountingDocumentTypeCode.setAccountingDocumentTypeCode(token5);
			journalEntryCreateRequestJournalEntry.setAccountingDocumentType(accountingDocumentTypeCode);
			
//			DocumentReferenceID documentReferenceID=new DocumentReferenceID();
//			Token token6=new Token();
//			token6.setValue(data.getString("_widget_1548037673456"));
//			documentReferenceID.setDocumentReferenceID(token6);
//			journalEntryCreateRequestJournalEntry.setDocumentReferenceID(documentReferenceID);
			
//			DocumentHeaderText documentHeaderText=new DocumentHeaderText();
//			documentHeaderText.setDocumentHeaderText(data.getString("_widget_1587439548589"));
//			journalEntryCreateRequestJournalEntry.setDocumentHeaderText(documentHeaderText);
			
			CreatedByUser createdByUser=new CreatedByUser();
			Token token7=new Token();
			token7.setValue(sapZkbzjTb.getCjr());
			createdByUser.setCreatedByUser(token7);
			journalEntryCreateRequestJournalEntry.setCreatedByUser(createdByUser);
			
			CompanyCodeID companyCodeID=new CompanyCodeID();
			Token token8=new Token();
			token8.setValue(sapZkbzjTb.getZz());
			companyCodeID.setCompanyCodeID(token8);
			journalEntryCreateRequestJournalEntry.setCompanyCode(companyCodeID);
			
			Date documentDate=new Date();
			documentDate.setDate(sapZkbzjTb.getPzrq());
			journalEntryCreateRequestJournalEntry.setDocumentDate(documentDate);
			
			Date postingDate=new Date();
			postingDate.setDate(sapZkbzjTb.getGzrq());
			journalEntryCreateRequestJournalEntry.setPostingDate(postingDate);
			
			DocumentHeaderText param=new DocumentHeaderText();
			param.setDocumentHeaderText(sapZkbzjTb.getHtext());
			journalEntryCreateRequestJournalEntry.setDocumentHeaderText(param);

			//债务人
			JournalEntryCreateRequestJournalEntryDebtorItem journalEntryCreateRequestJournalEntryDebtorItem1=new JournalEntryCreateRequestJournalEntryDebtorItem();
			BusinessTransactionDocumentItemID businessTransactionDocumentItemIDDebtorItem1=new BusinessTransactionDocumentItemID();
			Token token13=new Token();
			token13.setValue("1");
			businessTransactionDocumentItemIDDebtorItem1.setBusinessTransactionDocumentItemID(token13);
			journalEntryCreateRequestJournalEntryDebtorItem1.setReferenceDocumentItem(businessTransactionDocumentItemIDDebtorItem1);
			
			BusinessPartnerInternalID businessPartnerInternalID1=new BusinessPartnerInternalID();
			Token token14=new Token();
			token14.setValue(sapZkbzjTb.getKm());
			businessPartnerInternalID1.setBusinessPartnerInternalID(token14);
			journalEntryCreateRequestJournalEntryDebtorItem1.setDebtor(businessPartnerInternalID1);
			
			Amount amountDebtorItem1=new Amount();
			amountDebtorItem1.setAmountContent(new BigDecimal(sapZkbzjTb.getJe()));
			CurrencyCode currencyCodeDebtorItem1=new CurrencyCode();
			Token token15=new Token();
			token15.setValue("CNY");
			currencyCodeDebtorItem1.setCurrencyCode(token15);
			amountDebtorItem1.setCurrencyCode(currencyCodeDebtorItem1);
			journalEntryCreateRequestJournalEntryDebtorItem1.setAmountInTransactionCurrency(amountDebtorItem1);
			
			DebitCreditCode debitCreditCodeDebtorItem1=new DebitCreditCode();
			Token token16=new Token();
			token16.setValue("S");
			debitCreditCodeDebtorItem1.setDebitCreditCode(token16);
			journalEntryCreateRequestJournalEntryDebtorItem1.setDebitCreditCode(debitCreditCodeDebtorItem1);
			
			JournalEntryCreateRequestJournalEntryDownPayment journalEntryCreateRequestJournalEntryDownPayment1=new JournalEntryCreateRequestJournalEntryDownPayment();
			SpecialGLCode specialGLCode1=new SpecialGLCode();
			Token token18=new Token();
			token18.setValue("A");
			specialGLCode1.setSpecialGLCode(token18);
			journalEntryCreateRequestJournalEntryDownPayment1.setSpecialGLCode(specialGLCode1);
			journalEntryCreateRequestJournalEntryDebtorItem1.setDownPaymentTerms(journalEntryCreateRequestJournalEntryDownPayment1);
			
			DocumentItemText itemParam1=new DocumentItemText();
			itemParam1.setDocumentItemText(sapZkbzjTb.getText());
			journalEntryCreateRequestJournalEntryDebtorItem1.setDocumentItemText(itemParam1);
			
			//贷方
			JournalEntryCreateRequestJournalEntryDebtorItem journalEntryCreateRequestJournalEntryDebtorItem2=new JournalEntryCreateRequestJournalEntryDebtorItem();
			BusinessTransactionDocumentItemID businessTransactionDocumentItemIDDebtorItem2=new BusinessTransactionDocumentItemID();
			Token token19=new Token();
			token19.setValue("2");
			businessTransactionDocumentItemIDDebtorItem2.setBusinessTransactionDocumentItemID(token19);
			journalEntryCreateRequestJournalEntryDebtorItem2.setReferenceDocumentItem(businessTransactionDocumentItemIDDebtorItem2);
			
			BusinessPartnerInternalID businessPartnerInternalID2=new BusinessPartnerInternalID();
			Token token20=new Token();
			token20.setValue(sapZkbzjTb.getKm());
			businessPartnerInternalID2.setBusinessPartnerInternalID(token20);
			journalEntryCreateRequestJournalEntryDebtorItem2.setDebtor(businessPartnerInternalID2);
			
			Amount amountDebtorItem2=new Amount();
			amountDebtorItem2.setAmountContent(new BigDecimal(-Double.parseDouble(sapZkbzjTb.getJe())));
			CurrencyCode currencyCodeDebtorItem2=new CurrencyCode();
			Token token21=new Token();
			token21.setValue("CNY");
			currencyCodeDebtorItem2.setCurrencyCode(token21);
			amountDebtorItem2.setCurrencyCode(currencyCodeDebtorItem2);
			journalEntryCreateRequestJournalEntryDebtorItem2.setAmountInTransactionCurrency(amountDebtorItem2);
			
			DebitCreditCode debitCreditCodeDebtorItem2=new DebitCreditCode();
			Token token22=new Token();
			token22.setValue("H");
			debitCreditCodeDebtorItem2.setDebitCreditCode(token22);
			journalEntryCreateRequestJournalEntryDebtorItem2.setDebitCreditCode(debitCreditCodeDebtorItem2);
			
			JournalEntryCreateRequestJournalEntryDownPayment journalEntryCreateRequestJournalEntryDownPayment2=new JournalEntryCreateRequestJournalEntryDownPayment();
			SpecialGLCode specialGLCode2=new SpecialGLCode();
			Token token23=new Token();
			token23.setValue("E");
			specialGLCode2.setSpecialGLCode(token23);
			journalEntryCreateRequestJournalEntryDownPayment2.setSpecialGLCode(specialGLCode2);
			journalEntryCreateRequestJournalEntryDebtorItem2.setDownPaymentTerms(journalEntryCreateRequestJournalEntryDownPayment2);
			
			DocumentItemText itemParam2=new DocumentItemText();
			itemParam2.setDocumentItemText(sapZkbzjTb.getText());
			journalEntryCreateRequestJournalEntryDebtorItem2.setDocumentItemText(itemParam2);
			
			JournalEntryCreateRequestJournalEntryDebtorItem[] journalEntryCreateRequestJournalEntryDebtorItems={journalEntryCreateRequestJournalEntryDebtorItem1,journalEntryCreateRequestJournalEntryDebtorItem2};
			journalEntryCreateRequestJournalEntry.setDebtorItem(journalEntryCreateRequestJournalEntryDebtorItems);
			
			
			journalEntryCreateRequestMessage.setJournalEntry(journalEntryCreateRequestJournalEntry);
			
			//将JournalEntryCreateRequest主体添加到数组
			JournalEntryCreateRequestMessage[] journalEntryCreateRequestMessages={journalEntryCreateRequestMessage};
			//添加JournalEntryCreateRequest主体
			journalEntryCreateRequestBulkMessage.setJournalEntryCreateRequest(journalEntryCreateRequestMessages);
			
			
			
			journalEntryBulkCreateRequest.setJournalEntryBulkCreateRequest(journalEntryCreateRequestBulkMessage);
			
			String documentNo="";
			Set<String> set=new HashSet<String>();
			LogItem[] logItem=null;
			//调用并输出        
			JournalEntryCreateConfirmationMessage[] journalEntryCreateConfirmationMessages=stub.journalEntryCreateRequestConfirmation_In(journalEntryBulkCreateRequest).getJournalEntryBulkCreateConfirmation().getJournalEntryCreateConfirmation();
			for (int i = 0; i < journalEntryCreateConfirmationMessages.length; i++) {
				documentNo=journalEntryCreateConfirmationMessages[i].getJournalEntryCreateConfirmation().getAccountingDocument().toString();
				logItem=journalEntryCreateConfirmationMessages[i].getLog().getItem();
			}
			if("0000000000".equals(documentNo)){
				for (int j = 0; j < logItem.length; j++) {
					if(!logItem[j].getNote().getLogItemNote().contains("Error")){
						set.add(logItem[j].getNote().getLogItemNote());
					}
				}
				sapZkbzjTb.setPzbm("");
				sapZkbzjTb.setStatus("n");
				sapZkbzjTb.setMsg(set.toString());
			}else{
				sapZkbzjTb.setPzbm(documentNo);
				sapZkbzjTb.setStatus("y");
				sapZkbzjTb.setMsg("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sapZkbzjTb;
	}


	@Override
	public EUDataGridResult getSAPPost(int page, int rows,String dskqzStatus) {
		SapZkbzjTbExample example = new SapZkbzjTbExample();
		if(dskqzStatus!=null && !"".equals(dskqzStatus)){
			Criteria criteria=example.createCriteria();
			criteria.andStatusEqualTo(dskqzStatus);
		}
		// 分页处理
		PageHelper.startPage(page, rows);
		List<SapZkbzjTb> item = sapZkbzjTbMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(item);
		// 取记录总条数
		PageInfo<SapZkbzjTb> pageInfo = new PageInfo<>(item);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

//	@Override
//	public int delete(List<Integer> list) {
//		SapDskqzTbExample example = new SapDskqzTbExample();
//		Criteria criteria=example.createCriteria();
//		criteria.andIdIn(list);
//		int num=sapDskqzTbMapper.deleteByExample(example);
//		return num;
//	}
//	
	

}
