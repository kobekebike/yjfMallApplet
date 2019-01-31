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

	@RequestMapping("product/{pageName}.do")
	public String productPage(@PathVariable String pageName){
		return "product/"+pageName;	//prefix+logicName+suffix
	}
}
