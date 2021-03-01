package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.User;

public interface RecommendationDaos {
	
	public List<Product> getRecommenatedProduct(User user);

}
