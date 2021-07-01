package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Component
//@service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	CustomerRepository customerRepository;
	/*
	 * public void setCustomerRepo( CustomerRepo customerRepo) {
	 * this.customerRepo=customerRepo; }
	 */
	
	
	@Override
	public List<Customer> getAllCustomers() {
	//Business Logic
		System.out.println("CustomerServiceImpl calling");
		
	return	customerRepository.findAll();
		
		// return customerRepo.getAllCustomers();
	}

}
