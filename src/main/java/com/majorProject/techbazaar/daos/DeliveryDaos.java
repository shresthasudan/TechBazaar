package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Delivery;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

public interface DeliveryDaos {
	public void addDelivery(Delivery delivery);
	public List<Delivery> getDeliveryList(User user);
	public void updateDelivery(Delivery delivery);
	public Delivery getDeliveryInfo(UserCart usercart);

}
