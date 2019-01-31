package com.bl.base;

import javax.servlet.http.HttpServletRequest;

public class BasicUtils {

    public static LoginBean getLoginInfo(HttpServletRequest request){
        return (LoginBean) request.getSession().getAttribute(LoginBean.UserLoginKey);
    }

}
