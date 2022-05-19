package com.jr.tdl.main.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

//import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.jr.tdl.main.exception.UserNotFoundException;
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
	}
	
//	Read User
	public List<User> getUser(){
		return this.userRepo.findAll();
	}
	
// Update User
	public User updateUser(Long id, User user) {
		
		Optional<User> isUserPresent = Optional.of(this.userRepo.findById(id).orElseThrow(UserNotFoundException::new));
		User userPresent = isUserPresent.get();
		userPresent.setEmail(user.getEmail());
		userPresent.setFirstName(user.getFirstName());
		userPresent.setSecondName(user.getSecondName());
		userPresent.setUserName(user.getUserName());
		userPresent.setPassword(user.getPassword());
		return this.userRepo.save(userPresent);
	}

//	Delete User
	public boolean deleteUser(Long id) {
		this.userRepo.findById(id).orElseThrow(UserNotFoundException::new);
		this.userRepo.deleteById(id);
		return this.userRepo.existsById(id);	
	}
	


}
