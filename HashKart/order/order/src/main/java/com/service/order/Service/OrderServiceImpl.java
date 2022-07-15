package com.service.order.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.order.Entity.Order;
import com.service.order.Repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repo;
	
	@Override
	public Order addOrder(Order order) {
		return repo.save(order);
	}

	@Override
	public List<Order> getOrdersForUserId(Integer userId) {
		List<Order> orders = repo.findAllByUserId(userId);
		return orders;
	}

}
