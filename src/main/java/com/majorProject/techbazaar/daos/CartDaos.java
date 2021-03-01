package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Cart;

public interface CartDaos {
	public void addToCart(Cart cart);
	public boolean updateCart(Cart cart);
	public int getCartId(int userId,int productId);
	public boolean deletecart(int cartId);
	public List<Cart> getAllCartProduct(int userId);
	public double getTotalAmount(int userId);
	public double getTotalProductAmount(int cartId);
	public boolean checkCart(int UserId, int ProductId);
	public Cart getCart(int cartId);

}
