package com.NNTeachie.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class RegisterAccountRequest {

    private String userName;

    private String password;

    private String roles;

    public RegisterAccountRequest() {
    }

    public RegisterAccountRequest(String userName, String password, String roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
