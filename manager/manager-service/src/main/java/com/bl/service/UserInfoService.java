package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.dao.UserInfoMapper;
import com.bl.model.Product;
import com.bl.model.ProductCriteria;
import com.bl.model.UserInfo;
import com.bl.model.UserInfoCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 分页获取商品的集合
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getUserList(Integer page, Integer rows){
        UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
        userInfoCriteria.setLimitStart((page - 1) * rows);
        userInfoCriteria.setLimitEnd(rows);
        userInfoCriteria.setOrderByClause("create_time desc");
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoCriteria);
        return new EasyUIResult(list.size(), list);
    }
}
