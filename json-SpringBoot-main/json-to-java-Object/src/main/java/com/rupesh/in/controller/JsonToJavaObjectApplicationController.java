package com.rupesh.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rupesh.in.bean.Employee;
import com.rupesh.in.bean.JsonToJavaObjectApplicationBean;

@RestController
public class JsonToJavaObjectApplicationController {

	@Autowired
	JsonToJavaObjectApplicationBean jsonToJavaObjectApplicationBean;
	
	@PostMapping("/post")
	public void postJsonToJavaObject(@RequestBody JsonToJavaObjectApplicationBean body)
	{
		
		jsonToJavaObjectApplicationBean.setEmployee(body.getEmployee());
		jsonToJavaObjectApplicationBean.setName(body.getName());
		jsonToJavaObjectApplicationBean.setManagement(body.getManagement());
		
		System.out.println(">>>>>>>>>> "+body.getName());
		Employee e=body.getEmployee();
		System.out.println("$$$$$$$$  "+e.getDepartment());
		
		
	}
}
