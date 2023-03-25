package com.xu.design.chain;

import com.xu.design.chain.handler.MyHandler;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description
 */
public class Test {

    public static void main(String[] args) {

        //test("1","");
        test("name","111");
    }

    public static void test(String name,String password){

        /*ValidateHandler validateHandler = new ValidateHandler();
        LoginHandler loginHandler = new LoginHandler();

        validateHandler.next(loginHandler);*/

        Member member = new Member();
        member.setLoginName(name);
        member.setPassWord(password);

        MyHandler.Builder<Object> builder = new MyHandler.Builder<>();
        builder.addBuilder(new ValidateHandler()).addBuilder(new LoginHandler())
        .addBuilder(new AuthHandler());
        builder.build().doHandler(member);

    }
}
