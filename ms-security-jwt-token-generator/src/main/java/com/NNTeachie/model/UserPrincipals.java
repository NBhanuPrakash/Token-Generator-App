package com.NNTeachie.model;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserPrincipals implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> roles;
    private boolean isBlocked;
    // Flag to check if the user is blocked



    public UserPrincipals(UsersTokens userDetails) {
        this.userName = userDetails.getUsername();
        this.password = userDetails.getPasswordHash();
        this.isBlocked = userDetails.getActive();
        // You can also initialize roles based on your application logic
        this.roles = Arrays.stream(userDetails.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // A user is enabled only if they are not blocked
        return isBlocked;
    }
}


