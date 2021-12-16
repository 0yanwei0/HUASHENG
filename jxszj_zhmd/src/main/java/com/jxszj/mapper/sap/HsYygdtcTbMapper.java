package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.HsYygdtcTb;
import com.jxszj.pojo.sap.HsYygdtcTbExample;
import java.util.List;

public interface HsYygdtcTbMapper {
	
    int countByExample(HsYygdtcTbExample example);

    int deleteByExample(HsYygdtcTbExample example);

    int insert(HsYygdtcTb record);
    
    int insertByBatch(List<HsYygdtcTb> hsYygdtcTb);

    List<HsYygdtcTb> selectByExample(HsYygdtcTbExample example);
}