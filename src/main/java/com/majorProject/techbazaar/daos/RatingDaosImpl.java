package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.Rating;
import com.majorProject.techbazaar.model.User;

@Repository
public class RatingDaosImpl implements RatingDaos {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	
	@Override
	@Transactional
	public void addRating(Rating rating) {
		Session session=sessionFactory.getCurrentSession();
		session.save(rating);

	}

	@Override
	@Transactional
	public List<Rating> getAllRatingByProductId(Product product) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Rating.class);
		criteria.add(Restrictions.eq("product", product));
		List<Rating> ratingList=(List<Rating>)criteria.list();
		return ratingList;
	}

	@Override
	@Transactional
	public Double getTotalRatingOfProduct(Product product) {
		/*String sqlCount ="select count(*) from ratingdb where product='"+product+"'";
		String sqlTotal="select sum(rating) from ratingdb where product='"+product+"'";
		JdbcTemplate temp= new JdbcTemplate(dataSource);
		int count=temp.queryForInt(sqlCount);
		int ratingTotal=temp.queryForInt(sqlTotal);*/
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Rating.class);
		criteria.add(Restrictions.eq("product", product));
		criteria.setProjection(Projections.rowCount());
		List getCount=criteria.list();
		int count =Integer.parseInt(getCount.get(0).toString());
		Criteria cr=session.createCriteria(Rating.class);
		cr.add(Restrictions.eq("product", product));
		cr.setProjection(Projections.sum("rating"));
		List getRating=cr.list();
		Double ratingAvg=0.0;
		if(count!=0){
			int ratingTotal=Integer.parseInt(getRating.get(0).toString());
			ratingAvg=(double) (ratingTotal/count);
		}
		
		return ratingAvg;
	}

	@Override
	@Transactional
	public int getPreviousRating(User user, Product product) {
		/*String sql="select rating from ratingdb where user ='"+user+"' and product='"+product+"'";
		JdbcTemplate temp= new JdbcTemplate(dataSource);*/
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Rating.class);
		criteria.add(Restrictions.eq("product", product));
		criteria.add(Restrictions.eq("user", user));
		criteria.setProjection(Projections.property("rating"));
		List getRating=criteria.list();
		if(getRating.size()!=0){
		int rate=Integer.parseInt(getRating.get(0).toString());
			return rate;
		}else{
			return 0;
		}
	}

	@Override
	@Transactional
	public void updateRating(Rating rating) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(rating);
	}

	@Override
	@Transactional
	public boolean checkRating(User user, Product product) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Rating.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("product", product));
		List<Rating> ratingList=(List<Rating>)criteria.list();
		if(ratingList.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Rating getRating(User user, Product product) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Rating.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("product", product));
		List<Rating> ratingList=(List<Rating>)criteria.list();
		Rating rate=ratingList.get(0);
		return rate;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Rating> getAllRating() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Rating.class);
		List<Rating> ratingList = (List<Rating>)criteria.list();
		return ratingList;
	}

}
