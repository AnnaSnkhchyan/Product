package com.luv2code.springdemo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.Category;

public interface CategoryService {
	
	public abstract void create(Category category);
	
	public abstract Category find(int id);
	
	public abstract void update(Category category);
	
	public abstract void delete(int id);
	
	public abstract Page<Category> findAll(Pageable pageable);
}
