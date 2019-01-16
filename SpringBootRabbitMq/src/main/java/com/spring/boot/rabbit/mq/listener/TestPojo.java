package com.spring.boot.rabbit.mq.listener;

public class TestPojo {
	String test1;
	String test2;

	public TestPojo(String test1, String test2) {
		this.test1 = test1;
		this.test2 = test2;
	}

	public String getTest1() {
		return test1;
	}

	public String getTest2() {
		return test2;
	}
}