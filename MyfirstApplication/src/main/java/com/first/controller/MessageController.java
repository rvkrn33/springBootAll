package com.first.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.first.Message;
import com.first.model.Employee;
import com.first.service.EmployeeService;
import com.first.service.EmployeeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

//@Controller
@RestController  //@controller + @ResponseBody
public class MessageController {

	//@Autowired
	//EmployeeService empService=new EmployeeServiceImpl();
	
	@Value("${message}")
	String msg;
	
	@Autowired
	EmployeeService empService;
	
	//constructor injection
	
	/*
	 * MessageController(EmployeeService empService) {
	 * 
	 * this.empService=empService;
	 * 
	 * System.out.println("Constructor injection -----------------"); }
	 * 
	 * 
	 * //setter Injection
	 * 
	 * 
	 * public void setEmpService(EmployeeService empService) { this.empService
	 * =empService; System.out.println("Setter injection -----------------"); }
	 */
	
	//@ResponseBody
	@GetMapping("/getMessage") // @Get + @RequestMapping
	public String getMsg() {
		
		return msg;
	}
	
	@GetMapping("/getMessage/{msg}") // @Get + @RequestMapping
	public String getMsg(@PathVariable String msg) {
		
		return "hello "+msg;
	}
	
	
	 @GetMapping("/getAllEmployees") // @Get + @RequestMapping public String
	 public ResponseEntity<?> getEmployees() 
	 { 
		 List<Employee> list=empService.getAllEmployees();
		
		 if(list.isEmpty()) {
			 return new ResponseEntity<String>("Data not found",HttpStatus.NOT_FOUND); 
		 }else
			 return new ResponseEntity<List<Employee>>(list,HttpStatus.OK); 
	  
	}
	
	@PostMapping("/saveMsg")
	public Message saveMsg(@RequestBody Message msg ) {
		Gson gson = new Gson();
		
		String  message=gson.toJson(msg);
		
		System.out.println("POJO to JSON -> "+message);
		
		System.out.println("Message "+msg.getName());
		
		msg.setName("Amar");
		
		return msg;
	}
}
