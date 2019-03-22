package com.example.mybatis.service;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserMapper userMapper;

    public User getPerson(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int savePerson(Integer id,Integer age,String name){
        User p = new User();
        p.set(id);
        p.setAge(age);
        p.setName(name);
        return personM.insert(p);
    }

    public int updatePerson(Integer id,Integer age,String name){
        Person p = personM.selectByPrimaryKey(id);
        p.setAge(age);
        p.setName(name);
        return personM.updateByPrimaryKey(p);
    }

    public int deletePerson(Integer id){
        return personM.deleteByPrimaryKey(id);
    }
}
