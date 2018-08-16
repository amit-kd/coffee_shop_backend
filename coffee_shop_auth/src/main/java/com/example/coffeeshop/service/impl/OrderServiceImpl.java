package com.example.coffeeshop.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffeeshop.dto.OrderResponse;
import com.example.coffeeshop.dto.ProductResponse;
import com.example.coffeeshop.entity.Order;
import com.example.coffeeshop.entity.Product;
import com.example.coffeeshop.entity.User;
import com.example.coffeeshop.entity.UserOrder;
import com.example.coffeeshop.exception.CoffeeShopBaseException;
import com.example.coffeeshop.repository.OrderRepo;
import com.example.coffeeshop.repository.UserOrderRepo;
import com.example.coffeeshop.repository.UserRepo;
import com.example.coffeeshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepo orderRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserOrderRepo userOrderRepo;

	@Override
	public List<OrderResponse> retriveOrders(String userId) throws CoffeeShopBaseException {
		List<OrderResponse> orderResponses = new ArrayList<>();
		User user = userRepo.findById(Long.valueOf(userId));
		if (user == null) {
			throw new CoffeeShopBaseException();
		}
		user.getOrders().forEach(order -> orderResponses.add(this.mapOrderToDTO(order)));
		return orderResponses;
	}

	@Override
	public OrderResponse retriveOrderDetails(String userId, String orderId) throws CoffeeShopBaseException {
		UserOrder userOrder = userOrderRepo.findByIdAndOrderId(Long.valueOf(userId), Long.valueOf(orderId));
		if (userOrder == null) {
			throw new CoffeeShopBaseException();
		}
		Order order = orderRepo.findById(Long.valueOf(orderId));
		if (order == null) {
			throw new CoffeeShopBaseException();
		}
		return this.mapOrderToDTO(order);
	}

	private OrderResponse mapOrderToDTO(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		List<ProductResponse> productResponses = new ArrayList<>();
		String datePattern = "yyyy-MM-dd";
		String timePattern = "HH:mm:ss";
		String date = new SimpleDateFormat(datePattern).format(new Date(order.getOrderDateTime().getTime()));
		String time = new SimpleDateFormat(timePattern).format(new Date(order.getOrderDateTime().getTime()));
		orderResponse.setDate(date);
		orderResponse.setTime(time);
		orderResponse.setId(order.getId().toString());
		order.getProducts().forEach(prod -> productResponses.add(this.mapProductToDTO(prod)));
		orderResponse.setProducts(productResponses);
		orderResponse.setStatus(order.getStatus());
		orderResponse.setTotal(order.getTotal());
		return orderResponse;
	}

	private ProductResponse mapProductToDTO(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setCurrentPrice(product.getCurrentPrice().toString());
		productResponse.setDescription(product.getDescription());
		productResponse.setEnjoyedPercentage(product.getEnjoyedPercentage().toString());
		productResponse.setId(product.getId().toString());
		productResponse.setNoOfReviews(product.getNoOfReviews().toString());
		productResponse.setNoOfVotes(product.getNoOfVotes().toString());
		productResponse.setRating(product.getRating().toString());
		productResponse.setStockCount(product.getThresholdStockCount());
		productResponse.setThresholdStockCount(product.getThresholdStockCount());
		productResponse.setTitle(product.getTitle());
		productResponse.setPrivewImages(Arrays.asList(product.getPrivewImages().split(",")));
		return productResponse;
	}

}
