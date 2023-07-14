package com.example.foodorder.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.model.Cart;
import com.example.foodorder.model.Category;
import com.example.foodorder.model.CheckoutData;
import com.example.foodorder.model.FoodAppUser;
import com.example.foodorder.model.OrderHistory;
import com.example.foodorder.model.ResponseMessage;
import com.example.foodorder.service.FoodService;

@CrossOrigin
@RestController
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping(path = "/get-all-category")
	private Map<String, List<Category>> getAllMenus() {
		return foodService.getAllMenus();
	}

	@GetMapping(path = "/get-item/{id}")
	private Optional<Category> getItem(@PathVariable Integer id) {
		return foodService.getItem(id);
	}

	@GetMapping(path = "/get-user/{id}")
	private Optional<FoodAppUser> getUser(@PathVariable Integer id) {
		return foodService.getUser(id);
	}

	@PostMapping(path = "/checkout-cart")
	private ResponseMessage checkoutCart(@RequestBody CheckoutData data) {
		return foodService.checkoutCart(data.getCart(), data.getUserid());
	}

	@GetMapping(path = "/get-order-history/{id}")
	private OrderHistory getOrderHistory(@PathVariable Integer id) {
		return foodService.getOrderHistory(id);
	}

}
