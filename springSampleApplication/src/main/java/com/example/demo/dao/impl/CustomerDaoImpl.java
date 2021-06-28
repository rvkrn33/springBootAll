package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;

@Component
//@Repository
public class CustomerDaoImpl implements CustomerRepo{

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list=new ArrayList<Customer>();
		list.add(new Customer("abc","pune"));
		list.add(new Customer("asd","Mumbai"));
		list.add(new Customer("fgh","Nashik"));
		list.add(new Customer("kkk","Kolhapur"));
		
		return list;
	}

}
