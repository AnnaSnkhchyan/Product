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

import com.luv2code.springdemo.entity.Language;
import com.luv2code.springdemo.service.LanguageService;

@RestController
@RequestMapping("/api")
public class LanguageRestController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/languages")
	public Page<Language> find(Pageable pageable){
		
		return languageService.findAll(pageable);
	}
	
	
	@GetMapping ("/languages/{languageCode}")
	public Language find(@PathVariable String languageCode) {
		
		Language language = languageService.find(languageCode);
		
		return language;
		
	}
	
	@PostMapping("/languages")
	public Language create(@RequestBody Language language) {
		
		language.setCode(null);
		
		languageService.create(language);
		
		return language;
	}
	
	@PutMapping("/languages")
	public Language update(@RequestBody Language language) {
		
		languageService.update(language);
		
		return language;
	}
	
	@DeleteMapping("/languages/{languageCode}")
	public String delete(@PathVariable String languageCode) {
				
		languageService.delete(languageCode);
		return "Deleted language code - " + languageCode;
		
	}
}




