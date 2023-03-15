package com.example.bloggingPlatformAPI.controller;

import com.example.bloggingPlatformAPI.model.Comments;
import com.example.bloggingPlatformAPI.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("add-comment")
    public ResponseEntity<String> addComment(@Valid @RequestBody Comments comments){
        int id=commentService.addComment(comments);
        return new ResponseEntity<>("comment saved with id-->"+id, HttpStatus.CREATED);
    }
    @GetMapping("read-comment/{commentId}")
    public ResponseEntity<String> readComment(@PathVariable Integer commentId){
        if(commentId!=null) {
            String comments = commentService.readComment(commentId);
            return new ResponseEntity<>(comments,HttpStatus.FOUND);
        }
        return new ResponseEntity<>("please enter valid commentId",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("read-all-comments")
    public ResponseEntity<List<Comments>> readAllComments(){
        List<Comments> commentsList=commentService.readAllComments();
        return new ResponseEntity<>(commentsList,HttpStatus.FOUND);
    }
    @PutMapping("update-comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Integer commentId,@RequestBody Comments comment){
        boolean ans = commentService.updateComment(commentId, comment);
        if(ans){
            return new ResponseEntity<>("update successfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("please enter valid commentId",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("delete-comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId){
        boolean ans=commentService.deleteComment(commentId);
        if(ans){
            return new ResponseEntity<>("comment deleted with id"+commentId,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("please enter valid commentId",HttpStatus.BAD_REQUEST);
    }
}
