package com.xu.es.mapper;

import com.xu.es.bean.UserEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author canjin
 * @date 2021/12/26
 * @description
 */
public interface UserSearchMapper extends ElasticsearchRepository<UserEs,String> {

}
