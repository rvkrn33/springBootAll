package com.example.SpringBootPawan.service;

import java.util.List;

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

	@Override
	public String updateBankDetails(Bank data) {
		bankRespository.save(data);
		return "Record updated";
	}

	@Override
	public String deleteBank(long id) {
		bankRespository.deleteById((int)id);
		return "Record deleted "+id;
	}

	@Override
	public Bank fetchByParameter(int id,String any) {
		//fetch by id or name
		return bankRespository.findByBankIdOrBankName(id,any);
	}

	@Override
	public List<Bank> fetchAll() {
		return bankRespository.findAll();
	}

}
