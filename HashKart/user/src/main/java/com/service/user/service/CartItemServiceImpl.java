package com.service.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.user.entity.CartItem;
import com.service.user.repository.CartItemRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	CartItemRepository repo;

	@Override
	public Map<Integer, Integer> getCartByUserId(Integer userId) {
		List<CartItem> li = repo.findAllByUserId(userId);
		Map<Integer, Integer> cartProductDetails = new HashMap<>();
		li.forEach((c)->cartProductDetails.put(c.getProductId(),c.getQuantity()));
		return cartProductDetails;
	}

	@Override
	public String addToCart(CartItem cartItem) {
		repo.save(cartItem);
		return "Modified Successfully";
	}

	@Override
	public String removeFromCart(Integer userId) {
		List<CartItem> cart = repo.findAllByUserId(userId);
		cart.forEach((item)->repo.delete(item));
		return "Items removed from cart";
	}

}
