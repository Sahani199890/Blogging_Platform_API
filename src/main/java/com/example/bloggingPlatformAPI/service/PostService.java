package com.example.bloggingPlatformAPI.service;

import com.example.bloggingPlatformAPI.dao.PostRepo;
import com.example.bloggingPlatformAPI.dao.UserRepo;
import com.example.bloggingPlatformAPI.model.PostModel;
import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    public int addPost(PostModel postModel) {
        PostModel save = postRepo.save(postModel);
        return save.getPostId();
    }

    public PostModel readPost(Integer postId) {
        return postRepo.findById(postId).get();
    }

    public List<PostModel> readAllPosts() {
        return postRepo.findAll();
    }

    public String updatePost(Integer postId,PostModel postModel) {
        if(postRepo.findById(postId).isPresent()){
            PostModel postModel1 = postRepo.findById(postId).get();
            postModel1.setPostDescription(postModel.getPostDescription());
            postModel1.setPostName(postModel.getPostName());
            PostModel save = postRepo.save(postModel1);
            return save.toString();
        }else{
            return "noData";
        }
    }

    public boolean deletePost(Integer postId) {
        if(postRepo.findById(postId).isPresent()){
            postRepo.deleteById(postId);
            return true;
        }
        return false;
    }

    public List<PostModel> postAndUsers(Integer userId) {
        if(userRepo.findById(userId).isPresent()) {
            UserModel userModel = userRepo.findById(userId).get();
            return postRepo.findPostByUserId(userModel);
        }
        else{
            return new ArrayList<>();
        }
    }
}
