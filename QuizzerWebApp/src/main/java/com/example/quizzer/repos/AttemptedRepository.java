package com.example.quizzer.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Attempted;

public interface AttemptedRepository extends CrudRepository<Attempted, Integer>{

	Attempted findAllByContestNameAndEmailAndQuestionId(String contestName, String email, int id);

}
