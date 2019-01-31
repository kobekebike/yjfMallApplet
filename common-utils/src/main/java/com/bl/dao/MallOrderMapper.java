package com.bl.dao;

import com.bl.model.MallOrder;
import com.bl.model.MallOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallOrderMapper {
    int countByExample(MallOrderCriteria example);

    int deleteByExample(MallOrderCriteria example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    List<MallOrder> selectByExample(MallOrderCriteria example);

    MallOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") MallOrder record, @Param("example") MallOrderCriteria example);

    int updateByExample(@Param("record") MallOrder record, @Param("example") MallOrderCriteria example);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);
}