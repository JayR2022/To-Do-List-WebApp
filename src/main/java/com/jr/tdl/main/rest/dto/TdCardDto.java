package com.jr.tdl.main.rest.dto;

import java.util.Date;

import com.jr.tdl.main.persistence.entity.User;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TdCardDto {
	
	private Long id;
	private Date createdOn;
	private String content;
	private Boolean selected;
	private User customer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	

}
