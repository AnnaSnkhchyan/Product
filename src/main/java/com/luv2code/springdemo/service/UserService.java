package com.luv2code.springdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.luv2code.springdemo.entity.User;

public interface UserService {
	
	public abstract void create(User user);
	
	public abstract User find(String userUsername);
	
	public abstract void update(User user);
	
	public abstract void delete(String userName);
	
	public abstract Page<User> findAll(Pageable pageable);
}
