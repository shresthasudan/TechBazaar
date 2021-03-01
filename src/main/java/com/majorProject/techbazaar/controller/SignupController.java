package com.majorProject.techbazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.majorProject.techbazaar.daos.PasswordEncryption;
import com.majorProject.techbazaar.daos.UserCartDaos;
import com.majorProject.techbazaar.daos.UserDaos;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;

@Controller
public class SignupController {
	@Autowired
	private UserDaos userdaos;
	@Autowired
	private UserCartDaos userCartdaos;
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String getSignupForm(){
		return "signupPage";
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute User user, Model model){
		if(!userdaos.checkUsername(user.getUsername())){
			model.addAttribute("error", "Username : "+user.getUsername()+" is not available!");
			return "signupPage";
		}
		PasswordEncryption passEncryption = new PasswordEncryption();
		String userPassword=passEncryption.passwordEncryption(user.getPassword());
		user.setPassword(userPassword);
		userdaos.signup(user);
		UserCart uc = new UserCart();
		uc.setUser(user);
		userCartdaos.addUserCart(uc);
		
		return "home";
		
	}

}
