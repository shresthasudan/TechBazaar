/*package com.majorProject.techbazaar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratingdb")
public class Rating {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="product_id")
	private int productId;
	@Column
	private int rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
@Table(name="ratingdb")
public class Rating {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	@Column
	private int rating;
	
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

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	
}
