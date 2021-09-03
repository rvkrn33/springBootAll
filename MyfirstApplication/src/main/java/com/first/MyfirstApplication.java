package com.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@EnableAutoconfiguration + @Configuration + @componentScan 
public class MyfirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstApplication.class, args);
	}

}
