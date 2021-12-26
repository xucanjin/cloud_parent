package com.xu;

import com.xu.compo.CreateSupplier;
import com.xu.utils.SpringBeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @SpringBootApplication  表示这是一个SpringBoot应用
 * @EnableEurekaClient  把应用注册到eureka上
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.xu.es.mapper")
public class Study02Application {

	public static void main(String[] args) {
		SpringApplication.run(Study02Application.class, args);

		CreateSupplier bean= (CreateSupplier) SpringBeanUtil.getBean("createSupplier");

	}
}
