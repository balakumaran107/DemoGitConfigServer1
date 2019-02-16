package com.springframework.rabbitmq.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.rabbitmq.order.sender.Order;

@RestController
public interface RabbitMqOrderPlatformController {
	@RequestMapping(value = "/sendOrder", method = RequestMethod.POST)
	public String sendOrderToQueue(Order order);
}
