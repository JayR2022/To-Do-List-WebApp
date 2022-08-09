package com.jr.tdl.main.persistence.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import com.jr.tdl.main.persistence.entity.TdCard;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
public class TdCardRepositoryTests {

    @Autowired
    private TdCardRepository tdCardRepository;

    @BeforeEach
    void init(){
        var newCard1 = new TdCard();
        var newCard2 = new TdCard();
        var newCard3 = new TdCard();
        
        LocalDate newDate = LocalDate.now();

        newCard1.setContent("item1");
        newCard1.setCreatedOn(newDate);
        newCard1.setSelected(false);

        newCard2.setContent("item2");
        newCard2.setCreatedOn(newDate);
        newCard2.setSelected(false);

        newCard3.setContent("item3");
        newCard3.setCreatedOn(newDate);
        newCard3.setSelected(false);

        tdCardRepository.saveAndFlush(newCard1);
        tdCardRepository.saveAndFlush(newCard2);
        tdCardRepository.saveAndFlush(newCard3);
    }


    @Test
    void testTdCardDbIntegration(){
        List<TdCard> allTdCards = tdCardRepository.findAll();
        assertEquals(3,allTdCards.size());
        
    }



}
