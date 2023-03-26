package com.example.quizzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attempted {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String contestName;
	public String email;
	public int questionId;
	public int answerId;
	public Attempted() {
		
	}
	public Attempted(String contestName, String email, int questionId, int answerId) {
		// TODO Auto-generated constructor stub
		this.contestName = contestName;
		this.email = email;
		this.questionId = questionId;
		this.answerId = answerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContestName() {
		return contestName;
	}
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
}
