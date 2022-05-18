package com.jr.tdl.main.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.data.util.Optionals;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jr.tdl.main.persistence.entity.User;
import com.jr.tdl.main.persistence.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo){
		super();
		this.userRepo = userRepo;
	}
	
	
//	Create User
	public User createUser(User user) {
		return this.userRepo.save(user);
//		return this.userRepo.saveAndFlush(user);
//		return this.userRepo.findAll();
	}
	
//	Read User
	public List<User> getUser(){
		return this.userRepo.findAll();
	}
	
// Update User
	public User updateUser(Long id, User user) {
		
		Optional<User> isUserPresent = Optional.of(this.userRepo.findById(id).orElseThrow());
		User userPresent = isUserPresent.get();
		userPresent.setEmail(user.getEmail());
		userPresent.setFirstName(user.getFirstName());
		userPresent.setSecondName(user.getSecondName());
		userPresent.setUserName(user.getUserName());
		userPresent.setPassword(user.getPassword());
		
		return this.userRepo.save(userPresent);
//		Boolean isUserPresent = this.userRepo.existsById(id);
		
		
		
	}
//	
//	Delete User
	public boolean deleteUser(Long id) {
		this.userRepo.findById(id);
		this.userRepo.deleteById(id);
		return this.userRepo.existsById(id);
		
	}
	


}
