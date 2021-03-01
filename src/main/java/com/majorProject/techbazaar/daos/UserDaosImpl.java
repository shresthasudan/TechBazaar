package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.User;

@Repository
public class UserDaosImpl implements UserDaos {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	@Override
	@Transactional
	public void signup(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);

	}

	@Override
	public boolean isExist(String username, String password) {
		String sql="select username from userdb where username = '"+username+"' and password = '"+password+"' ";
		JdbcTemplate temp =new JdbcTemplate(dataSource);
		try{
			String name=temp.queryForObject(sql, String.class);
			if(!name.equals("")){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
		return false;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

	@Override
	public boolean checkUsername(String username) {

		String sql="select count(*) from userdb where username ='"+username+"'";
		JdbcTemplate temp=new JdbcTemplate(dataSource);
		int count =temp.queryForInt(sql);
		if(count!=0){
			return false;
		}
		return true;
	}

	@Override
	public int getUserId(String username) {
		String sql="select id from userdb where username = '"+username+"'";
		JdbcTemplate temp= new JdbcTemplate(dataSource);
		int id = temp.queryForInt(sql);
		return id;
	}

	@Override
	@Transactional
	public List<User> getallUser() {
		String sql="select * from userdb where role = user";
		JdbcTemplate temp =new JdbcTemplate(dataSource);
		List<User> ulist =temp.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return ulist;
	}

	@Override
	@Transactional
	public User getUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class, id);
		return user;
	}

	@Override
	public String getRole(int id) {
		String sql="select role from userdb where id = '"+id+"'";
		JdbcTemplate temp = new JdbcTemplate(dataSource);
		String role = temp.queryForObject(sql, String.class);
		return role;
	}

	@Override
	@Transactional
	public List<User> getAllStaff() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("role", "staff"));
		List<User> ulist = (List<User>)criteria.list();
		return ulist;
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("role", "user"));
		List<User> ulist = (List<User>)criteria.list();
		return ulist;
	}

}
