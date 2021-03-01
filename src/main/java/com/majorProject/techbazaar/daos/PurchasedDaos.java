package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Purchased;

public interface PurchasedDaos {
	public void addPurchased(Purchased purchased);
	public List<Purchased> getAllPurchased();
	public List<Purchased> getAllPurchasedByUserId(int UserId);
	public boolean updatePurchased(Purchased purchased);
	public Purchased getById(int purchasedId);
	public List<Purchased> getAllOrder();

}
