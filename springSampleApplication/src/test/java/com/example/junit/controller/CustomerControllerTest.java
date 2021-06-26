package com.example.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.CustomerController;
import com.example.demo.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
class CustomerControllerTest {

	
	MockMvc mockMvc;
	 
    @BeforeEach
    void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
    }
    
    
    @Test
    public void testGetCustomer() throws Exception {
    	mockMvc.perform(get("/cutomer"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("abc"));
    	
    }
    
    
    @Test
    public void testGetCustomerId() throws Exception {
    	
    	mockMvc.perform(get("/cutomer/555"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("xyddz"));
    }
    
    @Test
    public void testCreatedCustomer() throws Exception {
    	
    	Customer cust=new Customer();
    	cust.setName("abc");
    	cust.setCity("pune");
    	
    	JSONObject j=new JSONObject();
    	j.put("cust", cust);
    	System.out.println("json string :: "+j.toString());
    	
    	this.mockMvc.perform(post("/add/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(j.toString()))
                .andExpect(status().isCreated());
    	
    }
}
