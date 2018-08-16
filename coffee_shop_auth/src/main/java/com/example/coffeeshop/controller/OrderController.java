package com.example.coffeeshop.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffeeshop.dto.OrderResponse;
import com.example.coffeeshop.exception.CoffeeShopBaseException;
import com.example.coffeeshop.model.CustomResponse;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.utils.ResponseBuilder;

@RestController
@RequestMapping(path = "/coffeeshop/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private ResponseBuilder<OrderResponse> responseBuilder;

	@RequestMapping(value = "/orders/{userId}", method = RequestMethod.GET)
	public ResponseEntity<CustomResponse<OrderResponse>> retriveProducts(@PathVariable String userId)
			throws CoffeeShopBaseException {
		logger.info("Entered in method-retriveProducts of class-ProductController at {}", System.currentTimeMillis());
		return ResponseEntity.ok()
				.body(responseBuilder.buildResponse(this.orderService.retriveOrders(userId), Collections.emptyList()));
	}

	@RequestMapping(value = "/orders/{userId}/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<CustomResponse<OrderResponse>> retriveProductDetails(@PathVariable String userId,
			@PathVariable String orderId) throws CoffeeShopBaseException {
		logger.info("Entered in method-retriveProductDetails of class-ProductController at {}",
				System.currentTimeMillis());
		logger.debug("input payload: {}, {}", userId, orderId);
		return ResponseEntity.ok()
				.body(responseBuilder.buildResponse(
						Collections.singletonList(this.orderService.retriveOrderDetails(userId, orderId)),
						Collections.emptyList()));
	}
}
