package com.service.order.Service;

import java.util.List;

import com.service.order.Entity.Order;

public interface OrderService {

	public Order addOrder(Order order);
	public List<Order> getOrdersForUserId(Integer userId);
	
}
