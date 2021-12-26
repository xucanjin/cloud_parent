package com.xu.es.mapper;

import com.xu.es.bean.StudentEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author canjin
 * @date 2021/12/26
 * @description
 */
public interface StudentSearchMapper extends ElasticsearchRepository<StudentEs,String> {

}
