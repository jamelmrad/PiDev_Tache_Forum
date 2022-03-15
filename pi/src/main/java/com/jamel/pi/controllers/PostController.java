package com.jamel.pi.controllers;


import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jamel.pi.services.post.Post_service;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private Post_service service_p;

    /****************CREATE post-works************************/

    @PostMapping("/{id}/add_post")
    public PostDto createPost(@RequestBody String c, @PathVariable(value = "id") Long id) {
        return service_p.create_post(c,id);
    }

    /****************RETRIEVE post-works************************/

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(value = "id") Long id) {

        return new ResponseEntity<>(service_p.retrieve_post(id),HttpStatus.OK);
    }

    /****************RETRIEVE all posts by employee id-works************************/

    @GetMapping("/{employee_id}/all_posts")
    public ResponseEntity<List<Post>> getAllPostsByEmployeeId(@PathVariable(value = "employee_id") Long id) {

        return new ResponseEntity<>(service_p.retrieve_all_posts(id), HttpStatus.OK);
    }

    /****************UPDATE post-works************************/

    @PutMapping("/post/update/{id}")
    public ResponseEntity<String> updatePost(@PathVariable("id") Long id, @RequestBody String c) {

        return new ResponseEntity<>(service_p.update_post(id, c), HttpStatus.OK);
    }

    /****************DELETE post-works************************/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id) {
        service_p.remove_post(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /****************DELETE all posts of employee-works************************/
    @DeleteMapping("/{employee_id}/delete/all_posts")
    public ResponseEntity<List<Post>> deleteAllPostsOfEmployee(@PathVariable(value = "employee_id") Long id) {
        service_p.delete_all_posts_of_employee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

