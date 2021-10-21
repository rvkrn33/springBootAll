package com.example.SpringBootPawan.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootPawan.model.Bank;

@RestController
public class BankController {

	@PostMapping("/bank")
	public String addBank(@RequestBody Bank bank) {
		
		System.out.println("---> "+bank.getBankName());
		System.out.println("---> "+bank.getBranchName());
		System.out.println("---> "+bank.getAddress());
		
		return "Record added";
	}
}
