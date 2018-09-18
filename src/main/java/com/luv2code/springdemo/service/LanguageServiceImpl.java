package com.luv2code.springdemo.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.luv2code.springdemo.entity.Language;
import com.luv2code.springdemo.repository.LanguageJpaRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageJpaRepository languageJpaRepository;
	
	@Transactional
	public void create(Language language) {
		languageJpaRepository.saveAndFlush(language);
	}
	
	@Transactional
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
	
	@Transactional 
	public Page<Language> findAll(Pageable pageable){
		return languageJpaRepository.findAll(pageable);
	}
}
