package com.example.quizzer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.quizzer.model.Answer;
import com.example.quizzer.model.Attempted;
import com.example.quizzer.model.Contest;
import com.example.quizzer.model.Question;
import com.example.quizzer.model.Registration;
import com.example.quizzer.repos.AnswerRepository;
import com.example.quizzer.repos.AttemptedRepository;
import com.example.quizzer.repos.ContestRepository;
import com.example.quizzer.repos.QuestionRepository;
import com.example.quizzer.repos.RegistrationRepository;

@Service
public class ContestService {
	
	@Autowired
	public ContestRepository contestRepo;
	@Autowired
	public QuestionRepository questionRepo;
	@Autowired
	public AnswerRepository answerRepo;
	@Autowired
	public RegistrationRepository registrationRepo;
	@Autowired
	public AttemptedRepository attemptedRepo;
	
	public boolean isNewContest(String contestName) {
		Contest contest = contestRepo.findAllByName(contestName);
		if(contest != null && contestName.equals(contest.name)) {
			return false;
		}
	    String createdDate = HelperUtility.getCurrentTimeStamp();
	    contest = new Contest();
	    contest.setDoc(createdDate);
	    contest.setName(contestName);
		contestRepo.save(contest);
		return true;
	}
    public Contest getContest(String contestName) {
    	Contest contest = contestRepo.findAllByName(contestName);
    	return contest;
    }
    public Contest getContest(int contestId) {
    	Contest contest = contestRepo.findById(contestId).orElse(new Contest());
    	return contest;
    }
	public ArrayList<Contest> getAllContest() {
		// TODO Auto-generated method stub
		
		return (ArrayList<Contest>) contestRepo.findAll();
	}
	public void updateAndSaveContest(Contest contest) {
		// TODO Auto-generated method stub
		contestRepo.save(contest);
	}
	public void addNewQuestion(Question question) {
		questionRepo.save(question);
		
	}
	public int deleteQuestionById(int questionId) {
		try {
			Question question = getQuestionById(questionId);
			
			Contest contest = contestRepo.findById(question.contestId).orElse(new Contest());
			contest.setNoques(contest.getNoques() - 1);
			updateAndSaveContest(contest);
			questionRepo.deleteById(questionId);
			answerRepo.deleteAllByQuestionId(questionId);
			return contest.getId();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return 0;

	}
	public ArrayList<Question> getAllQuestionsByContestId(int id) {
		// TODO Auto-generated method stub
		
		return questionRepo.findAllBycontestId(id);
	}
	public Question getQuestionById(int questionId) {
		// TODO Auto-generated method stub
		
		return questionRepo.findById(questionId).orElse(new Question());
	}
	public ArrayList<Answer> getAllAnswersByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		return answerRepo.findAllByQuestionId(questionId);
	}
	public void addNewAnswer(Answer answer) {
		// TODO Auto-generated method stub
		answerRepo.save(answer);
	}
	public void deleteAnswerById(int answerId) {
		answerRepo.deleteById(answerId);
		Question question = questionRepo.findAllByAnswerId(answerId);
		if(question != null) {
			question.setAnswerId(0);
			addNewQuestion(question);
		}
	}
	public int getQuestionIdByAnswerId(int answerId) {
		// TODO Auto-generated method stub
		Answer answer = answerRepo.findById(answerId).orElse(new Answer());
		return answer.getQuestionId();
	}
	public void registerForContest(Registration register) {
		// TODO Auto-generated method stub
		registrationRepo.save(register);
	}
	public Registration getRegistration(String email, String contestName) {
		// TODO Auto-generated method stub
		return registrationRepo.findAllByEmailAndContestName(email, contestName);
	}
	public ArrayList<Registration> getAllContestByEmail(String email) {
		// TODO Auto-generated method stub
		return registrationRepo.findAllByEmail(email);
	}
	public ArrayList<Registration> getAllRegistrationByContestName(String contestName) {
		// TODO Auto-generated method stub
		return registrationRepo.findAllByContestName(contestName);
	}
	public void addNewAttempt(Attempted attempted) {
		attemptedRepo.save(attempted);
	}
	public Attempted getAttemptByContestEmailQuestionId(String contestName, String email, int id) {
		// TODO Auto-generated method stub
		
		return attemptedRepo.findAllByContestNameAndEmailAndQuestionId(contestName, email, id);
	}


}
