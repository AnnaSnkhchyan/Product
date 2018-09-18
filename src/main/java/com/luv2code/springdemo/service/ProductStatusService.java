package com.luv2code.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.ProductStatus;

public interface ProductStatusService {

public void create(ProductStatus productStatus);
	
	public ProductStatus find(int id);
	
	public void update(ProductStatus productStatus);
	
	public void delete(int id);
	
	public Page<ProductStatus> findAll(Pageable pageable);
}
