package com.bl.test;

import com.bl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试的父类,所有要单元测试的类,先继承该类
 * 注:类名不要直接写Test,写**Test最好。
 * @author guosf
 *
 */
//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class) 
//用来指明Spring的配置文件位置
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
//标明此方法需使用事务 
@Transactional 
public class BasicTest {
	
/**
 * 以下注释的代码是范例，可以在该类下进行单元测试，也可以另外写一个类，继承该类
 */
//	@Autowired
//	private UserService userService;
//
//	@Test
//	@Rollback(false) //标明使用完此方法后事务不回滚,true时为回滚
//	public void test(){
//		System.err.println(userService.getAllUserList());
//		System.err.println("22222222222222222222222222");
//	}
}
