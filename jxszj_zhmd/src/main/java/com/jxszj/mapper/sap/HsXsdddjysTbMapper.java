package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.HsXsdddjysTb;
import com.jxszj.pojo.sap.HsXsdddjysTbExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HsXsdddjysTbMapper {

	int insertOrUpdateByBatch(List<HsXsdddjysTb> hsXsdddjysTb);
	
    int insert(HsXsdddjysTb record);

    List<HsXsdddjysTb> selectByExample(HsXsdddjysTbExample example);
    
    Double selectXdje(@Param("jxskhbm") String jxskhbm,@Param("cjny") String cjny);//运营提成所取的下单金额
    
    Double selectGdXdje(@Param("jxsbm") String jxsbm,@Param("cjny") String cjny);//跟单提成所取的下单金额
}