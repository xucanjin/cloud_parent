package com.xu.es.respository;

import com.xu.es.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author xucanjin
 * @date 2022/01/10
 * @description
 */
public interface BookRespository extends ElasticsearchRepository<Book,String> {

    //根据作者查询
    List<Book> findByAuthor(String keyword);

    //根据内容查询
    List<Book> findByContent(String keyword);

    //根据内容和名字查
    List<Book> findByNameAndContent(String name,String content);

    //根据内容或名称查询
    List<Book> findByNameOrContent(String name,String content);

    //范围查询
    List<Book> findByPriceBetween(Double start,Double end);

    //查询名字以xx开始的
    List<Book>  findByNameStartingWith(String name);

    //查询某个字段值是否为false
    List<Book>  findByNameFalse();
}
