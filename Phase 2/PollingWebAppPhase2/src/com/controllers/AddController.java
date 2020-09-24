package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class AddController {

	@Autowired
	QuestionDaoHibTemplate dao;
	
	@RequestMapping(value="/add")
	public ModelAndView addQuestionToDB( Question  questionObject) {
		
		System.out.println("Inside Add Controller");
		
		dao.addQuestion(questionObject);
		
		System.out.println("Record Added Sucessfully!!");
		
		
		ModelAndView modelAndView = new ModelAndView("addquestion.jsp" , "message" , "Poll Created Sucessfully!!");
		return modelAndView;
		
		
	}
	@RequestMapping(value="/confirmadd")
	public ModelAndView confirmAddQuestionToDB( @RequestParam String question , @RequestParam String keywords ) {
		
		System.out.println("From Confirm add   "+question+"    "+keywords);
		
		System.out.println("Inside Add Controller");
		Question questionObject = new Question(question, 0, 0, 0, keywords);
		dao.addQuestion(questionObject);
		
		System.out.println("Record Added Sucessfully!!");
		
		
		ModelAndView modelAndView = new ModelAndView("addquestion.jsp" , "message" , "Poll Created Sucessfully!!");
		return modelAndView;
		
		
	}
	
}
