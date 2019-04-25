package com.bl.service;

import com.bl.base.EasyUIResult;
import com.bl.base.Response;
import com.bl.dao.UserInfoMapper;
import com.bl.model.UserInfo;
import com.bl.model.UserInfoCriteria;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Response saveOrUpdateUserInfo(String openId){
        if(StringUtils.isNotBlank(openId) && !"null".equals(openId)){
            int userInfoId = 0;
            UserInfoCriteria userInfoCriteria = new UserInfoCriteria();
            userInfoCriteria.createCriteria().andOpenIdEqualTo(openId);
            List<UserInfo> list = userInfoMapper.selectByExample(userInfoCriteria);
            if(list != null && !list.isEmpty()){//存在则修改
                UserInfo userInfo = list.get(0);
                userInfo.setVisitTime(new Date());
                userInfoMapper.updateByPrimaryKeySelective(userInfo);
                userInfoId = userInfo.getId();
            }else{//不存在则保存
                UserInfo user = new UserInfo();
                user.setOpenId(openId);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                user.setVisitTime(new Date());
                userInfoMapper.insertSelective(user);
                userInfoId = user.getId();
            }
            return Response.createSuccessResult("访问成功", userInfoId);
        }else{
            return Response.createFailResult("openId为空", null);
        }
    }

    /**
     * 根据标识修改用户信息
     * @param userInfo
     * @return
     */
    public Response updateUserInfo(UserInfo userInfo) {
        if(userInfoMapper.updateByPrimaryKeySelective(userInfo) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }
}
