package com.xu.test.design.chain;

/**
 * @Author: canjin
 * @Date: 2021/4/11
 * 说明:
 */
public class Member {
    private String name;
    private String password;

    public Member(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String roleName;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
