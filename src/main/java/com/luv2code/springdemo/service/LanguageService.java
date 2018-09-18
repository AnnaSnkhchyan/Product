package com.luv2code.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.Language;

public interface LanguageService {

	public void create(Language language);

	public Language find(String code);
	
	public void update(Language language);
	
	public void delete(String code);
	
	public Page<Language> findAll(Pageable pageable);
}
