package com.jr.tdl.main.persistence.entity;

import java.util.Date;
//import java.util.List;

import javax.persistence.Column;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TdCard")
@Data
@NoArgsConstructor
public class TdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity =User.class)
//	@JoinColumn(name="User_id", nullable=false)
    private User customer;
	
	@Column(name="created_On",nullable = false)
	private Date createdOn;
	
	@Column(name="consent",nullable = false)
	private String content;
	
	@Column(name="selected",nullable = false)
	private Boolean selected;
	
}
