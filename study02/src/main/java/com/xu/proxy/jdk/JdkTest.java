package com.xu.proxy.jdk;

/**
 * @author canjin
 * @date 2021/11/28
 * @description
 */
public class JdkTest {
    public static void main(String[] args) {

        MyInvocationHandler invocationHandler=new MyInvocationHandler();
        Caculator c =(Caculator) invocationHandler.creteProxy(new MyCaculator());
        System.out.println(c.add(2,3));
    }
}
