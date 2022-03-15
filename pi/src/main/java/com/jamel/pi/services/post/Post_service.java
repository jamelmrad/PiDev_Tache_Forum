package com.jamel.pi.services.post;

import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public interface Post_service {

     PostDto create_post(String c, Long id);

     String update_post(Long id, String c);

     PostDto retrieve_post(Long id);

     String remove_post(Long id);

     List<Post> retrieve_all_posts(Long id);

     String delete_all_posts_of_employee(Long id);
}
