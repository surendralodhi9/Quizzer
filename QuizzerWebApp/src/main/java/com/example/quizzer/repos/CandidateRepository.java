package com.example.quizzer.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.quizzer.model.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer>{

	Candidate findAllByEmail(String email);


} 
