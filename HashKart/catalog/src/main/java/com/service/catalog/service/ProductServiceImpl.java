package com.service.catalog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catalog.entity.Product;
import com.service.catalog.repository.productrepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private productrepository repo;

    @Override
    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        return repo.findAllByCategory(category);
    }
    
    @Override
    public List<Product> getAllProductByCategorySorted(String category) {
        return repo.findAllByCategoryOrderByCategoryDesc(category);
    }


    @Override
    public Optional<Product> getProductById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public List<Product> getAllProductsByName(String name) {
        return repo.findAllByProductName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        repo.deleteById(productId);
    }
}