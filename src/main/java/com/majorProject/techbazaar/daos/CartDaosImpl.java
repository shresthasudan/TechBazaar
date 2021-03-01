package com.majorProject.techbazaar.daos;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.majorProject.techbazaar.model.Cart;
import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

@Repository
public class CartDaosImpl implements CartDaos {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDaos userdaos;
	@Autowired
	private ProductDaos productDaos;
	@Autowired
	private UserCartDaos userCartdaos;
	
	
	@Override
	@Transactional
	public void addToCart(Cart cart) {
		Session session =sessionFactory.getCurrentSession();
		session.save(cart);

	}

	@Override
	@Transactional
	public boolean updateCart(Cart cart) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		return true;
	}

	@Override
	@Transactional
	public int getCartId(int userId, int productId) {
		User user=userdaos.getUser(userId);
		Product product=productDaos.getById(productId);
		UserCart userCart = userCartdaos.getUserCart(user);
		
		String sql="select id from cartdb where userCart ='"+userCart+"' and product= '"+product+"'";
		JdbcTemplate temp =new JdbcTemplate(dataSource);
		int id =temp.queryForInt(sql);
		return id;
	}

	@Override
	@Transactional
	public boolean deletecart(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart) session.get(Cart.class, cartId);
		session.delete(cart);
		return true;
	}

	@Override
	@Transactional
	public List<Cart> getAllCartProduct(int userId) {
		Session session=sessionFactory.openSession();
		User user=userdaos.getUser(userId);
		UserCart userCart = userCartdaos.getUserCart(user);
		Criteria criteria=session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("userCart", userCart));
		criteria.add(Restrictions.like("status", "booked"));
		List<Cart> cartList=(List<Cart>)criteria.list();
		session.close();
		return cartList;
	}

	@Override
	@Transactional
	public double getTotalAmount(int userId) {
		Session session=sessionFactory.openSession();
		User user=userdaos.getUser(userId);
		UserCart userCart =userCartdaos.getUserCart(user);
		Criteria criteria=session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("userCart", userCart));
		criteria.add(Restrictions.like("status", "booked"));
		List<Cart> cartList=(List<Cart>)criteria.list();
		session.close();
		double total=0;
		for(Cart c:cartList){
			total=c.getSubTotal()+total;
		}
		return total;
	}

	@Override
	public double getTotalProductAmount(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public boolean checkCart(int userId, int productId) {
		User user=userdaos.getUser(userId);
		Product product=productDaos.getById(productId);
		UserCart userCart= userCartdaos.getUserCart(user);
		Session session=sessionFactory.openSession();
		Criteria criteria =session.createCriteria(Cart.class);
		criteria.add(Restrictions.eq("userCart", userCart));
		criteria.add(Restrictions.eq("product", product));
		List<Cart> cartList=(List<Cart>)criteria.list();
		session.close();
		if(cartList.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Cart getCart(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart) session.get(Cart.class, cartId);
		return cart;
		
	}

}
