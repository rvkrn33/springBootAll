package com.order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.model.Product;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Override
	public Product getProductDetails(int productId) {
		RestTemplate restTemplate =new RestTemplate();
		String url="http://localhost:8081/product/"+productId;
		//service to Service call 
		Product resp =restTemplate.getForObject(url, Product.class);
		
		return resp;
	}
	
	

}
