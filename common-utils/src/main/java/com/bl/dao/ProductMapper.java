package com.bl.dao;

import com.bl.model.Product;
import com.bl.model.ProductCriteria;
import com.bl.model.ProductKey;
import com.bl.model.ProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductCriteria example);

    int deleteByExample(ProductCriteria example);

    int deleteByPrimaryKey(ProductKey key);

    int insert(ProductWithBLOBs record);

    int insertSelective(ProductWithBLOBs record);

    List<ProductWithBLOBs> selectByExampleWithBLOBs(ProductCriteria example);

    List<Product> selectByExample(ProductCriteria example);

    ProductWithBLOBs selectByPrimaryKey(ProductKey key);

    int updateByExampleSelective(@Param("record") ProductWithBLOBs record, @Param("example") ProductCriteria example);

    int updateByExampleWithBLOBs(@Param("record") ProductWithBLOBs record, @Param("example") ProductCriteria example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductCriteria example);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);
}