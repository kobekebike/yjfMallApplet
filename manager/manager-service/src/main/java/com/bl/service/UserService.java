package com.bl.service;

import com.bl.base.Response;
import com.bl.dao.UserMapper;
import com.bl.dao.UserMapperEx;
import com.bl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperEx userMapperEx;

    public Response getAllUserList(){
        return Response.createSuccessResult("查询所有用户成功", userMapper.selectByExample(null));
    }

    public Response getOneUserByUserId(int userId){
        return Response.createSuccessResult("查询用户成功", userMapperEx.getOneUserByUserId(userId));
    }
}
