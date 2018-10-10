package com.product.springdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.CategoryTranslation;
import com.product.springdemo.entity.CategoryTranslationId;
import com.product.springdemo.repository.CategoryTranslationJpaRepository;


@Service
public class CategoryTranslationServiceImpl implements CategoryTranslationService {

	@Autowired
	private CategoryTranslationJpaRepository categoryTranslationJpaRepository;  
	
	@Transactional
	public void create(CategoryTranslation categoryTranslation) {
		categoryTranslationJpaRepository.saveAndFlush(categoryTranslation);
	}
	
	@Transactional
	public void update(CategoryTranslation categoryTranslation) {
		categoryTranslationJpaRepository.saveAndFlush(categoryTranslation);
	}
	
	@Transactional
	public void delete(Integer type, String languageCode) {
		CategoryTranslationId categoryTranslationId = new CategoryTranslationId(type, languageCode);
		categoryTranslationJpaRepository.deleteById(categoryTranslationId);;
	}
	
	@Transactional(readOnly = true) 
	public Page<CategoryTranslation> findAll(MyCustomPage pageable){
		return categoryTranslationJpaRepository.findAll(pageable);
	}

	@Transactional(readOnly = true) 
	public CategoryTranslation findByTypeAndLanguageCode(Integer type, String languageCode) {
		 CategoryTranslationId categoryTranslationId = new CategoryTranslationId(type, languageCode);
		 Optional <CategoryTranslation> categoryTranslation;
		 categoryTranslation = categoryTranslationJpaRepository.findById(categoryTranslationId);

//		categoryTranslation = categoryTranslationJpaRepository.findByTypeAndLanguageCode(type, languageCode);
		return categoryTranslation.get();
	}

	
}
