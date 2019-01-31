package com.bl.dao;

import com.bl.model.OrderDetail;
import com.bl.model.OrderDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    int countByExample(OrderDetailCriteria example);

    int deleteByExample(OrderDetailCriteria example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailCriteria example);

    OrderDetail selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailCriteria example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}