package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.User;

public interface UserDaos {
	public void signup(User user);
	public boolean isExist(String username,String password);
	public void updateUser(User user);
	public boolean checkUsername(String username);
	public int getUserId(String username);
	public List<User> getallUser();
	public User getUser(int id);
	public String getRole(int id);
	public List<User> getAllStaff();
	public List<User> getAllUser();

}
