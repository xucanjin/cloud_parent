package com.xu.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: canjin
 * @Date: 2021/4/1
 * 说明:
 */
public class MapTest {
    public static void main(String[] args) {
        mapTest3();
    }

    public static void mapTest1(){
        LinkedHashMap<String,String> map=new LinkedHashMap<>();
        map.put("12","1");
        map.put("13","2");
        map.put("14","3");
        map.put("15","4");
        map.put("16","5");
        map.forEach((k,v)->{
            System.out.println("key："+k+" 值："+v);
        });
    }

    public static void mapTest2(){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("12","1");
        map.put("13","2");
        map.put("14","3");
        map.put("15","4");
        map.put("16","5");
        map.forEach((k,v)->{
            System.out.println("hashMap--"+"key："+k+" 值："+v);
        });
    }

    private static void mapTest3(){
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("12","1");
        map.put("13","2");
        map.put("14","3");
        map.put("15","4");
        Map<String, String> stringMap = Collections.synchronizedMap(map);
        stringMap.forEach((k,v)->{
            System.out.println(k+"-"+v);
        });

    }
}
