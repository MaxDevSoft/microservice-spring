package com.studymicroservice.controls;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.studymicroservice.dtos.UserRecordDto;
import com.studymicroservice.models.UserModel;
import com.studymicroservice.services.UserService;

import jakarta.validation.Valid;


@Controller
public class UserController {

    @Autowired
    UserService us;
    
    @PostMapping("/adduser")
    public ResponseEntity<UserModel> addUser (@RequestBody @Valid UserRecordDto userRecordDto){

        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(us.save(userModel));

    }

}
