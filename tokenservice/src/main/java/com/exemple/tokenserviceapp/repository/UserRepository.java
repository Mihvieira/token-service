package com.exemple.tokenserviceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.tokenserviceapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

}
