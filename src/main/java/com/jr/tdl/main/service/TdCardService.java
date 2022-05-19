package com.jr.tdl.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jr.tdl.main.exception.cardNotFoundException;
import com.jr.tdl.main.persistence.entity.TdCard;
import com.jr.tdl.main.persistence.repository.TdCardRepository;

@Service
public class TdCardService {
	
	private TdCardRepository cardRepo;
	
	
	public TdCardService(TdCardRepository cardRepo) {
		super();
		this.cardRepo = cardRepo;	
	}
	
	
//	Create User
	public TdCard createCard(TdCard card) {
		return this.cardRepo.save(card);
	}
	
//	Read User
	public List<TdCard> getCards(){
		return this.cardRepo.findAll();
	}
	
// Update User
	public TdCard updateCard(Long id, TdCard card) {
		
		Optional<TdCard> isCardPresent = Optional.of(this.cardRepo.findById(id).orElseThrow(cardNotFoundException::new));
		TdCard cardPresent = isCardPresent.get();
		
		cardPresent.setContent(card.getContent());
		cardPresent.setCreatedOn(card.getCreatedOn());
		cardPresent.setSelected(card.getSelected());
		return this.cardRepo.save(cardPresent);
	}
	
//	Delete User
	public boolean deleteCard(Long id) {
		this.cardRepo.findById(id).orElseThrow(cardNotFoundException::new);
		this.cardRepo.deleteById(id);
		return this.cardRepo.existsById(id);
		
	}
			

}
