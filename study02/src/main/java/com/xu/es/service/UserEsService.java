package com.xu.es.service;

import com.xu.es.bean.UserEs;

import java.util.List;

/**
 * @author canjin
 * @date 2021/12/26
 * @description
 */
public interface UserEsService {

    //增加索引
    void add(UserEs userEs);

    //删除索引
    void del(String id);

    List<UserEs> find();

    UserEs findById(String id);

    void delAll();
}
