package com.xu.elasticsearch.service;

import com.xu.elasticsearch.bean.UserEs;

/**
 * @Author: canjin
 * @Date: 2021/7/10
 * 说明:
 */
public interface UserEsService {

    //增加索引
    void add(UserEs userEs);
    //删除索引
    void del(String id);
}
