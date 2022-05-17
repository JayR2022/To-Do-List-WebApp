package com.jr.tdl.main.persistence.entity;

import java.util.Date;

import javax.persistence.Column;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date createdOn;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Boolean selected;
	
}
