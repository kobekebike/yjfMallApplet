package com.bl.controller;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.service.MallOrderService;
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
@RequestMapping("mallOrderController")
public class MallOrderController {
    public static Logger log = LogManager.getLogger(MallOrderController.class);

    @Autowired
    private MallOrderService mallOrderService;

    /**
     * 根据用户标识与订单状态获取订单集合
     * @param req
     * @param res
     * @param userId    用户标识
     * @param orderStatus   订单状态
     * @return
     */
    @RequestMapping("getOrderByUserIdAndOrderStatus.do")
    @ResponseBody
    public Response getOrderByUserIdAndOrderStatus(HttpServletRequest req, HttpServletResponse res,
                                                   @RequestParam(value = "userId", defaultValue = "0") Integer userId,
                                                   @RequestParam(value = "orderStatus", defaultValue = "0", required = false) Integer orderStatus){
        return mallOrderService.getOrderByUserIdAndOrderStatus(userId, orderStatus);
    }

    /**
     * 分页获取订单的集合
     * @param req
     * @param res
     * @param page
     * @Param rows
     * @return
     */
    @RequestMapping("getMallOrderList.do")
    @ResponseBody
    public EasyUIResult getMallOrderList(HttpServletRequest req, HttpServletResponse res,
                                       @RequestParam Integer page, @RequestParam Integer rows){
        return mallOrderService.getMallOrderList(page, rows);
    }
}
