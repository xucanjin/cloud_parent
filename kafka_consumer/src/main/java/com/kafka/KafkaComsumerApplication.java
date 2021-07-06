package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication  表示这是一个SpringBoot应用
 * @EnableEurekaClient  把应用注册到eureka上
 */
@SpringBootApplication
public class KafkaComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaComsumerApplication.class, args);
	}
}
