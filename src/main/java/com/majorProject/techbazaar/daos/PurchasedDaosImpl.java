package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Purchased;
@Repository
public class PurchasedDaosImpl implements PurchasedDaos {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addPurchased(Purchased purchased) {
		Session session= sessionFactory.getCurrentSession();
		session.save(purchased);

	}

	@Override
	@Transactional
	public List<Purchased> getAllPurchased() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Purchased.class);
		criteria.add(Restrictions.eq("status", "delivered"));
		List<Purchased> orderList=(List<Purchased>)criteria.list();
		session.close();
		return orderList;
	}

	@Override
	@Transactional
	public List<Purchased> getAllPurchasedByUserId(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean updatePurchased(Purchased purchase) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(purchase);
		return true;
	}

	@Override
	@Transactional
	public List<Purchased> getAllOrder() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Purchased.class);
		criteria.add(Restrictions.eq("status", "ordered"));
		List<Purchased> orderList=(List<Purchased>)criteria.list();
		session.close();
		return orderList;
	}

	@Override
	@Transactional
	public Purchased getById(int purchasedId) {
		Session session=sessionFactory.openSession();
		Purchased p =(Purchased) session.get(Purchased.class, purchasedId);
		return p;
	}

}
