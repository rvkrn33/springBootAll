package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository custRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer c=new Customer("ravi",7852369852L,"Pune");
		Customer c1=new Customer("ajit",7852369852L,"Goa");
		Customer c2=new Customer("rajesh",7852369852L,"Mumbai");
		
		custRepo.save(c);
		custRepo.save(c1);
		custRepo.save(c2);
		
		System.out.println("Data Saved ");
		
	
	}

}
