package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.dao.MallOrderMapper;
import com.bl.model.MallOrder;
import com.bl.model.MallOrderCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallOrderService {

    @Autowired
    private MallOrderMapper mallOrderMapper;

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
        MallOrderCriteria mallOrderCriteria = new MallOrderCriteria();
        mallOrderCriteria.setLimitStart((page - 1) * rows);
        mallOrderCriteria.setLimitEnd(rows);
        mallOrderCriteria.setOrderByClause("update_time desc");
        List<MallOrder> list = mallOrderMapper.selectByExample(mallOrderCriteria);
        return new EasyUIResult(list.size(), list);
    }
}
