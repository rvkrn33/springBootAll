package com.first.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.first.first.jwt.model.User;
import com.first.first.jwt.repository.UserRepository;
import com.first.first.model.Customer;
import com.first.first.repository.CustomerRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
@EnableWebSecurity
public class FirstApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository  custRepo;
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
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
		
		User u=new User();
		u.setUsername("ravi");
		u.setPassword("$2a$12$TFsWK0QGmGwtr33keh0V7.Z73NxiO/etpOxaoo.9mptcTYwIeEJRG");
		u.setRole("USER");
		
		User u1=new User();
		u1.setUsername("kamlesh");
		u1.setPassword("$2a$12$XL2tAUOYKJQxPj8sHclFTOTyt.GTZRmggPYVNwoIoah.wCae4JoX2");
		u1.setRole("USER");
		
		userRepository.save(u);
		userRepository.save(u1);
		
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
