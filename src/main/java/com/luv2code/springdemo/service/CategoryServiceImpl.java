package com.luv2code.springdemo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.entity.Category;
import com.luv2code.springdemo.repository.CategoryJpaRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryJpaRepository categoryJpaRepository; 
	
	@Transactional
	public void create(Category category) {
		categoryJpaRepository.saveAndFlush(category);
	}
	
	@Transactional
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
	
	@Transactional 
	public Page<Category> findAll(Pageable pageable){
		return categoryJpaRepository.findAll(pageable);
	}
}
