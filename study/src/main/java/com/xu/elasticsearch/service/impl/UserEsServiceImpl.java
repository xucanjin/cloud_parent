package com.xu.elasticsearch.service.impl;

import com.xu.elasticsearch.bean.UserEs;
import com.xu.elasticsearch.mapper.UserSearchMapper;
import com.xu.elasticsearch.service.UserEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: canjin
 * @Date: 2021/7/10
 * 说明:
 */
@Service
public class UserEsServiceImpl implements UserEsService{

    @Autowired
    private UserSearchMapper userSearchMapper;
    @Override
    public void add(UserEs userEs) {
        userSearchMapper.save(userEs);
    }

    @Override
    public void del(String id) {
        userSearchMapper.deleteById(id);
    }
}
