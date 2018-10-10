package com.product.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Language;
import com.product.springdemo.repository.LanguageJpaRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageJpaRepository languageJpaRepository;
	
	@Transactional
	public void create(Language language) {
		languageJpaRepository.saveAndFlush(language);
	}
	
	@Transactional(readOnly = true) 
	public Language find(String code) {
		return languageJpaRepository.findById(code).get();
	}
	
	@Transactional
	public void update(Language language) {
		languageJpaRepository.saveAndFlush(language);
	}
	
	@Transactional
	public void delete(String code) {
		languageJpaRepository.deleteById(code);
	}
	
    @Transactional(readOnly = true)  
	public Page<Language> findAll(MyCustomPage pageable){
		return languageJpaRepository.findAll(pageable);
	}
}
