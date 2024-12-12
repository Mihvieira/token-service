package com.exemple.tokenserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exemple.tokenserviceapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE username = :username")
    User findByUsername(String username);

}