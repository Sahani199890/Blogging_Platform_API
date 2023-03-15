package com.example.bloggingPlatformAPI.dao;

import com.example.bloggingPlatformAPI.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments,Integer> {
}
