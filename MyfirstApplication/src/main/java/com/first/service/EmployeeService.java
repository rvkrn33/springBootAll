package com.first.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.first.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
}
