package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class AskController {

	@Autowired
	QuestionDaoHibTemplate dao;

	@RequestMapping(value = "/ask")
	public ModelAndView askForContinue(@RequestParam String keywords , @RequestParam String question) {

		 
	

		String keyWordArray[] = keywords.split(",");
         
		List<Question> questions = dao.getQuestions();
		List<Question> matchingQuestions = new ArrayList<>();

		questions.forEach(qstn -> {

			if (searchInArray(keyWordArray, qstn.getKeywords())) {
				matchingQuestions.add(qstn);
			}

		});		
		if(matchingQuestions.size() != 0) {
			System.out.println("MQ     "+matchingQuestions);
			Question questionObject = new Question(question, 0, 0, 0, keywords);
			matchingQuestions.add(questionObject);
			ModelAndView modelAndView = new ModelAndView("ask.jsp" , "matchingquestions" , matchingQuestions);
			return modelAndView;
 		}
		else {
			
			Question questionObject = new Question(question, 0, 0, 0, keywords);
			ModelAndView modelAndView = new ModelAndView("add" , "questionObject" , questionObject);
			System.out.println(modelAndView);
			return modelAndView;
		}
	}

	private boolean searchInArray(String array[], String keywords) {

		for (String s : array) {

			if (keywords.contains(s)) {
				return true;
			}

		}

		return false;
	}
}
