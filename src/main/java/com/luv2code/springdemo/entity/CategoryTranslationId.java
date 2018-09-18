package com.luv2code.springdemo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoryTranslationId implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Column(name = "type")
	    private int type;
	 
	    @Column(name = "language_code")
	    private String languageCode;
	 
	    public CategoryTranslationId() {
	    }
	 
	    public CategoryTranslationId(int type, String languageCode) {
	        this.type = type;
	        this.languageCode = languageCode;
	    }
	 
	    public int getType() {
	        return type;
	    }
	 
	    public String getLanguageCode() {
	        return languageCode;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof CategoryTranslationId)) return false;
	        CategoryTranslationId that = (CategoryTranslationId) o;
	        return Objects.equals(getType(), that.getType()) &&
	                Objects.equals(getLanguageCode(), that.getLanguageCode());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getType(), getLanguageCode());
	    }
	}

