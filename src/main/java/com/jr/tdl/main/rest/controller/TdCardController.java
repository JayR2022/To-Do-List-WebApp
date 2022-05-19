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
import org.springframework.web.bind.annotation.RestController;

import com.jr.tdl.main.persistence.entity.TdCard;
import com.jr.tdl.main.rest.dto.TdCardDto;
import com.jr.tdl.main.service.TdCardService;

@RestController
public class TdCardController {
	
	private TdCardService cardService;
	
	public TdCardController(TdCardService cardService) {
		super();
		this.cardService = cardService;
	}
	
	@GetMapping("/card/getAllCards")
	public ResponseEntity<List<TdCardDto>> getAllCards() {
		return new ResponseEntity<List<TdCardDto>>(this.cardService.getCards(), HttpStatus.OK);
	}
	
	@PostMapping("/card/createCard")
	public ResponseEntity<TdCardDto> createCard(@RequestBody TdCard card) {
		return new ResponseEntity<TdCardDto>(this.cardService.createCard(card), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/card/updateCard/{id}")
	public ResponseEntity<TdCardDto> updateCard(@PathVariable Long id, @RequestBody TdCard card){
		return new ResponseEntity<TdCardDto>(this.cardService.updateCard(id,card), HttpStatus.OK);
	}
	
	@DeleteMapping("/card/deleteCard/{id}")
	public ResponseEntity<Boolean>deleteCard(@PathVariable Long id){
		return new ResponseEntity<Boolean>(this.cardService.deleteCard(id), HttpStatus.OK);
	}

}
