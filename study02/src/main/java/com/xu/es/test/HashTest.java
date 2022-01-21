package com.xu.es.test;


import java.util.HashMap;
import java.util.Map;

/**
 * @author xucanjin
 * @date 2022/01/21
 * @description
 */
public class HashTest {
    public static void main(String[] args) {

        Map<String, Object> hash = new HashMap<>();

        hash.put("1", "1");
        hash.put("2", "2");
        hash.put("3", "3");
        hash.put("1", "4");

        for (Map.Entry<String, Object> entry : hash.entrySet()) {
            System.out.println("key:"+entry.getKey() + " value:" + entry.getValue());
        }
    }
}
