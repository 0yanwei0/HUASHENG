package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.SapScrkwlTb;
import com.jxszj.pojo.sap.SapScrkwlTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SapScrkwlTbMapper {

    int deleteByPrimaryKey(String id);

    int insertOrUpdateByBatch(List<SapScrkwlTb> sapScjhwlTb);

    List<SapScrkwlTb> selectByExample(SapScrkwlTbExample example);

    int update(@Param("wlzbm")String wlzbm,@Param("gzrq")String gzrq,@Param("dylj")int dylj,@Param("dyrj")int dyrj);

}