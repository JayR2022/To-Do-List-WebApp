package com.jr.tdl.main.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jr.tdl.main.persistence.entity.TdCard;

@Repository
public interface TdCardRepository extends JpaRepository<TdCard, Long>{

}
