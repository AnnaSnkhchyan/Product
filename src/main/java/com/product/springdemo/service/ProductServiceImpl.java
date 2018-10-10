package com.product.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Product;
import com.product.springdemo.repository.ProductJpaRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductJpaRepository productJpaRepository; 
	
	@Transactional
	public void create(Product product) {
		productJpaRepository.saveAndFlush(product);
	}
	
	@Transactional(readOnly = true) 
	public Product find(int id) {
		return productJpaRepository.findById(id).get();
	}
	
	@Transactional
	public void update(Product product) {
		productJpaRepository.saveAndFlush(product);
	}
	
	@Transactional
	public void delete(int id) {
		productJpaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)  
	public Page<Product> findAll(MyCustomPage pageable){
		return productJpaRepository.findAll(pageable);
	}
	
}
