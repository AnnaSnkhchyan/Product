package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.CategoryTranslation;
import com.luv2code.springdemo.entity.CategoryTranslationId;
import com.luv2code.springdemo.service.CategoryTranslationService;

@RestController
@RequestMapping("/api")
public class CategoryTranslationRestController {

	@Autowired
	private CategoryTranslationService categoryTranslationService;
	
	@GetMapping("/categoryTranslations")
	public Page<CategoryTranslation> find(Pageable pageable){
		
		return categoryTranslationService.findAll(pageable);
	}
	
	
	@GetMapping("/categoryTranslations/filter")
	//@PreAuthorize(value= "hasRole('USER')")
	public CategoryTranslation findByTypeAndLanguagecode(@RequestParam Integer type, 
			@RequestParam String languageCode) {
		
		CategoryTranslation categoryTranslation = categoryTranslationService
				.findByTypeAndLanguageCode(type,languageCode);
		return categoryTranslation;
	}
	
	
	@PostMapping("/categoryTranslations")
	public CategoryTranslation create(@RequestBody CategoryTranslation categoryTranslation) {
		
		CategoryTranslationId id = new CategoryTranslationId(0, null);
		categoryTranslation.setId(id);
		
		categoryTranslationService.create(categoryTranslation);
		
		return categoryTranslation;
	}
	
	@PutMapping("/categoryDescriptions")
	public CategoryTranslation update(@RequestBody CategoryTranslation categoryTranslation) {
		
		categoryTranslationService.update(categoryTranslation);
		
		return categoryTranslation;
	}
	
	@DeleteMapping("/categoryTranslations/filter")
	public String delete(@RequestParam Integer type, 
			@RequestParam String languageCode) {
				
		categoryTranslationService.delete(type, languageCode);
		return "Deleted categoryTranslation id - " + type + languageCode;
		
	}
}




