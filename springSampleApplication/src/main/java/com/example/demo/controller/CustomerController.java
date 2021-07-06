package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.CustomerExceptions;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/cutomer")
	public List<Customer> getEmp() {
		
		List<Customer> list=customerService.getAllCustomers();
		
		return list;
	}
	
	
	@GetMapping("/customer/{city}")
	public ResponseEntity getByCity(@PathVariable String city) throws CustomerExceptions {
		
		Optional<Customer> cust=customerService.getByCity(city);
		if(cust.isPresent())
			return new ResponseEntity<Customer>(cust.get(),HttpStatus.OK);
		else
			throw new CustomerExceptions("data Not found");
	
	}
	
	@GetMapping("/customer/{name}/{city}")
	public Customer getByNameAndCity(@PathVariable String name,@PathVariable String city) {
		
		return customerService.getByCity(name,city);
	}
	
	@GetMapping("/customers/{name}/{city}")
	public Customer getByNameOrCity(@PathVariable String name,@PathVariable String city) {
		
		return customerService.getByNameOrCity(name,city);
	}
	
	
	@GetMapping("/cutomer/{custid}/{emp}")
	public ResponseEntity<String> getEmpId(@PathVariable String custid,String a) {
		
		return new ResponseEntity<String>("xyz",HttpStatus.OK);
	}
	
	
	@PostMapping("/add/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust){
		return new ResponseEntity<String>("Customer Created",HttpStatus.CREATED);
	}
	
	
}
