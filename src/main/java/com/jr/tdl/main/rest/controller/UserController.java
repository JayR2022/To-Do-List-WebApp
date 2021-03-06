package com.jr.tdl.main.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jr.tdl.main.persistence.entity.User;
import com.jr.tdl.main.rest.dto.UserDto;
import com.jr.tdl.main.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<List<UserDto>>(this.userService.getUser(), HttpStatus.OK);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody User user) {
		return new ResponseEntity<UserDto>(this.userService.createUser(user), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody User user){
		return new ResponseEntity<UserDto>(this.userService.updateUser(id,user), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
		public ResponseEntity<Boolean>deleteUser(@PathVariable Long id){
			return new ResponseEntity<Boolean>(this.userService.deleteUser(id), HttpStatus.OK);
		}

}
