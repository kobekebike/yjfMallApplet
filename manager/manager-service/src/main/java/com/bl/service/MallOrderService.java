package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.dao.MallOrderMapper;
import com.bl.dao.MallOrderMapperEx;
import com.bl.model.MallOrder;
import com.bl.model.MallOrderCriteria;
import com.bl.pojo.MallOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
                .andProductIdEqualTo(mallOrder.getProductId());
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
     * @return
     */
    public Response updateOrderStatus(MallOrder mallOrder) {
        mallOrder.setUpdateTime(new Date());
        if(mallOrderMapper.updateByPrimaryKeySelective(mallOrder) == 1){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }
}
