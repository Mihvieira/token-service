package com.exemple.tokenservice.controller;

import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import com.exemple.tokenservice.entities.User;

public class UserController {

    public void authenticate(Credential credential) {
        return User;
    }

    public void issueToken(User user) {
        return UserToken;
    }

    public void requestToken(Credential credential) {
        return UserToken;
    }
}
