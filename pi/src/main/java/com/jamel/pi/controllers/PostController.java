package com.jamel.pi.controllers;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.dto.PostAllDto;
import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import com.jamel.pi.mappers.MapStructMapper;
import com.jamel.pi.repositories.CommentRepository;
import com.jamel.pi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("posts")
public class PostController {

    private MapStructMapper mapStructMapper;
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public PostController(MapStructMapper mapStructMapper, PostRepository postRepository) {
        this.mapStructMapper = mapStructMapper;
        this.postRepository = postRepository;
    }

    //create post ***works*** BUT U CAN USE THIS ONLYYYY IN EMPLOYEE CONTROLLER OR U GET NULL VALUE OF employee_id
    @PostMapping("/add")
    public PostDto createPost(@RequestBody String c, Employee employee) {
        Post p = new Post(c);
        p.setEmployee(employee);
        postRepository.save(p);
        PostDto y = mapStructMapper.postToPostDto(p);
        y.setId(p.getId());
        y.setContent(p.getContent());
        y.setPosted_at(p.getPosted_at());
        return y;
    }

    //post now creates its own comments ***works***
    @PostMapping("/{id}/comments/add")
    public ResponseEntity<PostAllDto> addComment(@PathVariable(value = "id") Long id , @RequestBody String c) {

        CommentController commentController = new CommentController(mapStructMapper,commentRepository);

        Post our_e;
        our_e = postRepository.getById(id);

        System.out.println(our_e);
        CommentDto p = commentController.createComment(c, our_e);

        PostAllDto e = mapStructMapper.postToPostAllDto(our_e);

        e.setId(our_e.getId());
        e.setContent(our_e.getContent());
        e.setPosted_at(our_e.getPosted_at());

        return new ResponseEntity<>(e,HttpStatus.OK);
    }

    //retrieve post by id ***works***
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(value = "id") Long id) {
        Post our_p = postRepository.getById(id);
        PostDto p_dto = mapStructMapper.postToPostDto(our_p);
        p_dto.setId(our_p.getId());
        p_dto.setContent(our_p.getContent());
        p_dto.setPosted_at(our_p.getPosted_at());

        return new ResponseEntity<>(p_dto,HttpStatus.OK);
    }

    //retrieve posts list by employee id ***works***
    @GetMapping("/{employee_id}/allposts")
    public ResponseEntity<List<Post>> getAllPostsByEmployeeId(@PathVariable(value = "employee_id") Long id) {
        List<Post> posts = postRepository.findByEmployee_Id(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //update post ***works***
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody String c) {
        Post post = postRepository.getById(id);
        post.setContent(c);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
    }

    //delete post ***works***
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id) {
        postRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //delete all posts of a user ***works***
    @DeleteMapping("/{employee_id}/delete/allposts")
    public ResponseEntity<List<Post>> deleteAllPostsOfEmployee(@PathVariable(value = "employee_id") Long id) {
        List<Post> posts = postRepository.findByEmployee_Id(id);
        postRepository.deleteAll(posts);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

