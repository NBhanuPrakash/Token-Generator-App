package com.NNTeachie.service;

import com.NNTeachie.dtos.RegisterAccountRequest;
import com.NNTeachie.model.UsersTokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserVerfication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService service;

    @Autowired
    private UserRepoImpl repo;


    public String verfyUser(RegisterAccountRequest request) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        if (authenticate.isAuthenticated()) {
            return service.generateToken(request.getUserName());
        }
        return "Failed";
    }
}
