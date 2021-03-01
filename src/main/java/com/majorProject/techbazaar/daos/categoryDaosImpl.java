package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Category;
@Repository
public class categoryDaosImpl implements categoryDaos {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional
	public List<Category> getAllCategory() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Category.class);
		@SuppressWarnings("unchecked")
		List<Category> clist=(List<Category>)criteria.list();
		session.close();
//		String sql="select * from categorydb";
//	    JdbcTemplate temp= new JdbcTemplate(dataSource);
//	    List<Category> clist=temp.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
		return clist;
	}

	@Override
	@Transactional
	public String getCategoryById(int id) {
		String sql="select name from categorydb where id='"+id+"'";
		JdbcTemplate temp =new JdbcTemplate(dataSource);
		String categoryName= temp.queryForObject(sql, String.class);
		return categoryName;
	}

	@Override
	@Transactional
	public void addCategory(Category c) {
		Session session=sessionFactory.getCurrentSession();
		c.setActive(true);
		session.save(c);
		
	}

	@Override
	@Transactional
	public Category getcategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class, id);
		return category;
	}

}
