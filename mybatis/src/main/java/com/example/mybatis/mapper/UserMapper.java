package com.example.mybatis.mapper;

import com.example.mybatis.model.User;
import com.example.mybatis.model.UserWithBLOBs;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}

