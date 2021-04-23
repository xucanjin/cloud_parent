package com.xu.test.design.builder;

/**
 * @Author: canjin
 * @Date: 2021/4/8
 * 说明: 建造者模式
 */
public class Builder {

    Course course=new Course();

    public Builder addName(String name){
        course.setName(name);
        return this;
    }

    public Builder addPPt(String ppt){
        course.setPpt(ppt);
        return this;
    }

    public Builder addVideo(String video){
        course.setVideo(video);
        return this;
    }
    public Course build(){
        return course;
    }
}
