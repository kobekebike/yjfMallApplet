package com.bl.dao;

import com.bl.model.ProductType;
import com.bl.model.ProductTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTypeMapper {
    int countByExample(ProductTypeCriteria example);

    int deleteByExample(ProductTypeCriteria example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeCriteria example);

    ProductType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeCriteria example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeCriteria example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}