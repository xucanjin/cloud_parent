package com.xu.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xu.dubbo.DubboService;
import com.xu.service.ConsumerService;
import org.springframework.stereotype.Service;

/**
 * @Author: canjin
 * @Date: 2021/3/29
 * 说明:
 */
@Service
public class ComsumerServiceImpl implements ConsumerService {

    @Reference
    DubboService dubboService;
    @Override
    public void addTest() {

        dubboService.add();
    }
}
