package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByCity(String city);

	//select id, city, name from customer  where name=? and city=?
	Customer findByNameOrCity(String name,String city);
	
	Customer findByNameAndCity(String name,String city);
	

}
