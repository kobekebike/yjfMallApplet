package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.constants.Constant;
import com.bl.dao.MallOrderMapper;
import com.bl.dao.MallOrderMapperEx;
import com.bl.model.MallOrder;
import com.bl.model.MallOrderCriteria;
import com.bl.pojo.MallOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class MallOrderService {

    @Autowired
    private MallOrderMapper   mallOrderMapper;
    @Autowired
    private MallOrderMapperEx mallOrderMapperEx;

    /**
     * 根据用户标识与订单状态获取订单集合
     * @param userId    用户标识
     * @param orderStatusArr   订单状态
     * @return
     */
    public Response getOrderByUserIdAndOrderStatus(Integer userId, String[] orderStatusArr) {
        return Response.createSuccessResult("订单信息", mallOrderMapperEx.getWXOrderListByUserIdAndOrderStatus(userId, orderStatusArr));
    }

    /**
     * 分页获取订单的集合
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getMallOrderList(Integer page, Integer rows) {
        List<MallOrderVo> list = mallOrderMapperEx.getMallOrderInfoList((page - 1) * rows, rows);
        return new EasyUIResult(list.size(), list);
    }

    /**
     * 保存订单
     * @param mallOrder
     * @return
     */
    public Response saveMallOrder(MallOrder mallOrder) {
        //列表中点加入购物车多次时,自动加1
        MallOrderCriteria mallOrderCriteria = new MallOrderCriteria();
        mallOrderCriteria.createCriteria()
                .andUserIdEqualTo(mallOrder.getUserId())
                .andProductIdEqualTo(mallOrder.getProductId())
                .andOrderStatusEqualTo(mallOrder.getOrderStatus());
        List<MallOrder> list = mallOrderMapper.selectByExample(mallOrderCriteria);
        if(list != null && !list.isEmpty()){
            mallOrder.setProductNum(list.get(0).getProductNum()+1);
            mallOrder.setOrderAmount(mallOrder.getOrderAmount().multiply(new BigDecimal(mallOrder.getProductNum())).setScale(2, BigDecimal.ROUND_HALF_UP));
            mallOrder.setOrderId(list.get(0).getOrderId());
            mallOrder.setUpdateTime(new Date());
            if(mallOrderMapper.updateByPrimaryKeySelective(mallOrder) == 1){
                return Response.createSuccessResult("修改成功", null);
            }else{
                return Response.createFailResult("修改失败", null);
            }
        }else{
            mallOrder.setOrderNum(System.currentTimeMillis() + "" + new Random().nextInt(10000));
            mallOrder.setUpdateTime(new Date());
            mallOrder.setCreateTime(new Date());
            if(mallOrderMapper.insertSelective(mallOrder) == 1){
                return Response.createSuccessResult("保存成功", null);
            }else{
                return Response.createFailResult("保存失败", null);
            }
        }
    }

    /**
     * 修改订单表的商品数量
     * @param mallOrder
     * @return
     */
    public Response updateOrderNum(MallOrder mallOrder) {
        //第一次传过来的订单金额为单个商品的金额，总金额等于单个商品的金额*数量
        mallOrder.setOrderAmount(mallOrder.getOrderAmount().multiply(new BigDecimal(mallOrder.getProductNum())).setScale(2, BigDecimal.ROUND_HALF_UP));
        if(mallOrderMapper.updateByPrimaryKeySelective(mallOrder) == 1){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }

    /**
     * 根据订单标识删除订单
     * @param orderId
     * @return
     */
    public Response deleteMallOrderByOrderId(Integer orderId) {
        if(mallOrderMapper.deleteByPrimaryKey(orderId) == 1){
            return Response.createSuccessResult("删除成功", null);
        }else{
            return Response.createFailResult("删除失败", null);
        }
    }

    /**
     * 补充订单的快递信息，已发货
     * @param mallOrder
     * @param orderIds  //订单标识字符串
     * @return
     */
    public Response updateOrderStatus(MallOrder mallOrder, String orderIds) {
        int count = 0;
        List<Integer> idList = new ArrayList<>();
        String[] idArr = orderIds.split(",");
        for(String idStr : idArr){
            idList.add(Integer.valueOf(idStr));
            mallOrder.setUpdateTime(new Date());
            mallOrder.setOrderId(Integer.valueOf(idStr));
            count += mallOrderMapper.updateByPrimaryKeySelective(mallOrder);
        }
        if(count > 0){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }

    /**
     * 根据用户标识获取购物车里的商品数量
     * @param userId
     * @return
     */
    public Response getCartMallOrderCountByUserId(Integer userId) {
        int count = 0;
        MallOrderCriteria mallOrderCriteria = new MallOrderCriteria();
        mallOrderCriteria.createCriteria()
                .andUserIdEqualTo(userId)
                .andOrderStatusEqualTo(Constant.MALL_ORDER_STATUS_NON_PAYMENT);//1未付款，即购物车的状态
        List<MallOrder> list = mallOrderMapper.selectByExample(mallOrderCriteria);
        if(list != null && !list.isEmpty()){
            for(MallOrder mallOrder : list){
                count += mallOrder.getProductNum();
            }
        }
        return Response.createSuccessResult("购物车的商品数量", count);
    }

    /**
     * 修改订单的状态
     *      支付完成后,修改成已收款
     * @param orderId
     * @return
     */
    public Response updateOrderStatusInMoneyReceipt(String[] orderId) {
        int count = 0;
        MallOrder mallOrder = null;
        for(String idStr : orderId){
            mallOrder = new MallOrder();
            mallOrder.setOrderId(Integer.valueOf(idStr));
            mallOrder.setOrderStatus(Constant.MALL_ORDER_STATUS_MONEY_RECEIPT);
            mallOrder.setUpdateTime(new Date());
            count += mallOrderMapper.updateByPrimaryKeySelective(mallOrder);
        }
        try {
            //批量修改商品的已售数量
            mallOrderMapperEx.updateProductSoldOutNum(orderId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(count > 0){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }
}
