package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class DisplayOneController {

	@Autowired
	QuestionDaoHibTemplate dao;
	
	@RequestMapping(value="/displayone")
	public ModelAndView displayAll(@RequestParam int questionId) {
		
		
		
		Question question = dao.findById(questionId);
		System.out.println(question);
		ModelAndView modelAndView = new ModelAndView("displayone.jsp" , "question" , question);
		
		
		return modelAndView;
		
	}
}
