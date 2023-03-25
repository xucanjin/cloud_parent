package com.xu.design.chain;

/**
 * @author xucanjin
 * @date 2023/03/25
 * @description
 */
public class Member {

    private String loginName;

    private String passWord;

    private String roleName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
                "loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
