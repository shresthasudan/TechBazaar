package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Comment;
import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.User;

public interface CommentDaos {
	public void addComment(Comment comment);
	public List<Comment> getAllCommentByProductId(Product product);
	public boolean checkComment(String cmt,Product product,User user);

}
