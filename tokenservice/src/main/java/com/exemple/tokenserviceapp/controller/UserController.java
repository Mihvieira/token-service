package com.exemple.tokenserviceapp.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.tokenserviceapp.entities.User;
import com.exemple.tokenserviceapp.repository.UserRepository;
import com.exemple.tokenserviceapp.service.AuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
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
    

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody Credential credential) throws InterruptedException {
        User user = authenticationService.authenticateUser(credential.getUsername().toLowerCase(), credential.getPassword());
        TimeUnit.MILLISECONDS.sleep(1000);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> issueToken(User user) {
        return ResponseEntity.ok().body("token");
    }

    public ResponseEntity<String> requestToken(Credential credential) {
        return ResponseEntity.ok().body("token");
    }
}
