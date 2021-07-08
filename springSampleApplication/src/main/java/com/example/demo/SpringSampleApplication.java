package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Customer;
import com.example.demo.model.User;

@SpringBootApplication
@EnableWebSecurity
public class SpringSampleApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository repository;
	
	
	@Autowired
	UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSampleApplication.class, args);
	} 
	
	
	@Override
    public void run(String... args) throws Exception {

		User user;
		user=new User();
		user.setUsername("ravi");
		user.setPassword("$2y$12$UA1WFuoH4P.zz/HTllw5ruxshoEFcP2nFNCWexRmaseyn1yqT0My2 ");
		user.setRole("ADMIN");
		userRepo.save(user);
		
		user=new User();
		user.setUsername("ajit");
		user.setPassword("$2y$12$WZqCe1CnAlplzV9RbN5.qeB36owjLPHz024Y3gKUwy2aQ9ewO1BTK ");
		user.setRole("USER");
		userRepo.save(user);
		
        repository.save(new Customer("Ravi", "Pune"));
        repository.save(new Customer("Amir", "Mumbai"));
        repository.save(new Customer("Ajit", "Nashik"));
        
        repository.findAll().forEach((city) -> {
            System.out.println(" Initial Data --> "+ city);
        });
    }

}
