package com.xu.utils;

/**
 * @author xucanjin
 * @date 2022/10/16
 * @description
 */
public class Test1Uil {

    private String age;

    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test1() {
        Test2Util.test2(this);
        System.out.println("20");
    }
}
