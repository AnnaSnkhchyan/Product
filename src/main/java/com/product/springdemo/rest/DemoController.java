package com.product.springdemo.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class DemoController {

	@GetMapping("/")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public String showHome() {
		
		return "home";
	}
}
