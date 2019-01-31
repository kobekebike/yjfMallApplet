package com.bl.dao;

import com.bl.model.Address;
import com.bl.model.AddressCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    int countByExample(AddressCriteria example);

    int deleteByExample(AddressCriteria example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressCriteria example);

    Address selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressCriteria example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressCriteria example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}