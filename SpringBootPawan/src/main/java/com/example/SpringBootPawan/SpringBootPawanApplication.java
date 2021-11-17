package com.example.SpringBootPawan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringBootPawan.model.Bank;
import com.example.SpringBootPawan.repository.BankRespository;

@SpringBootApplication
public class SpringBootPawanApplication implements CommandLineRunner{

	@Autowired
	BankRespository bankRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPawanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Bank bank=new Bank();
		bank.setBankName("Axis");
		bank.setAddress("Pune");
		bankRepo.save(bank);
		
		Bank bank1=new Bank();
		bank1.setBankName("HDFC");
		bank1.setAddress("Airoli");
		bankRepo.save(bank1);
		
		
		
	}

}
