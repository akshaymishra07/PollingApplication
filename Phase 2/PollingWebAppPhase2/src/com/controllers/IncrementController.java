package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class IncrementController {
   
	@Autowired
	QuestionDaoHibTemplate dao;
	
	
	@RequestMapping(value="/increment")
	public ModelAndView recordThePoll(@RequestParam int questionId , @RequestParam String option) {
		
		Question question = dao.findById(questionId);
		
		if(option.equals("yes")) {
			question.setYes(question.getYes()+1);
		}
		else if(option.equals("no")) {
			question.setNo(question.getNo()+1);
		}
		else if(option.equals("notSure")) {
			question.setNotSure(question.getNotSure()+1);
		}
		
		dao.increment(question);
		
		ModelAndView modelAndView = new ModelAndView("displayone.jsp" , "question" , question);
		return modelAndView;
	}
	
	
	
}
