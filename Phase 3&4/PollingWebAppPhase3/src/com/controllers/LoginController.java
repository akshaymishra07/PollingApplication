package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDaoHibTemplate;
import com.pojo.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserDaoHibTemplate dao;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String username, @RequestParam String password , HttpSession session) {

		List<User> users = dao.getAllUsers();

		for (User u : users) {

			if (u.getUsername().equals(username)) {

				if (u.getPassword().equals(password)) {

					session.setAttribute("user", u.getUsername());
					ModelAndView modelAndView = new ModelAndView("index.jsp");
					return modelAndView;

				} else {
					ModelAndView modelAndView = new ModelAndView("login.jsp", "message",
							"Incorrect Password.....Please Try Again!!");
					return modelAndView;

				}

			}

		}

		ModelAndView modelAndView = new ModelAndView("login.jsp", "message", "User Does Not Exist...Please Register!!");
		return modelAndView;
	}
	
	

}
