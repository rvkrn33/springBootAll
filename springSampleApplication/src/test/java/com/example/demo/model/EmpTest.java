package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmpTest {
	
	private static Emp emp;

	@BeforeAll
	public static void setValues() {
		emp=new Emp();
		System.out.println("Before All--> "+emp.hashCode());
	}
	
	@BeforeEach
	void testCreating() {
		emp=new Emp();
		System.out.println("Before Each--> "+emp.hashCode());
	}
	
	@Test
	@Order(2)
	void testName() {
		System.out.println("test Name-> ");
		emp.setName("Ravi");
		assertEquals("Ravi", emp.getName());
	}

	@Test
	@Order(1)
	void testCity() {
		System.out.println("test City ");
		emp.setCity("Pune");
		assertEquals("Pune", emp.getCity());
	}
	
	@AfterEach
	void testAfter() {
		System.out.println("After Each--> "+emp.hashCode());
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("After All --> "+emp.hashCode());
	}
}
