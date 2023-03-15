package com.example.bloggingPlatformAPI.service;

import com.example.bloggingPlatformAPI.dao.FollowRepo;
import com.example.bloggingPlatformAPI.dao.UserRepo;
import com.example.bloggingPlatformAPI.model.Follow;
import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowRepo followRepo;
    @Autowired
    private UserRepo userRepo;
    public String followings(Integer id1,Integer id2) {
        if(userRepo.findById(id1).isPresent() && userRepo.findById(id2).isPresent()){
            UserModel userModel = userRepo.findById(id2).get();
            UserModel userModel1 = userRepo.findById(id1).get();
            Follow follow=new Follow();
            follow.setFollowingUsers(userModel);
            follow.setUser(userModel1);
            Follow save = followRepo.save(follow);
            return save.toString();
        }
        else if(!userRepo.findById(id1).isPresent()){
            return "user 1 is not in the database";
        }
        else if(!userRepo.findById(id2).isPresent()) {
            return "user 2 is not in the database";
        }
        return "user 1 and user 2 are not in the database";
    }

    public Follow watchFollowers(Integer yourId) {
        if(userRepo.findById(yourId).isPresent()) {
            return followRepo.findById(yourId).get();
        }
        return null;
    }
}
