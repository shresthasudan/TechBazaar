package com.majorProject.techbazaar.model;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorydb")
public class Category{

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column(columnDefinition="bit")
	private Boolean isActive;
	
	@OneToMany(mappedBy="category")
	private List<Product> product = new ArrayList<Product>();
	
	
	public Category() {
		this.isActive=true;
	}
//	@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	private List<Product> product;
//	
//	
//	
//	public List<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(List<Product> product) {
//		this.product = product;
//	}
	
	public int getId() {
		return id;
	}
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	

	
	
}
