package com.luv2code.springdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.repository.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userJpaRepository; 
	
	@Transactional
	public void create(User user) {
		userJpaRepository.saveAndFlush(user);
	}
	
	@Transactional
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
	
	@Transactional 
	public Page<User> findAll(Pageable pageable){
		return userJpaRepository.findAll(pageable);
	}
	}

