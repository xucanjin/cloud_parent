package com.xu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.bean.User;

import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */
public interface UserService{

    User getUser();

    List<User> findAll();
}
