package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Component
//@service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	
	@Override
	public List<Customer> getAllCustomers() {
	//Business Logic
		 return customerRepo.getAllCustomers();
	}

}
