/*package com.majorProject.techbazaar.model;



import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="productdb")
public class Product{
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String code;
	@Column
	private String name;
	@Column
	private String brand;
	@Column
	private String description;
	@Column
	private double unit_price;
	@Column
	private int quantity;
	@Column(columnDefinition="bit")
	private boolean isActive;//columnDefination="bit"
	@Column
	private int views;
	@Column
	private String supplier_name;
	@Column
	private String supplier_email;
	@Column
	private int quantity_limit;
	
	
	@Column(name="category_id")
	private int categoryId;



	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		this.isActive=true;
		this.views=0;
	}


	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public int getQuantity_limit() {
		return quantity_limit;
	}

	public void setQuantity_limit(int quantity_limit) {
		this.quantity_limit = quantity_limit;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	// @ManyToOne(cascade=CascadeType.ALL)
	// @JoinColumn(name="category_id")
	// private Category category;
	//
	//
	// public Category getCategory() {
	// return category;
	// }
	// public void setCategory(Category category) {
	// this.category = category;
	// }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}



}
*/


package com.majorProject.techbazaar.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.search.annotations.Analyze;
//import org.hibernate.search.annotations.Field;
//import org.hibernate.search.annotations.Index;
//import org.hibernate.search.annotations.Indexed;
//import org.hibernate.search.annotations.Store;
import org.springframework.web.multipart.MultipartFile;


@Entity
//@Indexed
@Table(name="productdb")
public class Product{
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String code;
	@Column
	//@Field(index= Index.YES, analyze = Analyze.YES, store=Store.NO)
	private String name;
	@Column
	//@Field(index=Index.YES, analyze= Analyze.YES, store=Store.NO)
	private String brand;
	@Column
	//@Field(index=Index.YES, analyze= Analyze.YES, store= Store.NO)
	private String description;
	@Column
	private double unit_price;
	@Column
	private int quantity;
	@Column(columnDefinition="bit")
	private boolean isActive;//columnDefination="bit"
	@Column
	private int views;
//	@Column
//	private String supplier_name;
//	@Column
//	private String supplier_email;
	@Column
	private int quantity_limit;
	@OneToMany(mappedBy="product")
	private List<Cart> cart =new ArrayList<Cart>();
	@OneToMany(mappedBy="product")
	private List<Comment> comment=new ArrayList<Comment>();
	@OneToMany(mappedBy="product")
	private List<Rating> rating= new ArrayList<Rating>();
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Supplier supplier;
	
	@Column
	private String entryDate;
	
	
//	@Column(name="category_id")
//	private int categoryId;
//
//
//
//	public int getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}

	public Category getCategory() {
		return category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		this.isActive=true;
		this.views=0;
	}


	public int getQuantity_limit() {
		return quantity_limit;
	}

	public void setQuantity_limit(int quantity_limit) {
		this.quantity_limit = quantity_limit;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	// @ManyToOne(cascade=CascadeType.ALL)
	// @JoinColumn(name="category_id")
	// private Category category;
	//
	//
	// public Category getCategory() {
	// return category;
	// }
	// public void setCategory(Category category) {
	// this.category = category;
	// }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

}
