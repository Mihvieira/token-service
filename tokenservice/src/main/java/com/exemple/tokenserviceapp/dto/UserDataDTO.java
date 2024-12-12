package com.exemple.tokenserviceapp.dto;

import com.exemple.tokenserviceapp.entities.User;

public class UserDataDTO {

    String username;
    String password;

    public UserDataDTO() {
    }

    public static User getUser(String username, String password){
        User user = new User(username, password);
        return user;
    }

    
} 