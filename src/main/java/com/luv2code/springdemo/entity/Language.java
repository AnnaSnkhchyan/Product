package com.luv2code.springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="language")
public class Language {

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	@MapsId("languageCode")
	@JoinColumn(name="language_code", referencedColumnName="code")
	private List<CategoryTranslation> categoryTranslations;
	
	public Language() {
		
	}

	public Language(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<CategoryTranslation> getCategoryTranslations() {
		return categoryTranslations;
	}

	public void setCategoryTranslations(List<CategoryTranslation> categoryTranslations) {
		this.categoryTranslations = categoryTranslations;
	}

	@Override
	public String toString() {
		return "Language [code=" + code + ", name=" + name + "]";
	}
	

}





