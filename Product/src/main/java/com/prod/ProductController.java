package com.prod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	List<Product> list=null;
	
	@GetMapping("/products")
	public List<Product> getAllProd(){
		
		List<Product> list = prepareProduct();
		
		return list;
	}

	
	@GetMapping("/product/{id}/{quantity}")
	public String updateProd(@PathVariable String id, @PathVariable String quantity){
		
		List<Product> list = prepareProduct();
		
		List<Product> list1 =list.stream().filter(s->id.equals(s.getId())).collect(Collectors.toList());
		System.out.println("List1 : "+list1.get(0).getName());
		
		return "Record updated..";
	}
	
	private List<Product> prepareProduct() {
		List<Product> list=new ArrayList();
		list.add(new Product(1, "abc", 5522.66, 500));
		list.add(new Product(15, "dsfsd", 88.66, 501));
		list.add(new Product(155, "aggbc", 6666.66, 400));
		list.add(new Product(12, "ggg", 33.66, 633));
		list.add(new Product(13, "yyy", 999.66, 55));
		return list;
	}
	
	
}
