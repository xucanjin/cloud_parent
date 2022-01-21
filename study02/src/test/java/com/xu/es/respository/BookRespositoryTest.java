package com.xu.es.respository;

import com.xu.Study02Application;
import com.xu.es.bean.Book;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xucanjin
 * @date 2022/01/10
 * @description
 */
@SpringBootTest(classes = Study02Application.class)
@RunWith(SpringRunner.class)
class BookRespositoryTest {

    @Autowired
    private BookRespository bookRespository;

    /**
     * 添加索引和更新索引 id 存在更新 不存在添加
     */
    @Test
    public void testSaveOrUpdate(){
        Book book = new Book();
        book.setId("21");
        book.setName("小陈");
        book.setCreateDate(new Date());
        book.setAuthor("李白");
        book.setContent("这是中国的好人,这真的是一个很好的人,李白很狂");
        bookRespository.save(book);
    }

    /**
     * 删除一条索引
     */
    @Test
    public void testDelete() {
        Book book = new Book();
        book.setId("21");
        bookRespository.delete(book);
    }

    /**
     * 排序查询
     */
    @Test
    public void testFindAllOrder(){
        Iterable<Book> books = bookRespository.findAll(Sort.by(Sort.Order.asc("createDate")));
        books.forEach(book -> System.out.println(book) );
    }

    @Test
    public void testSearchPage() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(0).size(2).sort("age", SortOrder.DESC).query(QueryBuilders.matchAllQuery());
        searchRequest.indices("ems").types("emp").source(sourceBuilder);
       /* SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }*/
    }


}