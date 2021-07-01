package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerExtTest {

	@InjectMocks
	CustomerController customerController;
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CustomerService customerService;
	
    @BeforeEach 
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }
    
	
	@Test
	void testGetEmp() {
		
		List<Customer> list=new ArrayList();
		list.add(new Customer("ravi","pune"));
		
		Mockito.when(customerService.getAllCustomers()).thenReturn(list);
		
		Customer cust=customerController.getEmp().get(0);
		
		//assertTrue(null!=customerController.getEmp());
		assertEquals(1, customerController.getEmp().size());
		//assertEquals("ravi", cust.getName());
		
		verify(customerService, times(2)).getAllCustomers();
		
		
		
	}

}
