package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Product;

public interface ProductService {

public void create(Product product);
	
	public Product find(int id);
	
	public void update(Product product);
	
	public void delete(int id);
	
	public Page<Product> findAll(MyCustomPage pageabe);
	
}
