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
@Table(name="deliverydb")
public class Delivery {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String status;
	@ManyToOne
	private User user;
	@ManyToOne
	private UserCart usercart;
	@OneToMany(mappedBy="delivery")
	private List<Location> location = new ArrayList<Location>();
	
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCart getUsercart() {
		return usercart;
	}
	public void setUsercart(UserCart usercart) {
		this.usercart = usercart;
	}
	
	

}
