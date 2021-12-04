package com.order.model;

public class Product {
	private int id;
	private String productDetails;
	private int price;
	
	public Product(){
		
	}
	public Product(int id, String productDetails, int price) {
		super();
		this.id = id;
		this.productDetails = productDetails;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
