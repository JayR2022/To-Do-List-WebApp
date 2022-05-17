package com.jr.tdl.main.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jr.tdl.main.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Float>{
	

}
