package com.majorProject.techbazaar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usercartdb")
public class UserCart {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private User user;
	@OneToMany(mappedBy="userCart")
	private List<Cart> cart= new ArrayList<Cart>();
	@OneToMany(mappedBy="usercart")
	private List<Delivery> delivery= new ArrayList<Delivery>();
	
	
	public List<Delivery> getDelivery() {
		return delivery;
	}
	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	

}
