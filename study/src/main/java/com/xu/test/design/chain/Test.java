package com.xu.test.design.chain;

/**
 * @Author: canjin
 * @Date: 2021/4/11
 * 说明:
 */
public class Test {
    public static void main(String[] args) {
        ValidateHandler validateHandler=new ValidateHandler();
        LoginHandler loginHandler=new LoginHandler();
        validateHandler.next(loginHandler);

        validateHandler.doHandler(new Member("admin",""));
    }
}
