package com.jr.tdl.main.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(unique = true, nullable = false)
	String username;
	
	@Column(nullable = false)
	String password;
	
	@Column(nullable = false)
	String FirstName;
	
	@Column(nullable = false)
	String SecondName;
	
	@Column(nullable = false)
	String email;
	
}
