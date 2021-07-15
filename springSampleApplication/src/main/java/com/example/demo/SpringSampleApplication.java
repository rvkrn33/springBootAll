package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
    public void run(String... args) throws Exception {

		User user;
		user=new User();
		user.setUsername("ravi");
		user.setPassword("$2y$12$j/9WpWe1PMWvYMjV/AAMe.ClSHuwCq216y/sR9J3y5ueE2r7KL8fi");
		user.setRole("ADMIN");
		userRepo.save(user);
		
		user=new User();
		user.setUsername("ajit");
		user.setPassword("$2y$12$T4/MirKDcnjK16AKNvmoIevA7FaPOC.EzgjQl6xKBUgLA5Dslii5m");
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
