package com.order.service;

import org.springframework.stereotype.Service;

import com.order.model.Product;

public interface OrderService {

	public Product getProductDetails(int productId);

}
