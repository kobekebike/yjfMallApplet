package com.bl.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperEx {

    //根据用户标识获取用户
    List<Integer> getOneUserByUserId(@Param(value = "userId") Integer userId);

}
