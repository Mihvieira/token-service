package com.exemple.tokenservice.entities;

import java.time.Instant;

public class UserToken {

    private String token;
    private String userId;

    public UserToken(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return this.token;
    }

    public String setToken(String userId){
        Instant instNow = Instant.now();
        return this.userId + instNow.toString();
    }

}
