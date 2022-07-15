package com.service.order.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.order.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findAllByUserId(Integer userId);
	
}