package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.SapJdrbTb;
import com.jxszj.pojo.sap.SapJdrbTbExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SapJdrbTbMapper {

    int deleteByExample(SapJdrbTbExample example);
    
    int deleteByPrimaryKey(String id);

    int insert(SapJdrbTb record);

    List<SapJdrbTb> selectByExample(SapJdrbTbExample example);

    SapJdrbTb selectByPrimaryKey(String id);

    int updateByPrimaryKey(SapJdrbTb record);
    
    int insertOrUpdateByBatch(List<SapJdrbTb> sapJdrbTb);
    
    int update(@Param("wlz")String wlz,@Param("rq")String rq,@Param("dylj")int dylj,@Param("dyrj")int dyrj);
    
}