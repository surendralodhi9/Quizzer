package com.example.quizzer.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer>{

	Registration findAllByEmailAndContestName(String email, String contestName);

	ArrayList<Registration> findAllByEmail(String email);

	ArrayList<Registration> findAllByContestName(String contestName);

}
