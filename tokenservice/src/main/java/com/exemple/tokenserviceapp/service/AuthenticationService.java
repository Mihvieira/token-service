package com.exemple.tokenserviceapp.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.tokenserviceapp.entities.User;
import com.exemple.tokenserviceapp.repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
  
    public User authenticateUser(String username, String password) throws InterruptedException {
        User user = userRepository.findByUsername(username);
        TimeUnit.MILLISECONDS.sleep(5000);
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
