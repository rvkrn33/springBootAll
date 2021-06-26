package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
public class CustomerController {

	
	@GetMapping("/cutomer")
	public ResponseEntity<String> getEmp() {
		
		return new ResponseEntity<String>("abc",HttpStatus.OK);
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
