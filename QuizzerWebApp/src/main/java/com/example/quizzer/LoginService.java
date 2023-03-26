package com.example.quizzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizzer.model.Admin;
import com.example.quizzer.model.Candidate;
import com.example.quizzer.repos.AdminRepository;
import com.example.quizzer.repos.CandidateRepository;
@Service
public class LoginService {
	
	@Autowired
	public AdminRepository adminRepo;
	@Autowired
	public CandidateRepository candidateRepo;
	
	public boolean isValidAdmin(String email, String password) {
		Admin admin = adminRepo.findAllByEmail(email);
		if(admin != null && password.equals(admin.password)) {
			return true;
		}
		
		return false;
	}
	public void addNewCandidate(Candidate candidate) {
		candidateRepo.save(candidate);
		
	}
	public Candidate getCandidate(String email) {
		
		return candidateRepo.findAllByEmail(email);
	}
	public boolean isValidCandidate(String email, String password) {
		// TODO Auto-generated method stub
		Candidate candidate = candidateRepo.findAllByEmail(email);
		if(candidate != null && password.equals(candidate.password)) {
			return true;
		}
		return false;
	}
	public Admin getAdmin(String email) {
		// TODO Auto-generated method stub
		return adminRepo.findAllByEmail(email);
	}
	

}
