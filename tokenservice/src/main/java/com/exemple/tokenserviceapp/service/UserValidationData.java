package com.exemple.tokenserviceapp.service;

import org.springframework.stereotype.Service;

import com.exemple.tokenserviceapp.entities.User;

@Service
public class UserValidationData {

    public User validateData(String username, String password){
        try {
            if (username.equalsIgnoreCase(password)) {
                throw new IllegalArgumentException("Username and password cannot be the same"); 
            } else {
                User userCreation = new User(username, password);
                return userCreation; 
            }

        } catch (Exception e) {
           return null;
        } 
    }
}
