package com.xu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @SpringBootApplication  表示这是一个SpringBoot应用
 * @EnableEurekaClient  把应用注册到eureka上
 */
@SpringBootApplication
//@EnableEurekaClient
//指定要扫描的Mapper类的包的路径
//basePackages 可以配置多个路径
@MapperScan(basePackages = {"com.xu.mapper"})
//@EnableDubbo
@EnableAsync
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}
}
