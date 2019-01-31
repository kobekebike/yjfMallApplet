package com.bl.test;

import com.bl.utils.PropertiesUtil;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesTest extends BasicTest {

    @Test
	@Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
    public void test1(){
        Properties properties = PropertiesUtil.readProperties("config.properties");
        System.err.println(properties);
    }

}
