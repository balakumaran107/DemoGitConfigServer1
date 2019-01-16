package com.springframework.rabbitmq.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPlatformRabbitMqConfig {

	/**
	 * Rabbit MQ exchange name
	 */
	public static final String RABBIT_MQ_EXCHANGE = "spring-boot-order-exchage";

	/**
	 * Rabbit MQ queue
	 */
	public static final String RABBIT_MQ_QUEUE = "spring-boot-order-queue";

	/**
	 * Rabbit MQ binding routing key
	 */
	public static final String RABBIT_MQ_ROUTING_KEY = "foo.bar.#";

	/**
	 * durable order queue
	 * 
	 * @return queue
	 */
	@Bean
	public Queue orderQueue() {
		return new Queue(OrderPlatformRabbitMqConfig.RABBIT_MQ_QUEUE, false);
	}

	/**
	 * Rabbit MQ topic exchange
	 * 
	 * @return
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(OrderPlatformRabbitMqConfig.RABBIT_MQ_EXCHANGE);
	}

	/**
	 * 
	 * @param orderQueue
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding topicBinding(Queue orderQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(orderQueue).to(topicExchange)
				.with(OrderPlatformRabbitMqConfig.RABBIT_MQ_ROUTING_KEY);
	}

}
