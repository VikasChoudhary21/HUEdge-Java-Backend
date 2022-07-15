package com.service.catalog.service;

import java.util.List;
import java.util.Optional;

import com.service.catalog.entity.Product;

public interface ProductService {
	public List<Product> getAllProduct();
    public List<Product> getAllProductByCategory(String category);
    public List<Product> getAllProductByCategorySorted(String category);
    public Optional<Product> getProductById(Integer id);
    public List<Product> getAllProductsByName(String name);
    public Product addProduct(Product product);
    public void deleteProduct(Integer productId);
}
