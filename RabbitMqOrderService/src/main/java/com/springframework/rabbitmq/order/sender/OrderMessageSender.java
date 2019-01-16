package com.springframework.rabbitmq.order.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.rabbitmq.order.config.OrderPlatformRabbitMqConfig;

@Service
public class OrderMessageSender {

	/**
	 * {@link RabbitTemplate}
	 */
	private final RabbitTemplate rabbitTemplate;

	/**
	 * Order message sender template injected
	 * 
	 * @param rabbitTemplate
	 */
	@Autowired
	public OrderMessageSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendOrder(Order order) {
		this.rabbitTemplate.convertAndSend(OrderPlatformRabbitMqConfig.RABBIT_MQ_ROUTING_KEY, order);

	}
}
