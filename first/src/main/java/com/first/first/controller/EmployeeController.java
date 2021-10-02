package com.first.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

	@GetMapping("/")
	@ResponseBody
	public String home() {
		System.out.println("Request processing .......");
		return "Welcome ........";
	}
	
	@GetMapping("/{name}")
	@ResponseBody
	public String getName(@PathVariable String name) {
		System.out.println("Request processing ......."+name);
		return "Welcome "+name;
	}
}
