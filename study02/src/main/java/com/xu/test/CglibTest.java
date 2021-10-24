package com.xu.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author canjin
 * @date 2021/10/24
 * @description  Cglib的使用
 */
public class CglibTest {

    public void test(){
        System.out.println("hello!");
    }
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before ....");
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("after");
                return object;
            }
        });
        CglibTest test= (CglibTest) enhancer.create();
        test.test();
    }
}
