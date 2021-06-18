package com.xu.thread;

import com.xu.bean.User;
import com.xu.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/6/18
 * 说明: 用多线程给用户发送消息的demo
 */
public class UserThread implements Runnable{

    public static List<User> init(){
        List<User> userList=new ArrayList<>();
        for(int i=0;i<1000;i++){
            User user=new User();
            user.setAge(i);
            user.setName(i+"n");
            userList.add(user);
        }
        return userList;
    }

    public static void main(String[] args) {
        List<User> userList=init();
        int threadSzie=100;
        List<List<User>> splitList= ListUtil.splitList(userList,threadSzie);
        for(int i=0;i<splitList.size();i++){
            List<User> list=splitList.get(i);
            new Thread(new UserThread(list)).start();
        }
    }

    private List<User> userList;

    public UserThread(){

    }
    public UserThread(List<User> userList){
        this.userList=userList;
    }
    @Override
    public void run() {
        for(User user:userList){
            System.out.println(Thread.currentThread().getName()+"向"+user+"发送消息");
        }
    }
}
