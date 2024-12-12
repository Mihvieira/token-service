package com.exemple.tokenserviceapp.dto;

import org.springframework.beans.BeanUtils;

import com.exemple.tokenserviceapp.entities.User;

import jakarta.validation.constraints.NotBlank;

public class UserDataDTO{

    @NotBlank
    String username;
    @NotBlank
    String password;

    public UserDataDTO(User entity) {
        BeanUtils.copyProperties(entity, this);
    }

}