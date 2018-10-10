package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Language;

public interface LanguageService {

	public void create(Language language);

	public Language find(String code);
	
	public void update(Language language);
	
	public void delete(String code);
	
	public Page<Language> findAll(MyCustomPage pageable);
}
