package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Page<User> find(Pageable pageable){
		
		return userService.findAll(pageable);
	}
	
	@GetMapping ("/users/{userUsername}")
	public User find(@PathVariable String userUsername) {
		
		User user = userService.find(userUsername);
		
		return user;
		
	}
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		
		user.setUserName(null);
		
		userService.create(user);
		
		return user;
	}
	
	@PutMapping("/users")
	public User update(@RequestBody User user) {
		
		userService.update(user);
		
		return user;
	}
	
	@DeleteMapping("/users/{userUsername}")
	public String delete(@PathVariable String userUsername) {
				
		userService.delete(userUsername);
		return "Deleted category username - " + userUsername;
		
	}
}




