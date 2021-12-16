package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.YyjfTb;
import com.jxszj.pojo.sap.YyjfTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YyjfTbMapper {
    int countByExample(YyjfTbExample example);

    int deleteByExample(YyjfTbExample example);

    int insert(YyjfTb record);

    int insertSelective(YyjfTb record);

    List<YyjfTb> selectByExample(YyjfTbExample example);

    int updateByExampleSelective(@Param("record") YyjfTb record, @Param("example") YyjfTbExample example);

    int updateByExample(@Param("record") YyjfTb record, @Param("example") YyjfTbExample example);
}