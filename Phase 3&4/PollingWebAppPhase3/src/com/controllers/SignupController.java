package com.controllers;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDaoHibTemplate;
import com.pojo.User;

@Controller
public class SignupController {

	@Autowired
	UserDaoHibTemplate dao;
	
	@RequestMapping(value="/adduser" ,method=RequestMethod.POST)
	public ModelAndView signupUser(@RequestParam String username , @RequestParam String password , @RequestParam String role) {
	
		 User user = new User(username, password, role);
		 dao.addUser(user);
		 
		 ModelAndView modelAndView = new ModelAndView("login.jsp" , "message" , "Registered Successfully .....Now Login!!");
		return modelAndView;
		
	}
}
