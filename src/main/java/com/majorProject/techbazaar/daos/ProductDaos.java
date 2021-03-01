package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Product;

public interface ProductDaos {
	public void addProduct(Product p);
	public List<Product> getAllProduct();
	public Product getById(int id);
	public boolean deleteProduct(int id);
	public boolean updateProduct(Product product);
	public List<Product> getAllProductById(int id);
//	public List<Product> getProductsByTag(String tag);
//	public void indexProduct();
}
