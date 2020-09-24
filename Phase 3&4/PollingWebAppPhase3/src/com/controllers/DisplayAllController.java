package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class DisplayAllController {

	@Autowired
	QuestionDaoHibTemplate dao;
	
	@RequestMapping(value="/display")
	public ModelAndView displayAll() {
		
		System.out.println("Into the controller");
		
		List<Question> questions = dao.getQuestions();
		System.out.println(questions);
		ModelAndView modelAndView = new ModelAndView("questions.jsp" , "questions" , questions);
		
		
		return modelAndView;
		
	}
}
