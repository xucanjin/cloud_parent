package com.liyufei.service.impl;

import com.liyufei.bean.InputParaDTO;
import com.liyufei.bean.UserDTO;
import com.liyufei.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;


@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> getUsers(InputParaDTO para) {
        System.out.println("====provider invoke====");
        List<UserDTO> users = new ArrayList<UserDTO>();
        users.add(new UserDTO(1, "李羽飞1"));

        if (para.getType() == 1) {
            users.add(new UserDTO(2, "李羽飞2"));
        }

        return users;
    }
}
