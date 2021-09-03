package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {

	public String saveCustData(Customer cust);

	public List<Customer> getCustomerList();

	public Customer getCustomer(long id);

	public String updateCustData(Customer cust);

	public String deleteCustomer(long id);

	public String customUpdateCustData(Customer cust);
}
