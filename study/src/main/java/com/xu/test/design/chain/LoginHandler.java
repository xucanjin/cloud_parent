package com.xu.test.design.chain;

/**
 * @Author: canjin
 * @Date: 2021/4/11
 * 说明:
 */
public class LoginHandler extends Handler{
    @Override
    public void doHandler(Member member) {
        System.out.println("设置角色成功");
        member.setRoleName("admin");
        //chain.doHandler(member);
    }
}
