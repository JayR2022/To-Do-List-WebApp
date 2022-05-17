package com.jr.tdl.main.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@OneToMany(mappedBy="customer")
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JoinColumn(name="Card_id", nullable=false)    
	private List<TdCard> TdCards;  
	
	@Column(name = "user_name",unique = true, nullable = false)
	String username;
	
	@Column(name = "pass_word",nullable = false)
	String password;
	
	@Column(name = "first_Name",nullable = false)
	String FirstName;
	
	@Column(name="second_Name",nullable = false)
	String SecondName;
	
	@Column(name="email",nullable = false)
	String email;
	
}
