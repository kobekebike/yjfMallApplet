package com.bl.dao;

import com.bl.model.Product;
import com.bl.model.ProductCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductCriteria example);

    int deleteByExample(ProductCriteria example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithBLOBs(ProductCriteria example);

    List<Product> selectByExample(ProductCriteria example);

    Product selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
}