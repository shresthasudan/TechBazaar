package com.majorProject.techbazaar.daos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.search.FullTextSession;
//import org.hibernate.search.Search;
//import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.majorProject.techbazaar.model.Product;
@Repository
public class ProductDaosImpl implements ProductDaos {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;

	
	@Override
	@Transactional
	public void addProduct(Product p) {
		Session session=sessionFactory.getCurrentSession();
		session.save(p);
		
		
	}

	@Override
	@Transactional
	public List<Product> getAllProduct() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		@SuppressWarnings("unchecked")
		List<Product> plist =(List<Product>)criteria.list();
		return plist;
	}

	@Override
	@Transactional
	public Product getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product p=(Product) session.get(Product.class, id);
		return p;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		return true;
	}

	@Override
	@Transactional
	public List<Product> getAllProductById(int id) {
		String sql="select * from productdb where category_id ='"+id+"'";
	    JdbcTemplate temp= new JdbcTemplate(dataSource);
	    List<Product> plist=temp.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return plist;
	}

//	@Override
//	@Transactional
//	public List<Product> getProductsByTag(String tag) {
//		try{
//			Session session = sessionFactory.getCurrentSession();
//			FullTextSession fullTextSession = Search.getFullTextSession(session);
//			QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
//			org.apache.lucene.search.Query query = qb.keyword().onFields("name","brand","description").matching(tag).createQuery();
//			Query hibQuery = fullTextSession.createFullTextQuery(query, null);
//			List<Product> searchList= hibQuery.list();
//			
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	@Transactional
//	public void indexProduct() {
//		
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			FullTextSession fullTestSession = Search.getFullTextSession(session);
//			fullTestSession.createIndexer().startAndWait();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
