package com.luv2code.springdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.luv2code.springdemo.entity.ProductStatus;
import com.luv2code.springdemo.repository.ProductStatusJpaRepository;


@Service
public class ProductStatusServiceImpl implements ProductStatusService {
	
	@Autowired
	private ProductStatusJpaRepository productStatusJpaRepository; 
	
	@Transactional
	public void create(ProductStatus productStatus) {
		productStatusJpaRepository.saveAndFlush(productStatus);
	}
	
	@Transactional
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
	
	@Transactional 
	public Page<ProductStatus> findAll(Pageable pageable){
		return productStatusJpaRepository.findAll(pageable);
	}
}
