package com.xu.controller;

import com.xu.bean.User;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: canjin
 * @Date: 2021/3/26
 * 说明:
 */
//如果使用@RestController，加载不出ftl文件
@Controller
//@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model){
        String localAddr = request.getLocalAddr();
        request.getServletPath();
        StringBuilder builder=new StringBuilder();
        builder.append("11");
        System.out.println("denglu");
        model.addAttribute("date","123");
        return "login/index";
    }

}
