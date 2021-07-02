package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@SpringBootApplication
public class SpringSampleApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSampleApplication.class, args);
	}
	
	
	@Override
    public void run(String... args) throws Exception {

        repository.save(new Customer("Ravi", "Pune"));
        repository.save(new Customer("Amir", "Mumbai"));
        repository.save(new Customer("Ajit", "Nashik"));
        
        repository.findAll().forEach((city) -> {
            System.out.println(" Initial Data --> "+ city);
        });
    }

}
