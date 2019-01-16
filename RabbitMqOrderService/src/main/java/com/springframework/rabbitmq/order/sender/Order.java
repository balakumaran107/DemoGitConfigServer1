package com.springframework.rabbitmq.order.sender;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2765049792356585840L;
	/**
	 * orderNumber
	 */
	private String orderNumber;

	/**
	 * product id
	 */
	private String productId;

	/**
	 * amount
	 */
	private double amount;

	/**
	 * get order number
	 * 
	 * @return
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * set order number
	 * 
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * get product id
	 * 
	 * @return
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * set product id
	 * 
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * get amount
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * set amount
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
