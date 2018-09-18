package com.luv2code.springdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.luv2code.springdemo.entity.Product;
import com.luv2code.springdemo.repository.ProductJpaRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductJpaRepository productJpaRepository; 
	
	@Transactional
	public void create(Product product) {
		productJpaRepository.saveAndFlush(product);
	}
	
	@Transactional
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
	
	@Transactional 
	public Page<Product> findAll(Pageable pageable){
		return productJpaRepository.findAll(pageable);
	}
	
}
