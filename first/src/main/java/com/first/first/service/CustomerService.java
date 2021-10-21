package com.first.first.service;

import java.util.List;
import java.util.Optional;

import com.first.first.model.Customer;

public interface CustomerService {

	public String addCustomer(Customer cust);

	public List<Customer> getCustomers();

	public Optional<Customer> getCustomer(long id);

	public String deleteCustomer(long id);

	public String updateCustomer(Customer cust);
}
