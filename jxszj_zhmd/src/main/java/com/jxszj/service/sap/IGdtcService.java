package com.jxszj.service.sap;


import com.jxszj.pojo.EUDataGridResult;

public interface IGdtcService {

	public EUDataGridResult getGdtcList(int page, int rows , String gdtcrq);
	
	public void updateGdtc(String ny);
	
}
