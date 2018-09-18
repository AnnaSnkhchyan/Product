package com.luv2code.springdemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Language;

@Repository
@Transactional
public interface LanguageJpaRepository extends JpaRepository<Language, String> {

	
}
