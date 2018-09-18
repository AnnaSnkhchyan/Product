package com.luv2code.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.Product;

public interface ProductService {

public void create(Product product);
	
	public Product find(int id);
	
	public void update(Product product);
	
	public void delete(int id);
	
	public Page<Product> findAll(Pageable pageabe);
	
}
