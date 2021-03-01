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

import com.majorProject.techbazaar.model.Comment;
import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.User;
@Repository
public class CommentDaosImpl implements CommentDaos {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addComment(Comment comment) {
		Session session=sessionFactory.getCurrentSession();
		session.save(comment);
	}

	@Override
	@Transactional
	public List<Comment> getAllCommentByProductId(Product product) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Comment.class);
		criteria.add(Restrictions.eq("product", product));
		List<Comment> commentList= (List<Comment>)criteria.list();
		return commentList;
	}

	@Override
	@Transactional
	public boolean checkComment(String cmt,Product product, User user) {
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Comment.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("product", product));
		criteria.add(Restrictions.eq("comment", cmt));
		List<Comment> cmtList=(List<Comment>)criteria.list();
		if(cmtList.isEmpty()){
			return true;
		}
		return false;
	}

}
