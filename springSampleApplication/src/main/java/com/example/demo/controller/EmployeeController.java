package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/emp")
	public ResponseEntity<String> getEmployee(){
		
		
		return new ResponseEntity<String>("rajesh",HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<String> getEmployeeId(@PathVariable String empid){
		
		return new ResponseEntity<String>("John",HttpStatus.OK);
	}
	
	@PostMapping("/add/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Emp emp){
		
		return new ResponseEntity<String>("Employee Added",HttpStatus.CREATED);
	}
	
	@PostMapping("/create/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Emp emp){
		System.out.println("Employee Created");
		return new ResponseEntity<String>("Employee Added",HttpStatus.CREATED);
	}
}
