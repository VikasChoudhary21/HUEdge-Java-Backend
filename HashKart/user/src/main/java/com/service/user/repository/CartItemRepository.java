package com.service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.user.entity.CartItem;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	List<CartItem> findAllByUserId(Integer userId);

	CartItem findByUserIdAndProductId(Integer userId, Integer productId);


}
