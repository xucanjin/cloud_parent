package com.xu.test;

import java.util.ArrayList;

/**
 * @author canjin
 * @date 2021/10/10
 * @description
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1=new Test1();

        test1.testHeap();

    }

    //堆溢出  循环创建对象
    public void testHeap(){
        for(;;){
            ArrayList list = new ArrayList(2000);
            System.out.println("11");
        }
    }

    int num=1;
    //栈溢出  递归调用方法
    public void testStack(){
        num++;
        this.testStack();
    }
}
