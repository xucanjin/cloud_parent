package com.xu.test.day01;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class ChildClass extends FatherClass{

    public ChildClass(){
        System.out.println("child create!");
    }

    private class InnerClass{

    }

    class InnerOne{

    }
}
