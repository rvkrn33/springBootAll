package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.demo.exception.DataNotFound;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	 private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	 
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/custData")
	public ResponseEntity<String> saveCustData(@RequestBody Customer cust) {
		
		String status= customerService.saveCustData(cust);
		logger.debug("Status is ===>>>>>>>>> "+status);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public String getMsg()
	{
		logger.debug("Welcome ----------- ");
			return "Welcome";
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		logger.info("list :: ");
		logger.info("list :: ");
		
		List<Customer> list=customerService.getCustomerList();
		logger.info("list :: ",list);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) throws DataNotFound{
		
		Customer customer=customerService.getCustomer(id);
		if(customer!=null)
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		else
			throw new DataNotFound("Data not found");
	}
	
	@PutMapping("/custUpdateData")
	public ResponseEntity<String> updateCustData(@RequestBody Customer cust) {
		
		String status= customerService.updateCustData(cust);
		
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@PutMapping("/custUpdateAllData")
	public ResponseEntity<String> customUpdateCustData(@RequestBody Customer cust) {
		
		String status= customerService.customUpdateCustData(cust);
		
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id){
		
		String status=customerService.deleteCustomer(id);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
}
