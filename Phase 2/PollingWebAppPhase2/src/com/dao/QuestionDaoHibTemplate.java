package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Question;

@Repository(value="hibTemplate")
public class QuestionDaoHibTemplate {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Question findById(int id) {
		
		 Question question=(Question)hibernateTemplate.get(Question.class,id);  
		    return question;
	}
	
	public List<Question> getQuestions(){  
		
		System.out.println("from getq "+ hibernateTemplate);
		
	    List<Question> list=new ArrayList<>();  
	    list=hibernateTemplate.loadAll(Question.class);  
	    
	    System.out.println("From getq  content"+ list);
	    
	    return list;  
	}  
	
	public List<String> questionStatements(){
		
		System.out.println("Into the dao class");
		List<Question> list = getQuestions();
		List<String> questions = new ArrayList<>() ;
	    
		list.forEach((q) -> {
			
			questions.add(q.getQuestion());
			
		});
		
		System.out.println("From dao the content is "+questions);
		
		return questions;
		
	}
	
	@Transactional
	public void increment(Question question) {
		
		hibernateTemplate.update(question);
	}
	
	@Transactional
	public void addQuestion(Question question) {
		
		hibernateTemplate.save(question);
	}
	
}
