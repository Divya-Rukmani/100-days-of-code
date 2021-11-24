package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		CustomerServiceImpl service = null;
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication
				.run(DemoApplication.class, args);
		service = (CustomerServiceImpl) context.getBean("customerService");
		System.out.println(service.fetchCustomer());
        context.close();
	}

}
