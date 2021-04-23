package com.xu.test.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class Test2 {
    public static void main(String[] args) {
        sort2();
    }

    static void sort2(){
        Random random=new Random();
        List list=new ArrayList();
        for(int i=0;i<10;i++){
            list.add(random.nextInt(1000));
        }

        Collections.sort(list);

        Iterator it = list.iterator();
        int count = 0;
        while(it.hasNext()){
            System.out.println(++count+":"+it.next());
        }

    }
}
