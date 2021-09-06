package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserJwtService implements UserDetailsService{


	//@Autowired
	//UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Logic to get the user form the Database

        return new User("admin","password",new ArrayList<>());
	}

	//if connect with  the database
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not found!");
		}
		return new CustomUserDetails(user);
		
	}*/
}
