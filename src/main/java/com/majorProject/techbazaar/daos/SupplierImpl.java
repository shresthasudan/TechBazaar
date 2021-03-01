package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Supplier;

@Repository
public class SupplierImpl implements SupplierDaos {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional
	public void addSupplier(Supplier s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);

	}

	@Override
	@Transactional
	public List<Supplier> getAllSupplier() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Supplier.class);
		@SuppressWarnings("unchecked")
		List<Supplier> slist = (List<Supplier>)criteria.list();
		session.close();
		return slist;
	}

	@Override
	@Transactional
	public Supplier getSupplier(int id) {
		Session session = sessionFactory.getCurrentSession();
		Supplier supplier = (Supplier) session.get(Supplier.class, id);
		return supplier;
	}

}
