package com.xu.service.impl;

import com.xu.bean.User;
import com.xu.mapper.UserMapper;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(){
        Object o= userMapper.selectById(1);

        return (User) o;
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAllUser();
    }
}
