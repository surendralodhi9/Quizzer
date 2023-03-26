package com.example.quizzer.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Answer;
import com.example.quizzer.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

	ArrayList<Question> findAllBycontestId(int id);

	Question findAllByAnswerId(int answerId);

}
