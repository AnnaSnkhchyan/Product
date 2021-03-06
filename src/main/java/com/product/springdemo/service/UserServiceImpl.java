package com.product.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.User;
import com.product.springdemo.repository.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userJpaRepository; 
	
	@Transactional
	public void create(User user) {
		userJpaRepository.saveAndFlush(user);
	}
	
	@Transactional(readOnly = true) 
	public User find(String username) {
		return userJpaRepository.findById(username).get();
	}
	
	@Transactional
	public void update(User user) {
		userJpaRepository.saveAndFlush(user);
	}
	
	@Transactional
	public void delete(String username) {
		userJpaRepository.deleteById(username);
	}
	
	@Transactional(readOnly = true)  
	public Page<User> findAll(MyCustomPage pageable){
		return userJpaRepository.findAll(pageable);
	}
	}

