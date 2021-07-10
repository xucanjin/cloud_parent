package com.xu.elasticsearch.mapper;

import com.xu.elasticsearch.bean.UserEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/*****
 * @Author:
 * @Description:
 ****/
public interface UserSearchMapper extends ElasticsearchRepository<UserEs,String> {
}
