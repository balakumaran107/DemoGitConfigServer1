package com.spring.boot.rabbit.mq.listener;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.boot.rabbit.mq.SpringBootRabbitMqApplication;

@Component
public class Runner implements CommandLineRunner {
	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;

	public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(SpringBootRabbitMqApplication.RABBIT_MQ_EXCHANGE, "foo.bar.baz",
				"Rabbit !!!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
}
