package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.DznljfTb;
import com.jxszj.pojo.sap.DznljfTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DznljfTbMapper {
    int countByExample(DznljfTbExample example);

    int deleteByExample(DznljfTbExample example);

    int insert(DznljfTb record);

    int insertSelective(DznljfTb record);

    List<DznljfTb> selectByExample(DznljfTbExample example);

    int updateByExampleSelective(@Param("record") DznljfTb record, @Param("example") DznljfTbExample example);

    int updateByExample(@Param("record") DznljfTb record, @Param("example") DznljfTbExample example);
}