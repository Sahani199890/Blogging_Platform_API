package com.example.bloggingPlatformAPI.service;

import com.example.bloggingPlatformAPI.dao.CommentsRepo;
import com.example.bloggingPlatformAPI.model.Comments;
import com.example.bloggingPlatformAPI.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentsRepo commentsRepo;
    public int addComment(Comments comments) {
        Comments save = commentsRepo.save(comments);
        return save.getCommentId();
    }

    public String readComment(Integer commentId) {
        if(commentsRepo.findById(commentId).isPresent()) {
            Comments comments = commentsRepo.findById(commentId).get();
            return comments.toString();
        }
        return "please enter valid commentId";
    }

    public List<Comments> readAllComments() {
        return commentsRepo.findAll();
    }

    public boolean updateComment(Integer commentId, Comments comment) {
        if(commentsRepo.findById(commentId).isPresent()){
            Comments comments=commentsRepo.findById(commentId).get();
            comments.setComments(comment.getComments());
            UserModel receiver = comment.getReceiver();
            comments.setReceiver(receiver);
            UserModel sender=comment.getSender();
            comments.setSender(sender);
            commentsRepo.save(comments);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteComment(Integer commentId) {
        if(commentsRepo.findById(commentId).isPresent()){
            commentsRepo.deleteById(commentId);
            return true;
        }
        return false;
    }
}
