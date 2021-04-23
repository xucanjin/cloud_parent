package com.xu.test.design.chain;

import org.springframework.util.StringUtils;

/**
 * @Author: canjin
 * @Date: 2021/4/11
 * 说明:
 */
public class ValidateHandler extends Handler{
    @Override
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getName())||StringUtils.isEmpty(member.getPassword())){
            System.out.println("用户名或密码为空");
            return;
        }
        System.out.println("用户名或密码校验通过");
        super.chain.doHandler(member);
    }
}
