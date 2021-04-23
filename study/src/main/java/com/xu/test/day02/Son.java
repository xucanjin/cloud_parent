package com.xu.test.day02;

/**
 * @Author: canjin
 * @Date: 2021/3/11
 * 说明:
 */
public class Son extends Parent{

    public Son(){
        System.out.println("儿子构造");
    }
    static{
        System.out.println("儿子静态代码块");
    }

}
