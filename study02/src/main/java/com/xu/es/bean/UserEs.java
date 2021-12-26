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
@Document(indexName = "us",type = "user")
public class UserEs implements Serializable {

    @Id
    private Integer id;

    private Integer age;

    /**
     * 指定某个字段分词器
     */
    /*, analyzer = "ik_smart", searchAnalyzer = "ik_smart"*/
    @Field(type = FieldType.Text)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
