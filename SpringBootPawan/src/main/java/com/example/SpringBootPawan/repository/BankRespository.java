package com.example.SpringBootPawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootPawan.model.Bank;

@Repository
public interface BankRespository extends JpaRepository<Bank, Integer>{

	public Bank findByBankIdOrBankName(int id,String any);

}
