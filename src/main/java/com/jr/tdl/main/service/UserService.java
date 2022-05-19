package com.jr.tdl.main.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import com.jr.tdl.main.exception.UserNotFoundException;
import com.jr.tdl.main.persistence.entity.User;
import com.jr.tdl.main.persistence.repository.UserRepository;
import com.jr.tdl.main.rest.dto.UserDto;

@Service
public class UserService {
	
	private UserRepository userRepo;
	private ModelMapper modelMapper; 

	public UserService(UserRepository userRepo, ModelMapper modelMapper){
		super();
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}
	
//	Model mapping 
	private UserDto mapUserDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}
	
	
//	Create User
	public UserDto createUser(User user) {		
		return this.mapUserDto(this.userRepo.save(user));
	}
	
//	Read User
	public List<UserDto> getUser(){
		
		return this.userRepo.findAll()
							.stream()
							.map(userItem->this.mapUserDto(userItem))
							.collect(Collectors.toList());
	}
	
// Update User
	public UserDto updateUser(Long id, User user) {
		
		Optional<User> isUserPresent = Optional.of(this.userRepo.findById(id).orElseThrow(UserNotFoundException::new));
		User userPresent = isUserPresent.get();
		userPresent.setEmail(user.getEmail());
		userPresent.setFirstName(user.getFirstName());
		userPresent.setSecondName(user.getSecondName());
		userPresent.setUserName(user.getUserName());
		userPresent.setPassword(user.getPassword());
		return this.mapUserDto(this.userRepo.save(userPresent));
	}

//	Delete User
	public boolean deleteUser(Long id) {
		this.userRepo.findById(id).orElseThrow(UserNotFoundException::new);
		this.userRepo.deleteById(id);
		return this.userRepo.existsById(id);	
	}
	


}
