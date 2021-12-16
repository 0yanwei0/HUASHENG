package com.jxszj.service.sap;


import com.jxszj.pojo.EUDataGridResult;

public interface IXsdddjysService {

	public EUDataGridResult getSapXsdddjysTbList(int page, int rows);
	
	public int updateSapXsdddjysTb(String ny);
	
}
