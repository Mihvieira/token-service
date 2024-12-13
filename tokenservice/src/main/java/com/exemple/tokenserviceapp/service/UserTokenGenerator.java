package com.exemple.tokenserviceapp.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserTokenGenerator {

    private String token;

    public UserTokenGenerator() {
    }

    public String getToken() {
        return this.token;
    }

    public String setToken(String userId){
        Instant instNow = Instant.now();
        this.token = userId + instNow.toString();
        return this.token;
    }

}
