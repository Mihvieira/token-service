package com.exemple.tokenserviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.tokenserviceapp.entities.User;
import com.exemple.tokenserviceapp.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
  
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        } else if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password");
        } else {
            return user;
        }
    }

    /*public String issueToken(User user) {
        return UserToken;
    }

    public void requestToken(Credential credential) {
        return UserToken;
    }*/

}
