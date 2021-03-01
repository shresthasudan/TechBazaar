/*package com.majorProject.techbazaar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchaseddb")
public class Purchased {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="cart_id")
	private int cartId;
	@Column
	private String status;
	@Column
	private Date orderedDate;
	@Column
	private Date deliveredDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	public Date getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	
}
*/

package com.majorProject.techbazaar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchaseddb")
public class Purchased {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Cart cart;
	@Column
	private String status;
	@Column
	private String orderedDate;
	@Column
	private String deliveredDate;
	
	Purchased(){
		status="ordered";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}
	public String getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	
}
