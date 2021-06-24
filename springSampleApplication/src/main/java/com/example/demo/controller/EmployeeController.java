package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;

@RestController
public class EmployeeController {
	
	@GetMapping("/api/employee")
	public ResponseEntity<Emp> getEmp(){
		
		Emp emp=new Emp();
		emp.setCity("pune");
		emp.setName("ravi");
		
		return new ResponseEntity<Emp>(emp,HttpStatus.OK);
	}
}
