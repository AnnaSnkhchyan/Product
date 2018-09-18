package com.luv2code.springdemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.CategoryTranslation;
import com.luv2code.springdemo.entity.CategoryTranslationId;

@Repository
@Transactional
public interface CategoryTranslationJpaRepository extends JpaRepository<CategoryTranslation, CategoryTranslationId> {

//	Optional<CategoryTranslation> findByTypeAndLanguageCode(int type, String languageCode);
}
