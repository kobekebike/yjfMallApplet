package com.bl.test;

import com.bl.service.ProductService;
import com.bl.utils.PropertiesUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Properties;

public class ProductTest extends BasicTest {
    
    @Autowired
    private ProductService productService;

    @Test
	@Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void test1(){
        System.err.println(productService.getProductDetail(15));
    }

}
