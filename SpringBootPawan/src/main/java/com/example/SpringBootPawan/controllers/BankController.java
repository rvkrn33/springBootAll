package com.example.SpringBootPawan.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootPawan.exceptions.DataNotFoundException;
import com.example.SpringBootPawan.model.Bank;
import com.example.SpringBootPawan.service.BankService;

@RestController
public class BankController {

	 Logger logger = LoggerFactory.getLogger(BankController.class);
	 
	@Autowired
	BankService bankService;
	
	@PostMapping("/bank")  //Handle request
	public String addBank(@RequestBody @Validated Bank bank) {
		
		System.out.println("---> "+bank.getBankName());
		System.out.println("---> "+bank.getBranchName());
		System.out.println("---> "+bank.getAddress());
		
		String str=bankService.addBank(bank);
		logger.info("Response {}",str);
		return str;
	}
	
	//update
	@PutMapping("/update")
	public String updateBank(@RequestBody Bank data){
		return bankService.updateBankDetails(data);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String deleteBank(@PathVariable long id){
		return bankService.deleteBank(id);
	}

	@GetMapping("/fetch/{id}/{name}")
	public Bank getBankDetails(@PathVariable int id,@PathVariable String name){
		return bankService.fetchByParameter(id,name);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Bank>> getAllBankDetails(){
		List<Bank> list=bankService.fetchAll();
		if(null!=list && list.size()>0)
			return new ResponseEntity(list,HttpStatus.OK);
		else
			//throw new DataNotFoundException("Data not found");
			return new ResponseEntity(list,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/fetchAllDetails")
	public ResponseEntity<List<Bank>> getAllDetails() throws DataNotFoundException{
		List<Bank> list=bankService.fetchAll();
		if(null!=list && list.size()>0)
			return new ResponseEntity(list,HttpStatus.OK);
		else
			throw new DataNotFoundException("Data not found");
	}
	
	@RequestMapping(value = "/bankData")
	public String saveBank(@RequestBody Bank bank) {
		
		String str=bankService.addBank(bank);
		logger.info("Response {}",str);
		return str;
	}



}
