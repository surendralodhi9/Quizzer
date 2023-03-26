package com.example.quizzer.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.quizzer.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	Admin findAllByEmail(String email);

}
