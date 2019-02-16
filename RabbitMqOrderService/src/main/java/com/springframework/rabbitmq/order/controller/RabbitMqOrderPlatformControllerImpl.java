package com.springframework.rabbitmq.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springframework.rabbitmq.order.sender.Order;
import com.springframework.rabbitmq.order.sender.OrderMessageSender;

@Component
public class RabbitMqOrderPlatformControllerImpl implements RabbitMqOrderPlatformController {
	/**
	 * Order message sender
	 */
	private final OrderMessageSender orderMessageSender;

	/**
	 * auto wiring order message sender
	 * 
	 * @param orderMessageSender
	 */
	@Autowired
	public RabbitMqOrderPlatformControllerImpl(OrderMessageSender orderMessageSender) {
		this.orderMessageSender = orderMessageSender;
	}

	/**
	 * send message to order queue
	 */
	@Override
	public String sendOrderToQueue(Order order) {
		this.orderMessageSender.sendOrder(order);
		return "Success";
	}
}
