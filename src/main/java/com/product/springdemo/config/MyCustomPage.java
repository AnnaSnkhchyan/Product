package com.product.springdemo.config;

import org.springframework.data.domain.PageRequest;

public class MyCustomPage extends PageRequest{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Integer MAX_PAGE_SIZE = 2;
    //constructor 
    @SuppressWarnings("deprecation")
	public MyCustomPage(Integer page, Integer size) {
        super(page,(size>MAX_PAGE_SIZE)?MAX_PAGE_SIZE:size);
    }
}