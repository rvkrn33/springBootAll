package com.order;

public class Order {

	private int orderId;
	private int productId;
	private String orderDetails;
	public Order(int orderId, int productId, String orderDetails) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.orderDetails = orderDetails;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
