package com.example.quizzer.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Integer>{

	ArrayList<Answer> findAllByQuestionId(int questionId);

	void deleteAllByQuestionId(int questionId);

}
