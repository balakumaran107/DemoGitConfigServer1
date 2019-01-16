package com.springframework.rabbitmq.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.springframework.rabbitmq.order.sender.Order;

@Controller
public interface RabbitMqOrderPlatformController {
	@PostMapping("/sendOrder")
	public String sendOrderToQueue(Order order);
}
