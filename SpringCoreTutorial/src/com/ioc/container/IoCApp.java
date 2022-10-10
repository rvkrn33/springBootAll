package com.ioc.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCApp {
	
	public static void main(String[] ar) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("coreSpring.xml");
		System.out.println("Application loaded ");
		
		Employee em1 = (Employee) ctx.getBean("emp");
		Employee em2 = (Employee) ctx.getBean("emp");
		
		System.out.println("Address --> "+em1.hashCode()+"-"+em1.getAddress().hashCode());
		System.out.println("Address --> "+em2.hashCode()+"-"+em2.getAddress().hashCode());
		
		Address ad1= (Address) ctx.getBean("add");
		Address ad2= (Address) ctx.getBean("add");
		System.out.println("Ad --> "+ad1.hashCode()+" - "+ad2.hashCode());
		
		Employee e = (Employee) ctx.getBean("emp");
		System.out.println("Emp1: "+e.hashCode());
		
		Employee e2 = (Employee) ctx.getBean("emp");
		System.out.println("Emp2: "+e2.hashCode());
		
		Employee e3 = (Employee) ctx.getBean("emp");
		System.out.println("Emp3: "+e3.hashCode());
		
		System.out.println("Employee Name :: "+e.toString());
		
		
		CollectionSample sample=(CollectionSample) ctx.getBean("collectionBean");
		sample.getAddressList();
		sample.getAddressSet();
		sample.getAddressMap();
		sample.getAddressProp();
	}
	
}
