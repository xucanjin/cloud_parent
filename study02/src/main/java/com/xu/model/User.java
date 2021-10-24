package com.xu.model;

import org.springframework.context.annotation.Bean;

/**
 * @author canjin
 * @date 2021/10/24
 * @description
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
