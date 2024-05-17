package com.studymicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studymicroservice.models.UserModel;
import com.studymicroservice.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    @Transactional
    public UserModel save (UserModel userModel){

        return ur.save(userModel);

    }
    
}
