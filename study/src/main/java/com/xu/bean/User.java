package com.xu.bean;

import java.io.Serializable;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */

public class User implements Serializable{
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
