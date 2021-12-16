package com.jxszj.service.sap;


import com.jxszj.pojo.EUDataGridResult;

public interface IYyddtcService {

	public EUDataGridResult getYyddtcList(int page, int rows, String yyddtcrq);
	
	public void updateYyddtc(String ny);
	
}
