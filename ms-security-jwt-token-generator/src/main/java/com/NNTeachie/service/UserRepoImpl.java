package com.NNTeachie.service;

import com.NNTeachie.model.UserPrincipals;
import com.NNTeachie.model.UsersTokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepoImpl implements UserDetailsService {
    @Autowired
    private UserValidator validator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersTokens byUserName = validator.getUserValidator(username);
        if (byUserName == null) {
            throw new UsernameNotFoundException("User Not Exits");
        }
        return new UserPrincipals(byUserName);
    }
}
