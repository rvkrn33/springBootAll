package com.first.model;

public class Employee {

	private String name;
	private long mobile;
	
	public Employee(){
		
	}
	
	public Employee(String name, long mobile) {
		this.name=name;
		this.mobile=mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
}
