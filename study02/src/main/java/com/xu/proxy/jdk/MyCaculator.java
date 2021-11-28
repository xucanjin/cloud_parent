package com.xu.proxy.jdk;

/**
 * @author canjin
 * @date 2021/11/28
 * @description
 */
public class MyCaculator implements Caculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
