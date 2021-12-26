package com.xu.es.service.impl;

import com.xu.es.bean.UserEs;
import com.xu.es.mapper.UserSearchMapper;
import com.xu.es.service.UserEsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xucanjin
 * @date 2021/12/26
 * @description
 */
@Service
public class UserEsServiceImpl implements UserEsService {

    private Logger logger = LoggerFactory.getLogger(UserEsServiceImpl.class);

    @Autowired
    private UserSearchMapper userSearchMapper;

    /**
     * 新增方法
     * @param userEs
     */
    @Override
    public void add(UserEs userEs) {
        userSearchMapper.save(userEs);
        logger.info("success");
    }

    @Override
    public List<UserEs> find(){
        Iterable<UserEs> searchMapperAll = userSearchMapper.findAll();
        List<UserEs> list=new ArrayList<>();
        searchMapperAll.forEach(userEs -> list.add(userEs));
        return list;
    }

    @Override
    public UserEs findById(String id){
        Optional<UserEs> user = userSearchMapper.findById(id);
        return user.get();
    }

    @Override
    public void delAll() {
        userSearchMapper.deleteAll();
        logger.info("delAll");
    }

    @Override
    public void del(String id) {
        userSearchMapper.deleteById(id);
        logger.info("delete ");
    }
}
