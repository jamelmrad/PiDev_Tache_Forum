package com.jamel.pi.controllers;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.services.comment.Comment_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private Comment_service service;

    //create comment
    @PostMapping("/{id}/add_comment")
    public CommentDto createComment(@RequestBody String c, @PathVariable(value = "id") Long id) {

        return service.create_comment(c,id);
    }


    //retrieve comment by id ***works***
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "id") Long id) {

        return new ResponseEntity<>(service.retrieve_comment(id),HttpStatus.OK);
    }

    //retrieve comments list by post id ***works***
    @GetMapping("/{post_id}/all_comments")
    public ResponseEntity<List<Comment>> getAllPostsByEmployeeId(@PathVariable(value = "post_id") Long id) {

        return new ResponseEntity<>(service.retrieve_all_comments(id), HttpStatus.OK);
    }

    //update comment ***works***
    @PutMapping("/comment/update/{id}")
    public ResponseEntity<String> updateComment(@PathVariable("id") Long id, @RequestBody String c) {

        return new ResponseEntity<>(service.update_comment(id, c), HttpStatus.OK);
    }

    //delete comment ***works***
    @DeleteMapping("/comment/delete/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id) {
        service.remove_Comment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //delete all comments of a post ***works***
    @DeleteMapping("/{post_id}/delete/all_comments")
    public ResponseEntity<List<Comment>> deleteAllCommentsofPost(@PathVariable(value = "post_id") Long id) {
        service.delete_all_comments_of_post(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
