package com.NNTeachie.service;

import com.NNTeachie.repository.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetails userDetails;

    public void saveUserDetails(String email){
        com.NNTeachie.model.UserDetails userDetails1 = new com.NNTeachie.model.UserDetails();
        userDetails1.setUserName(email);
        userDetails1.setFullName(email.split("@")[0]);
        userDetails1.setDesignation("Software Engineer");
        userDetails1.setArticles(ThreadLocalRandom.current().nextLong(1,100));
        userDetails1.setFollowers(ThreadLocalRandom.current().nextLong(1,20000));
        userDetails1.setRating(ThreadLocalRandom.current().nextDouble(1,10));
        userDetails.save(userDetails1);
    }

    public com.NNTeachie.model.UserDetails getUser(String username){
        return userDetails.findByUserName(username);
    }
}
