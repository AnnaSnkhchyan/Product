package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Category;

public interface CategoryService {
	
	public abstract void create(Category category);
	
	public abstract Category find(int id);
	
	public abstract void update(Category category);
	
	public abstract void delete(int id);
	
	public abstract Page<Category> findAll(MyCustomPage pageable);

	
}
