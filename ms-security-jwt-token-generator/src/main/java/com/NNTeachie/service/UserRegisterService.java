package com.NNTeachie.service;

import com.NNTeachie.dtos.RegisterAccountRequest;
import com.NNTeachie.model.UsersTokens;
import com.NNTeachie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserRegisterService {

    private static long idCounter = 1L;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserValidator userValidator;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void createUsers(RegisterAccountRequest request) {
//        UsersTokens authenticated = userValidator.getUserValidator(request.getUserName());
//        if (authenticated == null) {
            UsersTokens usersTokens = userRegisterDetails(request);
            UsersTokens save = repository.save(usersTokens);
//        }
//        throw new UsernameNotFoundException("User Name Already Exits");

    }

    private UsersTokens userRegisterDetails(RegisterAccountRequest request) {

        UsersTokens userRegister = new UsersTokens();
        userRegister.setUserId(generateUniqueId());
        userRegister.setUsername(request.getUserName());
        userRegister.setPasswordHash(encoder.encode(request.getPassword()));
        userRegister.setIssuedAt(LocalDateTime.now());
        userRegister.setExpiresAt(LocalDateTime.now().plusDays(90));
        userRegister.setScope("security.READ");
        userRegister.setActive(Boolean.TRUE);
        userRegister.setRoles(request.getRoles() != null ? request.getRoles() : "ADMIN");
        return userRegister;


    }

    private Integer generateUniqueId() {
        return ThreadLocalRandom.current().nextInt(1000, 10000);
    }
}
