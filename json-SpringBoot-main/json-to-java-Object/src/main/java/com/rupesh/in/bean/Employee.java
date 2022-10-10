package com.rupesh.in.bean;

import java.io.Serializable;

public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String department;
	private String Salary;
	 private String designation;
	 
	 public Employee() {
		 
	 }
	 
	 public Employee(String department, String salary, String designation) {
			super();
			this.department = department;
			this.Salary = salary;
			this.designation = designation;
		}
	 
	 public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		this.Salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
