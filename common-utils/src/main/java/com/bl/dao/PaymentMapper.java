package com.bl.dao;

import com.bl.model.Payment;
import com.bl.model.PaymentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
    int countByExample(PaymentCriteria example);

    int deleteByExample(PaymentCriteria example);

    int deleteByPrimaryKey(Integer paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentCriteria example);

    Payment selectByPrimaryKey(Integer paymentId);

    int updateByExampleSelective(@Param("record") Payment record, @Param("example") PaymentCriteria example);

    int updateByExample(@Param("record") Payment record, @Param("example") PaymentCriteria example);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}