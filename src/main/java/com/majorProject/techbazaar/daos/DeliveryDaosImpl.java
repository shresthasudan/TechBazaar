package com.majorProject.techbazaar.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Delivery;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

@Repository
public class DeliveryDaosImpl implements DeliveryDaos {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addDelivery(Delivery delivery) {
		Session session = sessionFactory.getCurrentSession();
		session.save(delivery);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Delivery> getDeliveryList(User user) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Delivery.class);
		criteria.add(Restrictions.eq("user", user));
		@SuppressWarnings("unchecked")
		List<Delivery> deliveryList = (List<Delivery>)criteria.list();
		return deliveryList;
	}

	@Override
	@Transactional
	public void updateDelivery(Delivery delivery) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(delivery);

	}

	@Override
	public Delivery getDeliveryInfo(UserCart usercart) {
		Session session= sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Delivery.class);
		criteria.add(Restrictions.eq("usercart", usercart));
		List<Delivery> list = (List<Delivery>)criteria.list();
		Delivery delivery = list.get(0);
		return delivery;
	}

}
