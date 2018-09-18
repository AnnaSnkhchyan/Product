package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="category_translation")
public class CategoryTranslation {
	
	@EmbeddedId
    private CategoryTranslationId id;	
	
	@Column(name="title")
	private String title;
	
	public CategoryTranslation() {
		
	}

	public CategoryTranslation(String title) {
		this.title = title;
	}


	public CategoryTranslationId getId() {
		return id;
	}

	public void setId(CategoryTranslationId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CategoryTranslation [id=" + id + ", title=" + title + "]";
	}
		
}





