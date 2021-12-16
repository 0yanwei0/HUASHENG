package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.HsGdtcTb;
import com.jxszj.pojo.sap.HsGdtcTbExample;

import java.util.List;

public interface HsGdtcTbMapper {
    int countByExample(HsGdtcTbExample example);

    int deleteByExample(HsGdtcTbExample example);

    int insert(HsGdtcTb record);

    int insertByBatch(List<HsGdtcTb> hsGdtcTb);
    
    List<HsGdtcTb> selectByExample(HsGdtcTbExample example);

}