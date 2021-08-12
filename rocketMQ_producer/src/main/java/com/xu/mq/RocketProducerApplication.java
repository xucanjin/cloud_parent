package com.xu.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication  表示这是一个SpringBoot应用
 * @EnableEurekaClient  把应用注册到eureka上
 */
@SpringBootApplication
//@EnableEurekaClient
//指定要扫描的Mapper类的包的路径
//basePackages 可以配置多个路径
@MapperScan(basePackages = {"com.xu.mq.mapper"})

public class RocketProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketProducerApplication.class, args);
	}
}
