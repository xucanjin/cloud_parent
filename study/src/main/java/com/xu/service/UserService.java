package com.xu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.bean.User;
import com.xu.qo.UserQo;

import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明: 需要继承IService
 */
public interface UserService extends IService<User>{

    User getUser();

    List<User> findAll();

    List<User> queryList(UserQo qo);

    Page<User> queryPageList(UserQo userQo, long current, long size);
}
