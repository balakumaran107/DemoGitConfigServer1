package com.springframework.rabbitmq.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.springframework.rabbitmq.order", "com.springframework.rabbitmq.order.controller" })
public class RabbitMqOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqOrderServiceApplication.class, args);
	}
}