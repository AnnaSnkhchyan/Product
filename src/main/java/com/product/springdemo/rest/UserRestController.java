package com.product.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.User;
import com.product.springdemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Page<User> find(MyCustomPage pageable){
		
		return userService.findAll(pageable);
	}
	
	@GetMapping ("/users/{userUsername}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public User find(@PathVariable String userUsername) {
		
		User user = userService.find(userUsername);
		
		return user;
		
	}
	
	@PostMapping("/users")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public User create(@RequestBody User user) {
		
		userService.create(user);
		
		return user;
	}
	
	@PutMapping("/users/{userUsername}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public User update(@RequestBody User user, @PathVariable String userUsername) {
		
		User updatedUser = userService.find(userUsername);
		updatedUser.setAuthority(user.getAuthority());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setUserName(user.getUserName());
		
		userService.update(updatedUser);
		
		return updatedUser;
	}
	
	@DeleteMapping("/users/{userUsername}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@PathVariable String userUsername) {
				
		userService.delete(userUsername);
		return "Deleted category username - " + userUsername;
		
	}
}




