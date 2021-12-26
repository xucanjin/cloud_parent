package com.xu.es.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author canjin
 * @date 2021/12/26
 */
@Document(indexName = "student",type = "student")
public class StudentEs implements Serializable {

    @Id
    private Integer id;

    private String address;

    /**
     * 指定某个字段分词器
     */
    /*, analyzer = "ik_smart", searchAnalyzer = "ik_smart"*/
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String name;

    private String course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
