package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Category;

public interface categoryDaos {
	public void addCategory(Category c);
	List<Category> getAllCategory();
	String getCategoryById(int id);
	public Category getcategory(int id);
}
