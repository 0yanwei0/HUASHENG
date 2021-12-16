package com.jxszj.mapper.sap;

import java.util.List;

import com.jxszj.pojo.sap.HsXsmlfxTb;
import com.jxszj.pojo.sap.HsXsmlfxTbExample;


public interface HsXsmlfxTbMapper {

	int insertOrUpdateByBatch(List<HsXsmlfxTb> hsXsmlfxTb);
	
    int insert(HsXsmlfxTb record);

    List<HsXsmlfxTb> selectByExample(HsXsmlfxTbExample example);


}