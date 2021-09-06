package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableWebSecurity
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	UserRepository userRepository;
	
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
		
		User u=new User();
		u.setUserName("ravi");
		u.setPassword("$2a$12$8I0ZBFS1EWCcSj3JubMHuOM.zorvkGRINApgNXiYPm2daD/bDbvsu");
		u.setRole("ADMIN");
	
		//$2a$12$nZypQU3CWtpJA9w7A/HrC.hhflppokqSDtecACK7snAk7eEDkrrZy
		
		User u1=new User();
		u1.setUserName("ajit");
		u1.setPassword("$2a$12$nZypQU3CWtpJA9w7A/HrC.hhflppokqSDtecACK7snAk7eEDkrrZy");
		u1.setRole("USER");
		
		userRepository.save(u);
		userRepository.save(u1);
	}

}
