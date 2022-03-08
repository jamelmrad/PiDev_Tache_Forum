package com.jamel.pi.controllers;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.dto.EmployeeDto;
import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import com.jamel.pi.mappers.MapStructMapper;
import com.jamel.pi.repositories.CommentRepository;
import com.jamel.pi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private MapStructMapper mapStructMapper;
    private CommentRepository commentRepository;
    PostRepository postRepository;

    @Autowired
    public CommentController (MapStructMapper mapStructMapper,CommentRepository commentRepository){
        this.mapStructMapper = mapStructMapper;
        this.commentRepository = commentRepository;
    }

    //create comment ***works*** BUT U CAN USE THIS ONLYYYY IN POST CONTROLLER OR U GET NULL VALUE OF post_id
    @PostMapping()
    public CommentDto createComment(@RequestBody String k, Post post) {
        Date d = new Date();
        Comment h = new Comment(k,d,post);
        Comment com = commentRepository.save(h);
        CommentDto x = mapStructMapper.commentToCommentDto(com);
        x.setId(com.getId());
        x.setContent(com.getContent());
        x.setPosted_at(com.getPosted_at());
        return x;
    }


    //retrieve comment by id ***works***
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "id") Long id) {
        Comment our_p = commentRepository.getById(id);
        CommentDto p_dto = mapStructMapper.commentToCommentDto(our_p);
        p_dto.setId(our_p.getId());
        p_dto.setContent(our_p.getContent());
        p_dto.setPosted_at(our_p.getPosted_at());

        return new ResponseEntity<>(p_dto,HttpStatus.OK);
    }

    //retrieve comments list by post id ***works***
    @GetMapping("/{post_id}/allposts")
    public ResponseEntity<List<Comment>> getAllPostsByEmployeeId(@PathVariable(value = "post_id") Long id) {
        List<Comment> comments = commentRepository.findByPost_Id(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    //update comment ***works***
    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id, @RequestBody String c) {
        Comment comment = commentRepository.getById(id);
        comment.setContent(c);
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }

    //delete comment ***works***
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") Long id) {
        commentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //delete all comments of a post ***works***
    @DeleteMapping("/{post_id}/delete/allcommen²ts")
    public ResponseEntity<List<Comment>> deleteAllCommentsofPost(@PathVariable(value = "post_id") Long id) {
        List<Comment> comments = commentRepository.findByPost_Id(id);
        commentRepository.deleteAll(comments);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
