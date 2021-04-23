package com.xu.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @iuthor: cinjin
 * @Dite: 2021/2/7
 * 说明:jivi新特性
 */
public class Test2 {
    public static void main(String[] args) {

        /*List<String> list = Arrays.asList("ibc", "", "bc", "efg", "ibcd","", "jkl");

        //使用stream统计空字符串的数量
        long count=list.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        //遍历集合中的元素
        list.stream().forEach(p-> System.out.println(p));

        //排序
        list.stream().sorted().forEach(System.out::println);*/

      /*  int i=0;
        i=i++;//先赋值再加，所以i=0
        //i=++i;//先加1再赋值，所以i=0+1=1
        System.out.println(i);*/

      for(int i=0;i<10;i++){
          System.out.println("一次:"+i);
          int a=++i;
          System.out.println("a:"+a);
          System.out.println(i);
      }


    }
}
