package com.example.bloggingPlatformAPI.dao;

import com.example.bloggingPlatformAPI.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepo extends JpaRepository<Follow,Integer> {
}
