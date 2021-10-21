package com.first.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.first.first.model.Customer;
import com.first.first.repository.CustomerRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableWebSecurity
public class FirstApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository  custRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer customer=new Customer();
		customer.setName("Dinesh");
		customer.setMobile(784512365L);
		customer.setAddress("Mumbai");
		custRepo.save(customer);
		
		customer=new Customer();
		customer.setName("Rajesh");
		customer.setMobile(884512365L);
		customer.setAddress("Raj");
		custRepo.save(customer);
		
		/*
		 * List<Customer> list=custRepo.findAll();
		 * 
		 * for(int i=0; i<list.size() ; i++) { Customer c=list.get(i);
		 * System.out.println("--> "+c.getName()); }
		 * 
		 * System.out.println("Using Stream ------------"); list.stream() .map(c->
		 * c.getName()) .forEach(System.out::println);
		 */
	}

}
