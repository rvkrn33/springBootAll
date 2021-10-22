package com.example.SpringBootPawan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootPawan.model.Bank;
import com.example.SpringBootPawan.service.BankService;

@RestController
public class BankController {

	@Autowired
	BankService bankService;
	
	@PostMapping("/bank")  //Handle request
	public String addBank(@RequestBody Bank bank) {
		
		System.out.println("---> "+bank.getBankName());
		System.out.println("---> "+bank.getBranchName());
		System.out.println("---> "+bank.getAddress());
		
		String str=bankService.addBank(bank);
		
		return str;
	}
}
