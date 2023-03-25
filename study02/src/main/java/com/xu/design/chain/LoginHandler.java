package com.xu.design.chain;

import com.xu.design.chain.handler.MyHandler;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description
 */
public class LoginHandler extends MyHandler {

    @Override
    public void doHandler(Member member) {
        System.out.println("LoginHandler" + member.getLoginName() + "登录成功");
        chain.doHandler(member);
    }
}
