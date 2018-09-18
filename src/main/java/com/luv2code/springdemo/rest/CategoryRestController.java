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

import com.luv2code.springdemo.entity.Category;
import com.luv2code.springdemo.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public Page<Category> find(Pageable pageable){
		
		return categoryService.findAll(pageable);
	}
	
	@GetMapping ("/categories/{categoryId}")
	public Category find(@PathVariable int categoryId) {
		
		Category category = categoryService.find(categoryId);
		
		return category;
		
	}
	
	@PostMapping("/categories")
	public Category create(@RequestBody Category category) {
		
		category.setId(0);
		
		categoryService.create(category);
		
		return category;
	}
	
	@PutMapping("/categories")
	public Category update(@RequestBody Category category) {
		
		categoryService.update(category);
		
		return category;
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String delete(@PathVariable int categoryId) {
				
		categoryService.delete(categoryId);
		return "Deleted category id - " + categoryId;
		
	}
}




