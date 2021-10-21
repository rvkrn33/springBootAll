package com.first.first.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.first.model.Customer;
import com.first.first.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public 
	String addCustomer(Customer cust) {
		
		try {
			customerRepository.save(cust);
			return "data saved";
			
		}catch (Exception e) {
			return "Exception in addCustomer : data not saved "+e;
		}
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getCustomer(long id) {
		return customerRepository.findById(id);
	}

	@Override
	public String deleteCustomer(long id) {
		try {
			customerRepository.deleteById(id);
			return "Record deleted";
			
		}catch (Exception e) {
			return "Exception in deleteCustomer "+e;
		}
	}

	@Override
	public String updateCustomer(Customer cust) {
		
		try {
			customerRepository.save(cust);
			return "Record updated";
			
		}catch (Exception e) {
			return "Exception in updateCustomer "+e;
		}
	}

	
}
