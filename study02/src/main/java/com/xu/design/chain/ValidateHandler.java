package com.xu.design.chain;

import cn.hutool.core.util.StrUtil;
import com.xu.design.chain.handler.MyHandler;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description
 */
public class ValidateHandler extends MyHandler {

    @Override
    public void doHandler(Member member) {
        if (StrUtil.isEmpty(member.getLoginName()) || StrUtil.isEmpty(member.getPassWord())) {
            System.out.println("密码错误");
            return;
        }
        System.out.println("ValidateHandler 校验成功");
        chain.doHandler(member);
    }
}
