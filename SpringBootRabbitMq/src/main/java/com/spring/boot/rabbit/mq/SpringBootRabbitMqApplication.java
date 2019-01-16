package com.spring.boot.rabbit.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.boot.rabbit.mq.listener.Receiver;

@SpringBootApplication
public class SpringBootRabbitMqApplication {

	/**
	 * Rabbit MQ exchange name
	 */
	public static final String RABBIT_MQ_EXCHANGE = "spring-boot-exchange";

	/**
	 * Rabbit MQ queue
	 */
	public static final String RABBIT_MQ_QUEUE = "spring-boot-queue";

	/**
	 * Rabbit MQ Queue
	 * 
	 * @return Queue
	 */
	@Bean
	public Queue queue() {
		return new Queue(SpringBootRabbitMqApplication.RABBIT_MQ_QUEUE, false);
	}

	/**
	 * Rabbit MQ Exchange
	 * 
	 * @return topicExchange
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(SpringBootRabbitMqApplication.RABBIT_MQ_EXCHANGE);
	}

	/**
	 * 
	 * @param queue
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
	}

	/**
	 * 
	 * @param connectionFactory
	 * @param messageListenerAdapter
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(messageListenerAdapter);
		container.setQueueNames(SpringBootRabbitMqApplication.RABBIT_MQ_QUEUE);
		return container;
	}

	/**
	 * 
	 * @param receiver
	 * @return
	 */
	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args).close();
	}
}
