package com.xu.es.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author xucanjin
 * @date 2022/01/10
 * @description
 */
@Document(indexName = "dangdang",type = "book")
public class Book {

    /**
     * @Document: 代表一个文档记录
     * indexName: 用来指定索引名称

     * type: 用来指定索引类型
     * @Id: 用来将对象中id和ES中_id映射
     * @Field: 用来指定ES中的字段对应Mapping

     * type: 用来指定ES中存储类型
     *
     * analyzer: 用来指定使用哪种分词器 ik_max_word：会将文本做最细粒度的拆分
     * ik_smart：会做最粗粒度的拆分
     */
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Field(type = FieldType.Keyword)
    private String author;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
