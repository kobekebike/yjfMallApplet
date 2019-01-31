package com.bl.controller;

import com.bl.base.Response;
import com.bl.base.LoginBean;
import com.bl.utils.MD5;
import com.bl.utils.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Controller
@RequestMapping("login.do")
public class LoginController {
    public static Logger log = LogManager.getLogger(LoginController.class);

    @RequestMapping(params = "method=doLogin")
    @ResponseBody
    public Response doLogin(HttpServletRequest req, HttpServletResponse res) {
        Properties properties = PropertiesUtil.readProperties("config.properties");
        String userAccount = req.getParameter("username");
        String userPassword = req.getParameter("password");
        LoginBean lb = new LoginBean();
        Response response = new Response();
        try {
            if (StringUtils.isNotBlank(userAccount) && !properties.getProperty("userAccount").equals(userAccount)) {
                response = Response.createFailResult("账号:" + userAccount + "不存在", null);
            }else if (StringUtils.isNotBlank(userPassword) && !(MD5.GetMD5Code(properties.getProperty("userPassword")).equalsIgnoreCase(MD5.GetMD5Code(userPassword)))) {
                response = Response.createFailResult("账号密码错误", null);
            } else {
                lb.setUserId(Integer.valueOf(properties.getProperty("userId")));
                lb.setUserAccount(properties.getProperty("userAccount"));
                lb.setUserName(properties.getProperty("userName"));
                req.getSession().setAttribute(LoginBean.UserLoginKey, lb);
                response = Response.createSuccessResult("登陆成功", null);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            MDC.put("logMessage", ex.getMessage());
            response = Response.createFailResult("登陆失败", null);
        }
        return response;
    }
}
