package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.Rating;
import com.majorProject.techbazaar.model.User;

public interface RatingDaos {
	public void addRating(Rating rating);
	public List<Rating> getAllRatingByProductId(Product product);
	public Double getTotalRatingOfProduct(Product product);
	public int getPreviousRating(User user, Product product);
	public void updateRating(Rating rating);
	public boolean checkRating(User user,Product product);
	public Rating getRating(User user,Product product);
	public List<Rating> getAllRating();
}
