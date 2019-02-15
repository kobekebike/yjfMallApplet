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

import java.util.List;

@Service
public class MallOrderService {

    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    private MallOrderMapperEx mallOrderMapperEx;

    /**
     * 根据用户标识与订单状态获取订单集合
     * @param userId    用户标识
     * @param orderStatus   订单状态
     * @return
     */
    public Response getOrderByUserIdAndOrderStatus(Integer userId, Integer orderStatus) {
        MallOrderCriteria mallOrderCriteria = new MallOrderCriteria();
        MallOrderCriteria.Criteria criteria = mallOrderCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if(orderStatus != 0){
            criteria.andOrderStatusEqualTo(orderStatus);
        }
        return Response.createSuccessResult("订单信息", mallOrderMapper.selectByExample(mallOrderCriteria));
    }

    public EasyUIResult getMallOrderList(Integer page, Integer rows) {
        List<MallOrderVo> list = mallOrderMapperEx.getMallOrderInfoList((page - 1) * rows, rows);
        return new EasyUIResult(list.size(), list);
    }
}
