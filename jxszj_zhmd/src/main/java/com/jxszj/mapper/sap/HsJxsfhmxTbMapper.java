package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.HsJxsfhmxTb;
import com.jxszj.pojo.sap.HsJxsfhmxTbExample;

import java.util.List;

public interface HsJxsfhmxTbMapper {
	int insertOrUpdateByBatch(List<HsJxsfhmxTb> hsJxsfhmxTb);

    int insert(HsJxsfhmxTb record);

    List<HsJxsfhmxTb> selectByExample(HsJxsfhmxTbExample example);

}