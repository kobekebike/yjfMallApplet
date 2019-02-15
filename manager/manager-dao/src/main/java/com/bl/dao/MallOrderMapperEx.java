package com.bl.dao;

import com.bl.pojo.MallOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallOrderMapperEx {

    List<MallOrderVo> getMallOrderInfoList(
            @Param(value = "limitStart") Integer limitStart,
            @Param(value = "limitEnd") Integer limitEnd);

}
