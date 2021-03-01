/*package com.majorProject.techbazaar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cartdb")
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="product_id")
	private int productId;
	@Column(name="user_id")
	private int userId;
	@Column
	private int quantity;
	@Column
	private String status;

	
	
	
	
	public Cart() {
		this.quantity = 1;
		this.status = "booked";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
*/

package com.majorProject.techbazaar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cartdb")
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Product product;
	@ManyToOne
	private UserCart userCart;
	@Column
	private int quantity;
	@Column(name="sub_total")
	private double subTotal;
	@Column
	private String status;
	@OneToMany(mappedBy="cart")
	private List<Purchased> purchased= new ArrayList<Purchased>();
	
	public List<Purchased> getPurchased() {
		return purchased;
	}
	public void setPurchased(List<Purchased> purchased) {
		this.purchased = purchased;
	}
	
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserCart getUserCart() {
		return userCart;
	}
	public void setUserCart(UserCart userCart) {
		this.userCart = userCart;
	}
	
	

}



