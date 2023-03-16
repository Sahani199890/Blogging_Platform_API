package com.example.bloggingPlatformAPI.controller;

import com.example.bloggingPlatformAPI.model.PostModel;
import com.example.bloggingPlatformAPI.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("add-post")
    public ResponseEntity<String> addPost(@RequestBody PostModel postModel){
        int id=postService.addPost(postModel);
        return new ResponseEntity<>("Post saved with postId -->"+id, HttpStatus.CREATED);
    }
    @GetMapping("read-post/{postId}")
    public ResponseEntity<String> readPost(@PathVariable Integer postId){
        if(postId!=null){
            PostModel post=postService.readPost(postId);
            return new ResponseEntity<>(post.toString(),HttpStatus.FOUND);
        }
        else{
            return  new ResponseEntity<>("please enter valid postId",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("read-all-posts")
    public ResponseEntity<List<PostModel>> readAllPosts(){
        List<PostModel> postModels=postService.readAllPosts();
        return new ResponseEntity<>(postModels,HttpStatus.FOUND);
    }
    @PutMapping("update-post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Integer postId,@RequestBody PostModel postModel){
        String ans = postService.updatePost(postId,postModel);
        if(ans.equals("noData")){
            return new ResponseEntity<>("postId not found in the database please verify postId",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @DeleteMapping("delete-post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId){
        boolean ans=postService.deletePost(postId);
        if(ans){
            return new ResponseEntity<>("deleted Successful",HttpStatus.OK);
        }
        return new ResponseEntity<>("postId not found in the database please verify postId",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("post-user/{userId}")
    public ResponseEntity<List<PostModel>> postUser(@PathVariable Integer userId){
        List<PostModel> list=postService.postAndUsers(userId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
