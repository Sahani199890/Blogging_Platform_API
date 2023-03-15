package com.example.bloggingPlatformAPI.controller;

import com.example.bloggingPlatformAPI.model.UserModel;
import com.example.bloggingPlatformAPI.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;
    @PostMapping("add-Users")
    public ResponseEntity<String> addUser(@Valid  @RequestBody UserModel userModel){
        String ans = usersService.addUser(userModel);
        if(ans.equals("true")) {
            return new ResponseEntity<>("User Saved with Id -->" + userModel.getUserId(), HttpStatus.CREATED);
        }
        else if(ans.equals("number")){
            return new ResponseEntity<>("please enter digits only",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("userName already exist please change userName",HttpStatus.BAD_REQUEST);
    }
}
