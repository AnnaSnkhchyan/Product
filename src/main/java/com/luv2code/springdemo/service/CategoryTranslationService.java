package com.luv2code.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.CategoryTranslation;

public interface CategoryTranslationService {

public void create(CategoryTranslation categoryTranslation);
    
	public void update(CategoryTranslation categoryTranslation);
	
	public void delete(Integer type, String languageCode);
	
	public Page<CategoryTranslation> findAll(Pageable pageable);

	public CategoryTranslation findByTypeAndLanguageCode(Integer type, String languageCode);
}
