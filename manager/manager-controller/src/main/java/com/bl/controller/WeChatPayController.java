package com.bl.controller;

import com.bl.base.Response;
import com.bl.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("weChatPayController")
@Scope("prototype")
public class WeChatPayController{

    @Autowired
    private WeChatPayService weChatPayService;

    /**
     * 微信统一下单
     * @param request
     * @param response
     * @param orderId
     * @return
     */
	@RequestMapping("weChatPay.do")
	@ResponseBody
	public Response wxPay(HttpServletRequest request, HttpServletResponse response,
						  @RequestParam String[] orderId) {
		String userId = request.getParameter("userId");
		String cip = request.getParameter("cip");
		String total = request.getParameter("total");//总金额:分，不包括折扣的
		String discountTotal = request.getParameter("discountTotal");//总金额:包括折扣的
		String addressId = request.getParameter("addressId");
        return weChatPayService.saveWeChatPayInfo(cip, total, discountTotal, Integer.valueOf(userId), orderId, addressId);
	}
}







