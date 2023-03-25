package com.xu.design.chain;

import com.xu.design.chain.handler.MyHandler;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description
 */
public class AuthHandler extends MyHandler {

    @Override
    public void doHandler(Member member) {
        System.out.println("AuthHandler"+"success");
    }
}
