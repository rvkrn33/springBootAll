package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public Optional<Customer> getByCity(String city);

	public Customer getByCity(String name, String city);
	
	public Customer getByNameOrCity(String name, String city);

}
