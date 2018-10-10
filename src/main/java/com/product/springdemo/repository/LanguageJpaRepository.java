package com.product.springdemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.springdemo.entity.Language;

@Repository
@Transactional
public interface LanguageJpaRepository extends JpaRepository<Language, String> {

	
}
