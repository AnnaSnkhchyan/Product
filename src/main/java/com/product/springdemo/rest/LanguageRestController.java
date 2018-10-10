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
import com.product.springdemo.entity.Language;
import com.product.springdemo.service.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageRestController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/languages")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Page<Language> find(MyCustomPage pageable){
		
		return languageService.findAll(pageable);
	}
	
	
	@GetMapping ("/languages/{languageCode}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Language find(@PathVariable String languageCode) {
		
		Language language = languageService.find(languageCode);
		
		return language;
		
	}
	
	@PostMapping("/languages")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Language create(@RequestBody Language language) {
		
		languageService.create(language);
		
		return language;
	}
	
	@PutMapping("/languages/{languageCode}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Language update(@RequestBody Language language, @PathVariable String languageCode) {
		
		Language updatedLanguage = languageService.find(languageCode);
		updatedLanguage.setCategoryTranslations(language.getCategoryTranslations());
		updatedLanguage.setCode(language.getCode());
		updatedLanguage.setName(language.getName());
		
		languageService.update(updatedLanguage);
		
		return updatedLanguage;
	}
	
	
	@DeleteMapping("/languages/{languageCode}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@PathVariable String languageCode) {
				
		languageService.delete(languageCode);
		return "Deleted language code - " + languageCode;
		
	}
}




