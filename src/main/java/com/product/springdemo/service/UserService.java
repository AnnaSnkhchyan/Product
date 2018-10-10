package com.product.springdemo.service;

import org.springframework.data.domain.Page;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.User;

public interface UserService {
	
	public abstract void create(User user);
	
	public abstract User find(String userUsername);
	
	public abstract void update(User user);
	
	public abstract void delete(String userName);
	
	public abstract Page<User> findAll(MyCustomPage pageable);
}
