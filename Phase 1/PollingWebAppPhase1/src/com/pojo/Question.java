package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int questionId;
	String question;
	int yes;
	int no;
	int notSure;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(int questionId, String question, int yes, int no, int notSure) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.yes = yes;
		this.no = no;
		this.notSure = notSure;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getYes() {
		return yes;
	}

	public void setYes(int yes) {
		this.yes = yes;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNotSure() {
		return notSure;
	}

	public void setNotSure(int notSure) {
		this.notSure = notSure;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", yes=" + yes + ", no=" + no
				+ ", notSure=" + notSure + "]";
	}

	
}
