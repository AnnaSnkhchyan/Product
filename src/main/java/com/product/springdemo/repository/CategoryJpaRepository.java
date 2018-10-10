package com.product.springdemo.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.springdemo.entity.Category;


@Repository
@Transactional
public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {

	
}
