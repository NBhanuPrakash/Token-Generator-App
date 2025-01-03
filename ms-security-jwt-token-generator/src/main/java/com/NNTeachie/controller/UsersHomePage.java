package com.NNTeachie.controller;

import com.NNTeachie.dtos.RegisterAccountRequest;
import com.NNTeachie.service.UserRegisterService;
import com.NNTeachie.service.UserVerfication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsersHomePage {

    @Autowired
    private UserRegisterService service;

    @Autowired
    private UserVerfication userVerfication;

    @PostMapping("/register")
    public ResponseEntity<Void> registerAccount(@RequestBody RegisterAccountRequest request) {
        service.createUsers(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody RegisterAccountRequest request) {
        String s = userVerfication.verfyUser(request);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin access granted!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userAccess() {
        return "User access granted!";
    }
}
