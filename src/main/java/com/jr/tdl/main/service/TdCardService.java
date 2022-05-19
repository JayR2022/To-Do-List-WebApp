package com.jr.tdl.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jr.tdl.main.exception.cardNotFoundException;
import com.jr.tdl.main.persistence.entity.TdCard;
import com.jr.tdl.main.persistence.repository.TdCardRepository;
import com.jr.tdl.main.rest.dto.TdCardDto;

@Service
public class TdCardService {
	
	private TdCardRepository cardRepo;
	private ModelMapper modelMapper;
	
	
	public TdCardService(TdCardRepository cardRepo, ModelMapper modelMapper) {
		super();
		this.cardRepo = cardRepo;
		this.modelMapper = modelMapper;
	}
	
	
	private TdCardDto mapCardDto(TdCard card) {
		return this.modelMapper.map(card, TdCardDto.class);
	}
	
	
//	Create User
	public TdCardDto createCard(TdCard card) {
		return this.mapCardDto(this.cardRepo.save(card));
	}
	
//	Read User
	public List<TdCardDto> getCards(){
		return this.cardRepo.findAll()
							.stream()
							.map(cardItem -> this.mapCardDto(cardItem))
							.collect(Collectors.toList());
	}
	
// Update User
	public TdCardDto updateCard(Long id, TdCard card) {
		
		Optional<TdCard> isCardPresent = Optional.of(this.cardRepo.findById(id).orElseThrow(cardNotFoundException::new));
		TdCard cardPresent = isCardPresent.get();
		
		cardPresent.setContent(card.getContent());
		cardPresent.setCreatedOn(card.getCreatedOn());
		cardPresent.setSelected(card.getSelected());
		return this.mapCardDto(this.cardRepo.save(cardPresent));
	}
	
//	Delete User
	public boolean deleteCard(Long id) {
		this.cardRepo.findById(id).orElseThrow(cardNotFoundException::new);
		this.cardRepo.deleteById(id);
		return this.cardRepo.existsById(id);
		
	}
			

}
