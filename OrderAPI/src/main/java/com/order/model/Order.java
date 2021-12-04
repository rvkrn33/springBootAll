package com.order.model;

public class Order {
	private int id;
	private int productId;
	private String orderDate;
	public Order(int id, int productId, String orderDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderDate = orderDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
