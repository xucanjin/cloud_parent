package com.xu.utils;

import cn.hutool.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xucanjin
 * @date 2022/05/04
 * @description
 */
public class MyHttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(MyHttpUtil.class);
    private static String url = "http://localhost:8090/study03/test/name";

    public static void send() {

       /* HttpRequest pos = HttpRequest.post("urlString");
        HttpResponse execute = pos.execute();
        execute.body();*/
        Map<String, Object> map = new HashMap<>();
        map.put("input", "222");
        String post1 = HttpUtil.post(url, map);
        logger.info(post1);
    }

    public static void main(String[] args) {

        /*Executors.newFixedThreadPool(10).execute(() -> {
            for (int i = 0; i < 4000; i++) {
                send();
            }
        });*/

        for (int i = 0; i < 12000; i++) {
            new Thread(()->{
                send();
            }).start();
        }
    }
}
