package com.exemple.tokenserviceapp.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.tokenserviceapp.entities.User;
import com.exemple.tokenserviceapp.repository.UserRepository;
import com.exemple.tokenserviceapp.service.AuthenticationService;
import com.exemple.tokenserviceapp.service.UserTokenGenerator;

import jakarta.transaction.Transactional;




@RestController
@RequestMapping("login")
public class UserController {
    
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserRepository repository;
    
    @GetMapping("/{username}")
    public ResponseEntity getUserDetails(@PathVariable String username){
        var user = repository.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
    

    @PostMapping
    public ResponseEntity<User> authenticate(@RequestBody Credential credential) throws InterruptedException {
        User user = authenticationService.authenticateUser(credential.getUsername(), credential.getPassword());
        TimeUnit.MILLISECONDS.sleep(1000);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/new-user")
    @Transactional
    public ResponseEntity createUser(@RequestBody Credential credential) {
        var user = repository.findByUsername(credential.getUsername());
        if (user != null) {
            throw new IllegalArgumentException("User alredy exists!");
        } else if (credential.getUsername().equalsIgnoreCase(credential.getPassword())) {
            throw new IllegalArgumentException("Username and password cannot be the same");
        } 
        else{
            User newUser = new User(credential.getUsername(), credential.getPassword());
            repository.save(newUser);
            return ResponseEntity.ok(newUser.getUsername());
        }
    }
    
    @GetMapping("token/{username}")
    public ResponseEntity<String> requestToken(@PathVariable String username) throws InterruptedException {
        var user = repository.findByUsername(username);
        TimeUnit.MILLISECONDS.sleep(1000);
        if (user != null) {
            var tokenService = new UserTokenGenerator();
            tokenService.setToken(username);
            return ResponseEntity.ok(tokenService.getToken());
        } else{
            return ResponseEntity.badRequest().build();
        }
    }
}
