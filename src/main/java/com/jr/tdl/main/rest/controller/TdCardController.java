package com.jr.tdl.main.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jr.tdl.main.persistence.entity.TdCard;
import com.jr.tdl.main.service.TdCardService;

@Controller
public class TdCardController {
	
	private TdCardService cardService;
	
	public TdCardController(TdCardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	@GetMapping("/card/getAllCards")
	public ResponseEntity<List<TdCard>> getAllCards() {
		return new ResponseEntity<List<TdCard>>(this.cardService.getCards(), HttpStatus.OK);
	}
	
	@PostMapping("/card/createCard")
	public ResponseEntity<TdCard> createCard(@RequestBody TdCard card) {
		return new ResponseEntity<TdCard>(this.cardService.createCard(card), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/card/updateCard/{id}")
	public ResponseEntity<TdCard> updateCard(@PathVariable Long id, @RequestBody TdCard card){
		return new ResponseEntity<TdCard>(this.cardService.updateCard(id,card), HttpStatus.OK);
	}
	
	@DeleteMapping("/card/deleteCard/{id}")
	public ResponseEntity<Boolean>deleteCard(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.cardService.deleteCard(id), HttpStatus.OK);
	}

}
