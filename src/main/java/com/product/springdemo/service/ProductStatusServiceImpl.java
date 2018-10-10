package com.product.springdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.ProductStatus;
import com.product.springdemo.repository.ProductStatusJpaRepository;


@Service
public class ProductStatusServiceImpl implements ProductStatusService {
	
	@Autowired
	private ProductStatusJpaRepository productStatusJpaRepository; 
	
	@Transactional
	public void create(ProductStatus productStatus) {
		productStatusJpaRepository.saveAndFlush(productStatus);
	}
	
	@Transactional(readOnly = true) 
	public ProductStatus find(int id) {
		return productStatusJpaRepository.findById(id).get();
	}
	
	@Transactional
	public void update(ProductStatus productStatus) {
		productStatusJpaRepository.saveAndFlush(productStatus);
	}
	
	@Transactional
	public void delete(int id) {
		productStatusJpaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)  
	public Page<ProductStatus> findAll(MyCustomPage pageable){
		return productStatusJpaRepository.findAll(pageable);
	}
}
