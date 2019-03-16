package com.bl.controller;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.model.MallOrder;
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
                                                   @RequestParam(value = "orderStatus", required = false) String[] orderStatus){
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

    /**
     * 保存订单
     * @param req
     * @param res
     * @param mallOrder 对象
     * @return
     */
    @RequestMapping("saveMallOrder.do")
    @ResponseBody
    public Response saveMallOrder(HttpServletRequest req, HttpServletResponse res,
                                    MallOrder mallOrder){
        return mallOrderService.saveMallOrder(mallOrder);
    }

    /**
     * 修改订单表的商品数量
     * @param req
     * @param res
     * @param mallOrder
     * @return
     */
    @RequestMapping("updateOrderNum.do")
    @ResponseBody
    public Response updateOrderNum(HttpServletRequest req, HttpServletResponse res,
                                   MallOrder mallOrder){
        return mallOrderService.updateOrderNum(mallOrder);
    }

    /**
     * 根据订单标识删除订单
     * @param req
     * @param res
     * @param orderId
     * @return
     */
    @RequestMapping("deleteMallOrderByOrderId.do")
    @ResponseBody
    public Response deleteMallOrderByOrderId(HttpServletRequest req, HttpServletResponse res,
                                    @RequestParam Integer orderId){
        return mallOrderService.deleteMallOrderByOrderId(orderId);
    }

    /**
     * 补充订单的快递信息，已发货
     * @param req
     * @param res
     * @param mallOrder
     * @return
     */
    @RequestMapping("updateOrderStatus.do")
    @ResponseBody
    public Response updateOrderStatus(HttpServletRequest req, HttpServletResponse res,
                                   MallOrder mallOrder){
        return mallOrderService.updateOrderStatus(mallOrder);
    }

    /**
     * 根据用户标识获取购物车里的商品数量
     * @param req
     * @param res
     * @param userId
     * @return
     */
    @RequestMapping("getCartMallOrderCountByUserId.do")
    @ResponseBody
    public Response getCartMallOrderCountByUserId(HttpServletRequest req, HttpServletResponse res,
                                              @RequestParam(value = "userId", defaultValue = "0") Integer userId){
        return mallOrderService.getCartMallOrderCountByUserId(userId);
    }
}
