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
import com.product.springdemo.entity.ProductStatus;
import com.product.springdemo.service.ProductStatusService;

@RestController
@RequestMapping("/api")
public class ProductStatusRestController {

	@Autowired
	private ProductStatusService productStatusService;
	
	@GetMapping("/productStatuses")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public Page<ProductStatus> find(MyCustomPage pageable){
		
		return productStatusService.findAll(pageable);
	}
	
	@GetMapping ("/productStatuses/{productStatusId}")
	@PreAuthorize(value= "hasAnyRole('ADMIN','USER')")
	public ProductStatus find(@PathVariable int productStatusId) {
		
		ProductStatus productStatus = productStatusService.find(productStatusId);
		
		return productStatus;
		
	}
	
	@PostMapping("/productStatuses")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public ProductStatus create(@RequestBody ProductStatus productStatus) {
		
		productStatus.setId(0);
		
		productStatusService.create(productStatus);
		
		return productStatus;
	}
	
	@PutMapping("/productStatuses/{productStatusId}")
	@PreAuthorize(value= "hasRole('USER')")
	public ProductStatus update(@RequestBody ProductStatus productStatus, @PathVariable int productStatusId) {
		
		ProductStatus updatedProductStatus = productStatusService.find(productStatusId);
		updatedProductStatus.setStatus(productStatus.getStatus());
		
		productStatusService.update(updatedProductStatus);
		
		return updatedProductStatus;
	}
	
	@DeleteMapping("/productStatuses/{productStatusId}")
	@PreAuthorize(value= "hasRole('ADMIN')")
	public String delete(@PathVariable int productStatusId) {
				
		productStatusService.delete(productStatusId);
		return "Deleted productStatus id - " + productStatusId;
		
	}
}




