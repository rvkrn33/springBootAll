package com.example.junit.repository;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@DataJpaTest
public class CustomerRespositoryTest {

	
	@Autowired
	private  CustomerRepository customerRepository;
	
	@Test
	public void testFindByCity() {
		
		System.out.println("Test");
		Customer custFirst=new Customer("abc", "Kolhapur");
		customerRepository.save(custFirst);
		Customer cust=customerRepository.findByNameOrCity("abc", "Kolhapur");
	
		if(null!=cust) {
			System.out.println("test case true block....");
			assertThat(cust).isEqualTo(cust);
		}
		else
			System.out.println("test case fail....");
			
	}
	
}
