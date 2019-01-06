package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class DemoTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTaskApplication.class, args);
	}

	@Bean
	public DemoRunner demoRunner() {
		return new DemoRunner();
	}

	public class DemoRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
			if (args != null) {
				System.out.println(args.length);
			}

		}
	}
}
