package com.example.quizzer.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Contest;

public interface ContestRepository extends CrudRepository<Contest, Integer>{

	public Contest findAllByName(String contestName);
	

}
