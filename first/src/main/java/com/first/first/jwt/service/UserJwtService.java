package com.first.first.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserJwtService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database
        return new User("admin","password",new ArrayList<>());
    }
	
	//@Autowired
	//UserRepository userRepo;
	
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
