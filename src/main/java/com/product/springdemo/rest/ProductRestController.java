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
import com.product.springdemo.entity.Product;
import com.product.springdemo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public Page<Product> find(MyCustomPage pageable){
		
		return productService.findAll(pageable);
	}
	
	
	
	@GetMapping ("/products/{productId}")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public Product find(@PathVariable int productId) {
		
		Product product = productService.find(productId);
		
		return product;
		
	}
	
	@PostMapping("/products")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Product create(@RequestBody Product product) {
		
		product.setId(0);
		
		productService.create(product);
		
		return product;
	}
	
	@PutMapping("/products/{productId}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public Product update(@RequestBody Product product, @PathVariable int productId) {
		
		Product updatedProduct = productService.find(productId);
		updatedProduct.setCode(product.getCode());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setProductStatus(product.getProductStatus());
		
		productService.update(updatedProduct);
		
		return updatedProduct;
	}
	
	
	
	
	@DeleteMapping("/products/{productId}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@PathVariable int productId) {
				
		productService.delete(productId);
		return "Deleted product id - " + productId;
		
	}
	
	
}




