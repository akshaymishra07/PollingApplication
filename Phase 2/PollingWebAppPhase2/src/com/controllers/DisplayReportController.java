package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class DisplayReportController {

	@Autowired
	QuestionDaoHibTemplate dao;
	
	@RequestMapping(value="/reports")
	public ModelAndView toReport() {
		
		List<Question> questions = dao.getQuestions();
		
		
		ModelAndView modelAndView = new ModelAndView("reports.jsp" , "questions" , questions);
		return modelAndView;
	}
	
}
