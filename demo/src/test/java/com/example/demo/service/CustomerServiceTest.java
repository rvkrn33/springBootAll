package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@InjectMocks
    CustomerServiceImpl customerService;
     
    @Mock
    CustomerRepository custRepository;
 
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void testGetCustomerList() {
		
		//Given
		 List<Customer> list = new ArrayList<Customer>();
	     Customer c=new Customer("ravi",7845123265L,"Pune");
	     Customer c1=new Customer("amar",7845123255L,"Mumbai");
	        list.add(c);
	        list.add(c1);
	        
	        when(custRepository.findAll()).thenReturn(list);
	         
	        //test
	        List<Customer> custList = customerService.getCustomerList();
	         
	        assertEquals(2, custList.size());
	       // verify(custRepository, times(5)).findAll();
	}

}
