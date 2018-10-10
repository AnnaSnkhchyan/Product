package com.product.springdemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.springdemo.entity.CategoryTranslation;
import com.product.springdemo.entity.CategoryTranslationId;

@Repository
@Transactional
public interface CategoryTranslationJpaRepository extends JpaRepository<CategoryTranslation, CategoryTranslationId> {

//	Optional<CategoryTranslation> findByTypeAndLanguageCode(int type, String languageCode);
}
