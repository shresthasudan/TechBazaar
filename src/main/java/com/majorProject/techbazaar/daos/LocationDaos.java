package com.majorProject.techbazaar.daos;

import com.majorProject.techbazaar.model.Delivery;
import com.majorProject.techbazaar.model.Location;

public interface LocationDaos {
	public void addLocation(Location location);
	public Location viewLocation(Delivery delivery);
	public void updateLocation(Location location);
	public void deleteLocaion(Location location);

}
