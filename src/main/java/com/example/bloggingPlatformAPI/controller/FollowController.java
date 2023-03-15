package com.example.bloggingPlatformAPI.controller;

import com.example.bloggingPlatformAPI.model.Follow;
import com.example.bloggingPlatformAPI.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowController {
    @Autowired
    private FollowService followService;
    @PostMapping("follow/{yourId}/{friendsId}")
    public ResponseEntity<String> followings(@PathVariable Integer yourId,@PathVariable Integer friendsId){
        String followings = followService.followings(yourId, friendsId);
        if(!followings.equals("user 1 is not in the database") && !followings.equals("user 2 is not in the database")){
            return new ResponseEntity<>(followings, HttpStatus.OK);
        }
        return new ResponseEntity<>(followings,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("watch-my-followers/{yourId}")
    public ResponseEntity<String> watchFollowers(@PathVariable Integer yourId){
        Follow list= followService.watchFollowers(yourId);
        if(list!=null) {
            return new ResponseEntity<>(list.toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Either the person is not in the database or he is not following anybody",HttpStatus.BAD_REQUEST);
    }
}
