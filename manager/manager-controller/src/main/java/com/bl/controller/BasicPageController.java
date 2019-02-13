package com.bl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicPageController {

	//通用转向方法:http://localhost:8080/page/pageName
	@RequestMapping("{pageName}.do")
	public String basicPage(@PathVariable String pageName){
		return pageName;	//prefix+logicName+suffix
	}

	/**
	 * 商品通用转向方法
	 * @param pageName
	 * @return
	 */
	@RequestMapping("product/{pageName}.do")
	public String productPage(@PathVariable String pageName){
		return "product/"+pageName;	//prefix+logicName+suffix
	}

	/**
	 * 用户信息通用转向方法
	 * @param pageName
	 * @return
	 */
	@RequestMapping("userInfo/{pageName}.do")
	public String userInfoPage(@PathVariable String pageName){
		return "userInfo/"+pageName;	//prefix+logicName+suffix
	}

	/**
	 * 订单信息通用转向方法
	 * @param pageName
	 * @return
	 */
	@RequestMapping("order/{pageName}.do")
	public String orderPage(@PathVariable String pageName){
		return "order/"+pageName;	//prefix+logicName+suffix
	}
}
