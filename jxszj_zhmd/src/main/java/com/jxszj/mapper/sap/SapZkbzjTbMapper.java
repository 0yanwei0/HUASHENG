package com.jxszj.mapper.sap;

import com.jxszj.pojo.sap.SapZkbzjTb;
import com.jxszj.pojo.sap.SapZkbzjTbExample;
import java.util.List;

public interface SapZkbzjTbMapper {

    List<SapZkbzjTb> selectByExample(SapZkbzjTbExample example);

    int insertByBatch(List<SapZkbzjTb > sapZkbzjTbList);
}