package com.first.first.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.first.exceptions.CustomException;
import com.first.first.model.Customer;
import com.first.first.service.CustomerService;

@RestController
public class CustomerController {

	//url -> endpoint
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer cust) {
		System.out.println("Data received ");
		
		String response =customerService.addCustomer(cust);
		
		return response;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> customers() throws CustomException{
		
		List<Customer> list=customerService.getCustomers();
		if(list.size() >0)
			return new ResponseEntity(list,HttpStatus.OK);
		else
			throw new CustomException("Data not available");
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> customer(@PathVariable long id){
		
		Optional<Customer> op=customerService.getCustomer(id);
		
		if(op.isPresent()) {
			return new ResponseEntity(op.get(),HttpStatus.OK);
		}else
			return new ResponseEntity("Data Not found",HttpStatus.OK);
	}
	

@DeleteMapping("/deleteCustomer/{id}")
public ResponseEntity<String> deleteCustomer(@PathVariable long id){

	String msg= customerService.deleteCustomer(id);
	
	return new ResponseEntity<String>(msg,HttpStatus.OK);
}


@PutMapping("/updateCustomer")
public ResponseEntity<String> updateCustomer(@RequestBody Customer cust){
	String msg=customerService.updateCustomer(cust);
	return new ResponseEntity<String>(msg,HttpStatus.OK);
}
	
}
