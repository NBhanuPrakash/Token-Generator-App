package com.NNTeachie.service;

import com.NNTeachie.model.UsersTokens;
import com.NNTeachie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    @Autowired
    private UserRepository repo;

    public UsersTokens getUserValidator(String userName) {
        return repo.findByUsername(userName);
    }
}
