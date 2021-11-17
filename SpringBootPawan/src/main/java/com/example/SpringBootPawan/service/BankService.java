package com.example.SpringBootPawan.service;

import java.util.List;

import com.example.SpringBootPawan.model.Bank;

public interface BankService {

	public String addBank(Bank bank);

	public String updateBankDetails(Bank data);

	public String deleteBank(long id);

	public Bank fetchByParameter(int id,String any);

	public List<Bank> fetchAll();
}
