package com.ioc.container;

public class Employee {

	private String empName;
	private int empId;
	private Address address;
	
	Employee(){
		System.out.println("Employee object loaded");
	}
	
	Employee(String empName, int id, Address address){
		this.empName = empName;
		this.empId= id;
		this.address= address;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Address getAddress() {
		return address;
	}
	

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", address=" + address + "]";
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
