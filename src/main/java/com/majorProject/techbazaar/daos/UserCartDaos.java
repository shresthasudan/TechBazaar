package com.majorProject.techbazaar.daos;

import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

public interface UserCartDaos {
	public void addUserCart(UserCart uc);
	public UserCart getUserCart(User user);

}
