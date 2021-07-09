package com.xu.controller;

import com.xu.bean.User;
import com.xu.service.UserService;
import com.xu.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 新增方法
     */
    @GetMapping("/add")
    public void add(){
        User user=new User();
        user.setName("测试");
        user.setAge(20);
        userService.save(user);
    }

    //修改方法
    @PutMapping ("/update")
    public void update(){
        User user=new User();

        userService.updateById(user);
        RespResult.ok();
    }

    //删除方法
    @DeleteMapping("/delete")
    public void Delete(@RequestParam(value = "id")Integer id){
        userService.removeById(id);

        RespResult.ok();
    }

}
