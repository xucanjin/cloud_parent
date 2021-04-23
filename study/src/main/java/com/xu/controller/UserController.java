package com.xu.controller;

import com.xu.bean.User;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User get(){
        return userService.getUser();
    }

    @GetMapping("/list")
    public List<User> list(){
        return userService.findAll();
    }
}
