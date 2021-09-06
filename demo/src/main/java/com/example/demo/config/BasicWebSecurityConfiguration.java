package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class BasicWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ravi").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ajit").password("456").roles("USER");
	}
	
	//Based on URL
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); http.authorizeRequests()
	 * .antMatchers("/getCustomer/**") .fullyAuthenticated() .and() .httpBasic(); }
	 */
	 
	
	//Based on role
	
	  @Override protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable(); 
		  http.authorizeRequests()
		  .antMatchers("/getAllCustomers") 
		  .hasAnyRole("ADMIN")
		  .antMatchers("/getCustomer/**") 
		  .hasAnyRole("USER") 
		  .anyRequest()
		  .fullyAuthenticated()
		  .and()
		  .httpBasic(); 
	  }
	 
	@Bean
	public static NoOpPasswordEncoder PasswordEncoder(){
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
