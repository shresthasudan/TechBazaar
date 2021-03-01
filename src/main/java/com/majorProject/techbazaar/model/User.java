/*package com.majorProject.techbazaar.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userdb")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String contact;
	@Column
	private String address;
	@Column(columnDefinition="bit")
	private Boolean isActive;

	
	
	public User(){
		this.isActive=true;
		this.role="user";//admin,supplier,user/customer,customer/staff
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="userdb")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String email;
	@Column
	private String name;
	@Column
	private String contact;
	@Column
	private String address;
	@Column(columnDefinition="bit")
	private Boolean isActive;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comment =new ArrayList<Comment>();
	@OneToMany(mappedBy="user")
	private List<Rating> rating = new ArrayList<Rating>();
	@OneToOne(mappedBy="user")
	private UserCart userCart;
	@OneToMany(mappedBy="user")
	private List<Delivery> delivery = new ArrayList<Delivery>(); 
	
	
	public User(){
		this.isActive=true;
		this.role="user";//admin,supplier,user/customer,customer/staff
	}
	
	
	
	public List<Delivery> getDelivery() {
		return delivery;
	}



	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}



	public UserCart getUserCart() {
		return userCart;
	}



	public void setUserCart(UserCart userCart) {
		this.userCart = userCart;
	}



	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	} 
	
	
}
