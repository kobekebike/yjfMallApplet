package com.bl.controller;

import com.bl.base.Response;
import com.bl.service.UserService;
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
@RequestMapping("userController")
public class UserController {
    public static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("getAllUserList.do")
    public @ResponseBody Response getAllUserList(HttpServletRequest req, HttpServletResponse res){
        Response response = new Response();
        try {
            response = userService.getAllUserList();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            response = Response.createFailResult("查询所有用户失败", null);
        }
        return response;
    }

    @RequestMapping("getOneUserByUserId.do")
    public @ResponseBody Response getOneUserByUserId (HttpServletRequest req, HttpServletResponse res,
                                                      @RequestParam(defaultValue = "0") int userId){
        Response response = new Response();
        try {
            response = userService.getOneUserByUserId(userId);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            response = Response.createFailResult("查询用户失败", null);
        }
        return response;
    }
}
