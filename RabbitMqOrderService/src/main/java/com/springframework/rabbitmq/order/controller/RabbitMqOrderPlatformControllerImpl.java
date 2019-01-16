package com.springframework.rabbitmq.order.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.springframework.rabbitmq.order.sender.Order;
import com.springframework.rabbitmq.order.sender.OrderMessageSender;

public class RabbitMqOrderPlatformControllerImpl implements RabbitMqOrderPlatformController {

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
