package com.luv2code.springdemo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	@MapsId("type")
	@JoinColumn(name="type", referencedColumnName="id")
	private List<CategoryTranslation> categoryTranslations;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="type")
	private List<Product> products;
	
	public Category() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CategoryTranslation> getCategoryTranslations() {
		return categoryTranslations;
	}

	public void setProductTranslations(List<CategoryTranslation> categoryTranslations) {
		this.categoryTranslations = categoryTranslations;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + "]";
	}
		
}





