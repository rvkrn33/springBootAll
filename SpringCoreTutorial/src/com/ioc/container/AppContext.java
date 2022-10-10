package com.ioc.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("coreSpring2.xml");
		System.out.println("Application loaded ");
		
		Notebook nt= (Notebook) ctx.getBean("note");

	}

}
