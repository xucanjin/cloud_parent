package com.xu.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author canjin
 * @date 2021/11/28
 * @description
 */
public class MyInvocationHandler implements InvocationHandler{

    private Object object;


    public Object creteProxy(Object object) {
        this.object = object;
        /**
         * 	Proxy.newProxyInstance方法包含3个参数
         第一个是类加载器,我们采用target本身的类加载器
         第二个是把生成的动态代理对象下挂在那些接口下,这个写法就是放在target实现的接口下
         HelloWorldImpl对象的接口显然就是HelloWorld。
         第三个是定义实现方法逻辑的代理类,this表示当前对象,它必须实现InvocationHandler接口的invoke方法,
         它就是代理逻辑方法的实现方法。
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始jdk代理");
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}
