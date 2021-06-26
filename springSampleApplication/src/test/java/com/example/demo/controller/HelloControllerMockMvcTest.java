package com.example.demo.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Emp;


@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/employee"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("ravi"))
        		    .andExpect(jsonPath("$.city").value("pune"));
        		
    }
    
    @Test
    public void testPathVariable() throws Exception {
        this.mockMvc.perform(get("/emp/2"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("John"))
    				.andReturn();
        		
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