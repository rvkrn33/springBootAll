package com.example.SpringBootPawan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController   //@Controller + @ResponseBody
@RequestMapping("/api")
public class SampleController {

	
	@GetMapping("/") //@Get + @RequestMapping
	//@ResponseBody
	public String printMessage() {
		
		return "Welcome Pawan..........!!!!";
	}
	
	@GetMapping("/{input}") //api/ravi
	//@ResponseBody
	
	public String printMessage(@PathVariable String input) {
		
		return "Welcome "+input+"..........!!!!";
	}
}
