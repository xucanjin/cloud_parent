package com.xu.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Author: canjin
 * @Date: 2021/3/29
 * 说明:
 */
@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public void add() {
        System.out.println("add.....");
    }
}
