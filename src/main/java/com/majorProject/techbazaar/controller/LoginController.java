package com.majorProject.techbazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.majorProject.techbazaar.daos.PasswordEncryption;
import com.majorProject.techbazaar.daos.UserDaos;
import com.majorProject.techbazaar.model.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaos userdaos;

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm(){
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute User u,Model model,HttpSession session){
		PasswordEncryption passEncryption = new PasswordEncryption();
		String userPassword=passEncryption.passwordEncryption(u.getPassword());
		if(userdaos.isExist(u.getUsername(), userPassword)){
			session.setAttribute("username", u.getUsername());
			int id=userdaos.getUserId(u.getUsername());
			session.setAttribute("id", id);
			session.setAttribute("role", userdaos.getRole(id));
			session.setAttribute("activeUser", u.getUsername());
			session.setMaxInactiveInterval(5*60*1000);
			session.setAttribute("login", true);
			return "home";
		}
		model.addAttribute("error", "user doesnot exist");
		return "redirect:/home";
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest servletRequest){
		HttpSession session=servletRequest.getSession();
		session.removeAttribute("id");
		session.removeAttribute("activeUser");
		session.invalidate();
		return "redirect:home";
	}
	@RequestMapping(value="/{id}/updateUserInfo", method=RequestMethod.GET)
	public String updateUserInfomation(@PathVariable int id, Model model){
		model.addAttribute("user", userdaos.getUser(id));
		return "updateUser";
	}
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUserInfo(@ModelAttribute User user){
		userdaos.updateUser(user);
		return "redirect:/home";
	}
	
}
