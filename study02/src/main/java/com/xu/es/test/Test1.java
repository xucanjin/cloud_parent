package com.xu.es.test;

import cn.hutool.core.util.RandomUtil;

/**
 * @author xucanjin
 * @date 2021/12/26
 * @description
 */
public class Test1 {
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            int anInt = RandomUtil.randomInt(100);
            System.out.println(anInt);
        }
    }
}
