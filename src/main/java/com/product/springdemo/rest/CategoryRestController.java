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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.springdemo.config.MyCustomPage;
import com.product.springdemo.entity.Category;
import com.product.springdemo.entity.CategoryTranslation;
import com.product.springdemo.entity.CategoryTranslationId;
import com.product.springdemo.service.CategoryService;
import com.product.springdemo.service.CategoryTranslationService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryTranslationService categoryTranslationService;
	
	@GetMapping("/categories")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public Page<Category> find(MyCustomPage pageable){
		
		return categoryService.findAll(pageable);
	}
	
	@GetMapping ("/categories/{categoryId}")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public Category find(@PathVariable int categoryId) {
		
		Category category = categoryService.find(categoryId);
		
		return category;
		
	}
	
	@PostMapping("/categories")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Category create(@RequestBody Category category) {
		
		category.setId(0);
		
		categoryService.create(category);
		
		return category;
	}
	
	@PostMapping("/categories/categoryTranslations")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public CategoryTranslation create(@RequestBody CategoryTranslation categoryTranslation) {
		
		CategoryTranslationId id = new CategoryTranslationId(0, null);
		categoryTranslation.setId(id);
		
		categoryTranslationService.create(categoryTranslation);
		
		return categoryTranslation;
	}
	
	
	@PutMapping("/categories/{categoryId}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Category update(@RequestBody Category category, @PathVariable int categoryId) {
		
		Category updatedCategory = categoryService.find(categoryId);

		updatedCategory.setProducts(category.getProducts());
		updatedCategory.setCategoryTranslations(category.getCategoryTranslations());
		
		categoryService.update(updatedCategory);
		
		return updatedCategory;
	}
	
	@PutMapping("/categories/categoryTranslations/filter")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public CategoryTranslation update(@RequestBody CategoryTranslation categoryTranslation, @RequestParam Integer type, 
			@RequestParam String languageCode) {
		
		CategoryTranslation updatedCategoryTranslation = categoryTranslationService
				.findByTypeAndLanguageCode(type,languageCode);
		
		updatedCategoryTranslation.setTitle(categoryTranslation.getTitle());
		categoryTranslationService.update(updatedCategoryTranslation);
		
		return updatedCategoryTranslation;
	}
	
	@DeleteMapping("/categories/{categoryId}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@PathVariable int categoryId) {
				
		categoryService.delete(categoryId);
		return "Deleted category id - " + categoryId;
		
	}
	

	@DeleteMapping("/categories/categoryTranslations/filter")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@RequestParam Integer type, 
			@RequestParam String languageCode) {
				
		categoryTranslationService.delete(type, languageCode);
		return "Deleted categoryTranslation id - " + type + languageCode;
		
	}
}




