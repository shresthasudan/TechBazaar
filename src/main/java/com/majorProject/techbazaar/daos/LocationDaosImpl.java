package com.majorProject.techbazaar.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Delivery;
import com.majorProject.techbazaar.model.Location;
@Repository
public class LocationDaosImpl implements LocationDaos {

	private SessionFactory sessionFactory;
	@Override
	public void addLocation(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Location viewLocation(Delivery delivery) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		criteria.add(Restrictions.eq("delivery", delivery));
		@SuppressWarnings("unchecked")
		List<Location> locationList = (List<Location>)criteria.list();
		Location location = locationList.get(0);
		return location;
	}

	@Override
	public void updateLocation(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLocaion(Location location) {
		// TODO Auto-generated method stub

	}

}
