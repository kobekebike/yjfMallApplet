package com.bl.service;

import com.bl.base.Response;
import com.bl.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public Response getAllUserList(){
        return Response.createSuccessResult("查询所有用户成功", userInfoMapper.selectByExample(null));
    }

    public Response getOneUserByUserId(int userId){
        return Response.createSuccessResult("查询用户成功", userInfoMapper.selectByPrimaryKey(userId));
    }
}
