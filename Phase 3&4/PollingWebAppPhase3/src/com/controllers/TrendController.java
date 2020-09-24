package com.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;

@Controller
public class TrendController {

	@Autowired
	QuestionDaoHibTemplate dao;

	@RequestMapping(value = "/trends")
	public ModelAndView showTrends() {

		List<Question> questions = dao.getQuestions();
		List<Question> topThree = new ArrayList<Question>();
		Set<String> trendingKeyWords = new HashSet<>();
		int q1=0, q2=0, q3=0;
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;

		for (Question qstn : questions) {

			String keyWords[] = qstn.getKeywords().split(",");

			for (String keyw : keyWords) {

				trendingKeyWords.add(keyw);
			}

			int total = qstn.getYes() + qstn.getNo() + qstn.getNotSure();

			if (total > first) {

				third = second;
				q3 = q2;
				second = first;
				q2 = q1;
				first = total;
				q1 = qstn.getQuestionId();

			} else if (total < first && total > second) {

				third = second;
				q3 = q2;
				second = total;
                q2 = qstn.getQuestionId();
				
			} else if (total < second && total > third) {

				third = total;
				q3 = qstn.getQuestionId();
			}

			System.out.println(qstn.getQuestion() +"       has total votes        "+total);
			System.out.println(trendingKeyWords);
			
		}

		
		topThree.add(dao.findById(q1));
		topThree.add(dao.findById(q2));
		topThree.add(dao.findById(q3));
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("topThree", topThree );
		modelAndView.addObject("trendingKeywords", trendingKeyWords);
		modelAndView.setViewName("trends.jsp");
		
		
		return modelAndView;
	}

}
