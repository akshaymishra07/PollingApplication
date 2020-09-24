package com.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {

		System.out.println(session.getAttribute("user"));

		session.removeAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
		return modelAndView;

	}

}
