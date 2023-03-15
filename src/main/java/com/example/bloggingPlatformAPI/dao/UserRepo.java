package com.example.bloggingPlatformAPI.dao;

import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserModel,Integer> {

    @Query(value = "select * from user_model where user_name=:userName",nativeQuery = true)
    List<UserModel> findByUserName(String userName);
}
