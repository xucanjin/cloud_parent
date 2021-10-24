package com.xu.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author canjin
 * @date 2021/10/24
 * @description
 */
public class StringTest {
    public static void main(String[] args) {

        //得到当前时间 yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);

        //得到当前时间 yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);
    }
}
