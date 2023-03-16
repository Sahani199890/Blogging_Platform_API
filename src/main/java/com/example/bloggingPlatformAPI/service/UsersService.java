package com.example.bloggingPlatformAPI.service;

import com.example.bloggingPlatformAPI.dao.PostRepo;
import com.example.bloggingPlatformAPI.dao.UserRepo;
import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;

    public String addUser(UserModel userModel){
        List<UserModel> byUserName = userRepo.findByUserName(userModel.getUserName());
        String number = userModel.getNumber();
        for(int i=0;i<number.length();i++){
            if(!Character.isDigit(number.charAt(i))){
                return "number";
            }
        }
        if(byUserName.isEmpty()){
            UserModel save = userRepo.save(userModel);
            return "true";
        }
        return "false";
    }

}
