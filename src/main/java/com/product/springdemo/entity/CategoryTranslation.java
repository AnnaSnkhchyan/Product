package com.product.springdemo.entity;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryTranslation other = (CategoryTranslation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}





