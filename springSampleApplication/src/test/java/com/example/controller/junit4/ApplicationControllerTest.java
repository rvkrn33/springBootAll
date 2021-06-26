package com.example.controller.junit4;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Emp;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        EmployeeController controller = new EmployeeController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void addEmployee() throws Exception {
        Emp emp = new Emp();
        emp.setCity("pune");
        emp.setName("ravi");

        mockMvc.perform(MockMvcRequestBuilders.post("/create/employee")
                .content(asJsonString(emp))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"));
    }

    public static String asJsonString(final Object obj) {
        try {
        	System.out.println(".......... "+new ObjectMapper().writeValueAsString(obj));
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}