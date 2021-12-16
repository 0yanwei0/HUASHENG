package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.SapScjhwlTb;
import com.jxszj.pojo.sap.SapScjhwlTbExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SapScjhwlTbMapper {

	int deleteByPrimaryKey(String id);
	 
    int insertOrUpdateByBatch(List<SapScjhwlTb> sapScjhwlTb);
    
    List<SapScjhwlTb> selectByExample(SapScjhwlTbExample example);
    
    int update(@Param("wlzbm")String wlzbm,@Param("gzrq")String gzrq,@Param("dylj")int dylj,@Param("dyrj")int dyrj);
    
}