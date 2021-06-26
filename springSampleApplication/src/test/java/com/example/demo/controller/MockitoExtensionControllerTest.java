package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Emp;

@ExtendWith(MockitoExtension.class)
class MockitoExtensionControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Autowired
	MockMvc mockMvc;
	
    @BeforeEach 
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

    }
    
	@Test
	public void testGetEmp() throws Exception {
		
		 mockMvc.perform(get("/api/employee"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.name").value("ravi"))
		 .andExpect(jsonPath("$.city").value("pune"));
		
	}
	
	 @Test
	    public void testPostEmployee() throws Exception {
	    
	    	Emp emp=new Emp();
	    	emp.setCity("pune");
	    	emp.setName("ravi");
	    	
	    	JSONObject j=new JSONObject();
	    	j.put("emp", emp);
	    	
	    	this.mockMvc.perform(post("/create/employee")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(j.toString()))
	                .andExpect(status().isCreated());
		    
	    }

}
