package com.NNTeachie.controller;

import com.NNTeachie.model.UserDetails;
import com.NNTeachie.service.JwtService;
import com.NNTeachie.service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserController {

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public JwtService jwtService;

    @GetMapping("/user-details")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserDetails> getUserData(@RequestHeader("Authorization") String authheader){
        String token = authheader.substring(7);
        String userName = jwtService.extractUserName(token);
        log.info("User name: {}",userName);
        return ResponseEntity.ok(userDetailsService.getUser(userName));
    }
}
