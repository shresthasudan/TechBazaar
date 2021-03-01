package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

@Repository
public class UserCartDaosImpl implements UserCartDaos {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addUserCart(UserCart uc) {
		Session session = sessionFactory.getCurrentSession();
		session.save(uc);

	}

	@Override
	@Transactional
	public UserCart getUserCart(User u) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserCart.class);
		criteria.add(Restrictions.eq("user", u));
		@SuppressWarnings("unchecked")
		List<UserCart> uclist = (List<UserCart>)criteria.list();
		UserCart uc = uclist.get(0);
		return uc;
	}

}
