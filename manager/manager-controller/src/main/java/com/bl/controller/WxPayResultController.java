package com.bl.controller;

import com.bl.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("wxPayResult")
public class WxPayResultController {

    @Autowired
    private WeChatPayService weChatPayService;

    /**
     * 支付完成后，接收微信推送的支付信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("payResult.do")
    @ResponseBody
    public String getWeChatPayReturn(HttpServletRequest request, HttpServletResponse response) {
        return weChatPayService.saveWxPayResultInfo(request);
    }
}







