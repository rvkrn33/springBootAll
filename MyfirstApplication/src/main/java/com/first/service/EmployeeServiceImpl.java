package com.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.first.model.Employee;

//@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList();
		
		  list.add(new Employee("ravi",7854123698l)); 
		  list.add(new Employee("ajit",7854123698l)); 
		  list.add(new Employee("amar",7854123698l));
		  list.add(new Employee("sham",7854123698l));
		 
		return list;
	}

}
