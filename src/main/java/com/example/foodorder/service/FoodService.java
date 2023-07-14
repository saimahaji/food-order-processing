package com.example.foodorder.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodorder.model.Cart;
import com.example.foodorder.model.Category;
import com.example.foodorder.model.FoodAppUser;
import com.example.foodorder.model.OrderHistory;
import com.example.foodorder.model.ResponseMessage;
import com.example.foodorder.repository.CartRepository;
import com.example.foodorder.repository.CategoryRepository;
import com.example.foodorder.repository.OrderHistoryRepository;
import com.example.foodorder.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class FoodService {

	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	OrderHistoryRepository orderRepo;

	public Optional<Category> getItem(Integer id) {
		return categoryRepo.findById(id);
	}

	public Map<String, List<Category>> getAllMenus() {
		List<Category> allMenus = categoryRepo.findAll();
		Map<String, List<Category>> menuMap = allMenus.stream().filter(f -> f.getQuantity() > 0)
				.collect(Collectors.groupingBy(Category::getSub_category));
		menuMap.put("All", allMenus);
		return menuMap;
	}

	public Optional<FoodAppUser> getUser(Integer id) {
		return userRepo.findById(id);
	}

	@Transactional
	public ResponseMessage checkoutCart(Cart data, int userid) {
		ResponseMessage response = new ResponseMessage();
		List<Category> orderMenus = data.getCat_id();
		List<Category> allMenus = categoryRepo.findAll();

		int total = 0;
		int quantity = 0;

		for (Category c : orderMenus) {
			Optional<Category> findFirst = allMenus.stream()
					.filter(f -> f.getCid() == c.getCid() && f.getQuantity() < c.getQuantity()).findFirst();
			if (findFirst.isPresent()) {
				response.setStatus("failed");
				response.setSuccessCode(500);
				response.setMessage(findFirst.get().getCname() + " not available in required quantity.");
				return response;
			} else {
				// reduce quantity from DB
				Optional<Category> order = allMenus.stream().filter(f -> f.getCid() == c.getCid()).findFirst();
				if (order.isPresent()) {
					c.setQuantity(order.get().getQuantity() - c.getQuantity());
					c.setDescription(order.get().getDescription());
					c.setPrice(order.get().getPrice());
					c.setStatus(order.get().getStatus());
					c.setSub_category(order.get().getSub_category());
					if (c.getQuantity() == 0) {
						c.setStatus("N");
					}
					categoryRepo.save(c);

					total += order.get().getPrice();
					quantity += order.get().getQuantity();
					data.setTotal(total);
					data.setQuantity(quantity);

				}

			}

		}
		if (null == response.getStatus() || !response.getStatus().equalsIgnoreCase("failed")) {
			updateOrderHistory(data, userid);
		}
		response.setStatus("success");
		response.setMessage("Ordered Successfully");
		response.setSuccessCode(200);

		return response;
	}

	private void updateOrderHistory(Cart data, int userid) {
		Optional<FoodAppUser> user = userRepo.findById(userid);
		OrderHistory order = new OrderHistory();
		order.setCat_id(data.getCat_id());
		order.setQuantity(data.getQuantity());
		order.setTotal(data.getTotal());
		order.setUser_id(user.get());
		order.setAddress(user.get().getDef_add());
		order.setOrder_date(LocalDate.now());
		order.setStatus("Ordered");
		orderRepo.save(order);

	}

	public OrderHistory getOrderHistory(Integer userid) {
		return orderRepo.findByUserId(userid);
	}

}
