package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		int a=5;
		int b=5;
		int result=(a+b);
		
		assertEquals(10, result);
	}

	
	    @Test
	  public void testGetAllCustomers() throws Exception {
        this.mockMvc.perform(get("/getCustomer/3"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("ajit"))
        		    .andExpect(jsonPath("$.address").value("Goa"));
        		
	    }
}
