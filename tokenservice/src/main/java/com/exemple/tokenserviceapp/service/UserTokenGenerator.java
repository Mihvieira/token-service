package com.exemple.tokenserviceapp.service;

import org.springframework.stereotype.Service;

import java.time.Instant;


public class UserTokenGenerator {

    private String token;
    private Long userId;

    public UserTokenGenerator(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return this.token;
    }

    public String setToken(Long userId){
        Instant instNow = Instant.now();
        this.token = this.userId.toString() + instNow.toString();
        return this.token;
    }

}
