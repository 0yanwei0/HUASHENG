package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.SapHbcpfxTb;
import com.jxszj.pojo.sap.SapHbcpfxTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SapHbcpfxTbMapper {

    int deleteByExample(SapHbcpfxTbExample example);

    int insert(SapHbcpfxTb record);

    List<SapHbcpfxTb> selectByExample(SapHbcpfxTbExample example);

    int updateByBmwl(@Param("ddsl")int ddsl,@Param("ny")String ny,@Param("bmwl")String bmwl);
}