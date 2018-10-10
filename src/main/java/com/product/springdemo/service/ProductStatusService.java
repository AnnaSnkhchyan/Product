package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.ProductStatus;

public interface ProductStatusService {

public void create(ProductStatus productStatus);
	
	public ProductStatus find(int id);
	
	public void update(ProductStatus productStatus);
	
	public void delete(int id);
	
	public Page<ProductStatus> findAll(MyCustomPage pageable);
}
