package com.example.coffeeshop.service;

import java.util.List;

import com.example.coffeeshop.dto.OrderResponse;
import com.example.coffeeshop.exception.CoffeeShopBaseException;

public interface OrderService {
	public List<OrderResponse> retriveOrders(String userId) throws CoffeeShopBaseException;

	public OrderResponse retriveOrderDetails(String userId, String orderId) throws CoffeeShopBaseException;
}
