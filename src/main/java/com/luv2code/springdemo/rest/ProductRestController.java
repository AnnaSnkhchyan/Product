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

import com.luv2code.springdemo.entity.Product;
import com.luv2code.springdemo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public Page<Product> find(Pageable pageable){
		
		return productService.findAll(pageable);
	}
	
	
	
	@GetMapping ("/products/{productId}")
	public Product find(@PathVariable int productId) {
		
		Product product = productService.find(productId);
		
		return product;
		
	}
	
	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		
		product.setId(0);
		
		productService.create(product);
		
		return product;
	}
	
	@PutMapping("/products")
	public Product update(@RequestBody Product product) {
		
		productService.update(product);
		
		return product;
	}
	
	
	@DeleteMapping("/products/{productId}")
	public String delete(@PathVariable int productId) {
				
		productService.delete(productId);
		return "Deleted product id - " + productId;
		
	}
	
	
}




