package com.luv2code.springdemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.luv2code.springdemo.entity.CategoryTranslation;
import com.luv2code.springdemo.entity.CategoryTranslationId;
import com.luv2code.springdemo.repository.CategoryTranslationJpaRepository;


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
	
	@Transactional 
	public Page<CategoryTranslation> findAll(Pageable pageable){
		return categoryTranslationJpaRepository.findAll(pageable);
	}

	@Override
	public CategoryTranslation findByTypeAndLanguageCode(Integer type, String languageCode) {
		 CategoryTranslationId categoryTranslationId = new CategoryTranslationId(type, languageCode);
		 Optional <CategoryTranslation> categoryTranslation;
		 categoryTranslation = categoryTranslationJpaRepository.findById(categoryTranslationId);

//		categoryTranslation = categoryTranslationJpaRepository.findByTypeAndLanguageCode(type, languageCode);
		return categoryTranslation.get();
	}

	
}
