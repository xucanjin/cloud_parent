package com.xu;

import com.xu.aop.OrderService;
import com.xu.aop.SaveOrder;
import com.xu.aop.UpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication  表示这是一个SpringBoot应用
 * 配置切面，记录订单id
 */
@SpringBootApplication
public class Study03Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Study03Application.class, args);

	}

	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		SaveOrder order1 = new SaveOrder();
		order1.setId(1L);
		orderService.saveOrder(order1);

		UpdateOrder order2 = new UpdateOrder();
		order2.setOldId(2L);
		orderService.updateOrder(order2);
	}
}
