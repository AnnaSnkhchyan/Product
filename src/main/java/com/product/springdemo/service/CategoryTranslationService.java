package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.CategoryTranslation;

public interface CategoryTranslationService {

public void create(CategoryTranslation categoryTranslation);
    
	public void update(CategoryTranslation categoryTranslation);
	
	public void delete(Integer type, String languageCode);
	
	public Page<CategoryTranslation> findAll(MyCustomPage pageable);

	public CategoryTranslation findByTypeAndLanguageCode(Integer type, String languageCode);
}
