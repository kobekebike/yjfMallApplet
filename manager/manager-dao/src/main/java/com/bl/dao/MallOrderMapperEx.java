package com.bl.dao;

import com.bl.pojo.MallOrderVo;
import com.bl.pojo.MallOrderWXVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallOrderMapperEx {

    //后台获取订单列表
    List<MallOrderVo> getMallOrderInfoList(
            @Param(value = "limitStart") Integer limitStart,
            @Param(value = "limitEnd") Integer limitEnd);

    /**
     * 微信小程序的获取订单列表
     *      根据用户标识与订单状态
     */
    List<MallOrderWXVo> getWXOrderListByUserIdAndOrderStatus(
            @Param(value = "userId") Integer userId,
            @Param(value = "orderStatusList") String[] orderStatusArr
    );
}
