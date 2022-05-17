package com.jr.tdl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jr.tdl.main.persistence.entity.User;
import com.jr.tdl.main.persistence.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
//	
	public UserService(UserRepository userRepo){
		super();
		this.userRepo = userRepo;
	}
	
	
//	Create User
	public User createUser(User user) {
		this.userRepo.save(user);
		return this.userRepo.getById(user.getId().floatValue());
	}
	
//	Read User
	public List<User> getUser(){
		return this.userRepo.findAll();
	}
	
// Update User
	
//	Delete User
	public boolean deleteUser(Long id) {
		this.userRepo.findById(id.floatValue());
		this.userRepo.deleteById(id.floatValue());
		return this.userRepo.existsById(id.floatValue());
		
	}
	


}
