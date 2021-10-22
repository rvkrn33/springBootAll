package com.example.SpringBootPawan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootPawan.model.Bank;
import com.example.SpringBootPawan.repository.BankRespository;

@Service
 public class BankServiceImpl implements BankService{

	@Autowired
	BankRespository bankRespository;
	
	
	@Override
	public String addBank(Bank bank) {
		bankRespository.save(bank);
		
		return "Record added";
	}

}
