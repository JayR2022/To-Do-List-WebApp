package com.jr.tdl.main.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.jr.tdl.main.persistence.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepo;

    @BeforeEach
    void init(){
        var user1 = new User();

        user1.setFirstName("user1-firstname");
        user1.setSecondName("user1-secondName");
        user1.setUserName("user1");
        user1.setPassword("user1Passwd");
        user1.setEmail("user1@domain.com");

        userRepo.saveAndFlush(user1);

    }

    @Test
    public void testUserDbIntegration(){
       List<User> userRepoAllItemsList = userRepo.findAll();

       assertEquals(1, userRepoAllItemsList.size());
    }


}
