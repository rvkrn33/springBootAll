package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.model.Product;
import com.order.service.OrderService;

@RestController
class OrderController
{
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order/{productId}")
	public ResponseEntity<Order> getDetails(@PathVariable int productId){
		
		Product p =orderService.getProductDetails(productId);
		
		return new ResponseEntity(p,HttpStatus.OK);
	}
}