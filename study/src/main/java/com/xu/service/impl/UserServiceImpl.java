package com.xu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.bean.User;
import com.xu.mapper.UserMapper;
import com.xu.qo.UserQo;
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
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{

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

    /**
     * 条件查询
     * @param qo
     * @return
     */
    @Override
    public List<User> queryList(UserQo qo) {
        //条件包装对象
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //根据name查询
        queryWrapper.like("name",qo.getName());

        queryWrapper.eq("age",qo.getAge());

        return userMapper.selectList(queryWrapper);
    }

    /**
     * 条件分页查询
     * @param userQo
     * @param current
     * @param size
     * @return
     */
    @Override
    public Page<User> queryPageList(UserQo userQo,long current, long size){
        //条件包装对象
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //根据name查询
        queryWrapper.like("name",userQo.getName());

        return userMapper.selectPage(new Page<User>(current,size),queryWrapper);
    }
}
