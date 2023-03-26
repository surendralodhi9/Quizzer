package com.example.quizzer;

import java.util.ArrayList;

import com.example.quizzer.model.Admin;
import com.example.quizzer.model.Candidate;
import com.example.quizzer.model.Contest;
import com.example.quizzer.model.Question;

public class SessionClass {
	
	public Admin admin;
	public Candidate candidate;
	public Contest contest;
	public ArrayList<Question> questionsList;
	public int duration;
	public String startTime;

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public SessionClass() {
		
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public ArrayList<Question> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(ArrayList<Question> questionsList) {
		this.questionsList = questionsList;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
