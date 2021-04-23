package com.xu.test.design.builder;

/**
 * @Author: canjin
 * @Date: 2021/4/10
 * 说明:
 */
public class StringBuild {

    String str=new String();
    public StringBuild append(String ss){
        str+=ss;
        return this;
    }

    public String build(){
        return str;
    }
}
