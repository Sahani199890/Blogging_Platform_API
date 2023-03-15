package com.example.bloggingPlatformAPI.dao;

import com.example.bloggingPlatformAPI.model.PostModel;
import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<PostModel,Integer> {
    @Query(value = "select * from post_model where user_id_user_id=:userId",nativeQuery = true)
    List<PostModel> findPostByUserId(UserModel userId);
}
