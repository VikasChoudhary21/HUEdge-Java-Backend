package com.service.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.catalog.entity.Product;

public interface productrepository extends JpaRepository<Product, Integer> {
	public List<Product> findAllByCategory(String category);
	public List<Product> findAllByCategoryOrderByCategoryDesc(String category);
    public List<Product> findAllByProductName(String name);
}
