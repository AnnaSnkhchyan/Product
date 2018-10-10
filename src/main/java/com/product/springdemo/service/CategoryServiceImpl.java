package com.product.springdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Category;
import com.product.springdemo.repository.CategoryJpaRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryJpaRepository categoryJpaRepository; 
	
	@Transactional
	public void create(Category category) {
		categoryJpaRepository.saveAndFlush(category);
	}
	
	@Transactional(readOnly = true)
	public Category find(int id) {
		
		return categoryJpaRepository.findById(id).get();
	}
	
	@Transactional
	public void update(Category category) {
		categoryJpaRepository.saveAndFlush(category);
	}
	
	@Transactional
	public void delete(int id) {
		categoryJpaRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true) 
	public Page<Category> findAll(MyCustomPage pageable){
		return categoryJpaRepository.findAll(pageable);
	}
}
