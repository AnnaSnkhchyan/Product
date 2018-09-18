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

import com.luv2code.springdemo.entity.ProductStatus;
import com.luv2code.springdemo.service.ProductStatusService;

@RestController
@RequestMapping("/api")
public class ProductStatusRestController {

	@Autowired
	private ProductStatusService productStatusService;
	
	@GetMapping("/productStatuses")
	public Page<ProductStatus> find(Pageable pageable){
		
		return productStatusService.findAll(pageable);
	}
	
	@GetMapping ("/productStatuses/{productStatusId}")
	public ProductStatus find(@PathVariable int productStatusId) {
		
		ProductStatus productStatus = productStatusService.find(productStatusId);
		
		return productStatus;
		
	}
	
	@PostMapping("/productStatuses")
	public ProductStatus create(@RequestBody ProductStatus productStatus) {
		
		productStatus.setId(0);
		
		productStatusService.create(productStatus);
		
		return productStatus;
	}
	
	@PutMapping("/productStatuses")
	public ProductStatus update(@RequestBody ProductStatus productStatus) {
		
		productStatusService.update(productStatus);
		
		return productStatus;
	}
	
	@DeleteMapping("/productStatuses/{productStatusId}")
	public String delete(@PathVariable int productStatusId) {
				
		productStatusService.delete(productStatusId);
		return "Deleted productStatus id - " + productStatusId;
		
	}
}




