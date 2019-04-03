package com.bl.controller;

import com.bl.base.EasyUIResult;
import com.bl.service.UserInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("userInfoController")
public class UserInfoController {
    public static Logger log = LogManager.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 分页获取商品的集合
     * @param req
     * @param res
     * @param page
     * @Param rows
     * @return
     */
    @RequestMapping("getUserList.do")
    @ResponseBody
    public EasyUIResult getUserList(HttpServletRequest req, HttpServletResponse res,
                                       @RequestParam Integer page, @RequestParam Integer rows){
        EasyUIResult easyUIResult = new EasyUIResult();
        try {
            easyUIResult = userInfoService.getUserList(page, rows);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return easyUIResult;
    }
    
}
