package com.service.user.service;

import java.util.Map;


import com.service.user.entity.CartItem;


public interface CartItemService {
	
		public Map<Integer, Integer> getCartByUserId(Integer userId);
		public String addToCart(CartItem cartItem);
		public String removeFromCart(Integer userId);
}
