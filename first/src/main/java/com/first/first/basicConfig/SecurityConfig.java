package com.first.first.basicConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ravi").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("ajit").password("321").roles("USER");
	}

	// Based on URL

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/customers")
		.hasAnyRole("ADMIN")
		.antMatchers("/customer/**")
		.hasAnyRole("USER").
		anyRequest()
		.fullyAuthenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	public static NoOpPasswordEncoder PasswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
 */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
         .anyRequest().authenticated()
         .and()
         .oauth2Login();
    }

}
