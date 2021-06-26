package com.example.controller.junit4;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.controller.EmployeeController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=EmployeeController.class)
class EmployeeControllerTestSpringRunner {

	MockMvc mockMvc;
	
	@InjectMocks
	EmployeeController empController;
	
	/*
	 * @BeforeEach public void setup() { mockMvc =
	 * MockMvcBuilders.standaloneSetup(empController).build();
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetEmp() throws Exception {
	 * 
	 * mockMvc.perform(get("/api/employee")).andExpect(status().isOk())
	 * .andExpect(jsonPath("$.name").value("ravi"))
	 * .andExpect(jsonPath("$.city").value("pune"));
	 * 
	 * }
	 */

}
