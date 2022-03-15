package com.jamel.pi.services.post;

import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import com.jamel.pi.mappers.MapStructMapper;
import com.jamel.pi.repositories.EmployeeRepository;
import com.jamel.pi.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Post_service_implementation implements Post_service {

    MapStructMapper mapStructMapper;
    PostRepository postRepository;
    EmployeeRepository employeeRepository;

    public Post_service_implementation(MapStructMapper mapStructMapper,
                                       PostRepository postRepository,
                                       EmployeeRepository employeeRepository)
    {
        this.mapStructMapper = mapStructMapper;
        this.postRepository = postRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public PostDto create_post(String c, Long id) {

        Post p = new Post(c);

        Employee e = employeeRepository.getById(id);

        p.setEmployee(e);

        postRepository.save(p);

        PostDto p_dto = mapStructMapper.postToPostDto(p);

        p_dto.setEmployeeDto(mapStructMapper.employeeToEmployeeDto(e));

        return p_dto;
    }

    @Override
    public String update_post(Long id, String c) {

        Post p = postRepository.getById(id);

        p.setContent(c);

        postRepository.save(p);

        return "updated with success";
    }

    @Override
    public PostDto retrieve_post(Long id) {

        Post p = postRepository.getById(id);

        Employee e = employeeRepository.getById(p.getEmployee());

        PostDto p_dto = mapStructMapper.postToPostDto(p);

        p_dto.setEmployeeDto(mapStructMapper.employeeToEmployeeDto(e));

        return p_dto;
    }

    @Override
    public String remove_post(Long id) {
        postRepository.deleteById(id);
        return "removed with success";
    }

    @Override
    public List<Post> retrieve_all_posts(Long id) {
        List<Post> posts = postRepository.findByEmployee_Id(id);
        return posts;
    }

    @Override
    public String delete_all_posts_of_employee(Long id) {

        Employee e = employeeRepository.getById(id);

        Set<Post> posts = e.getPosts();

        for (Post p : posts)
        {
            postRepository.delete(p);
        }

        posts.clear();

        e.setPosts(posts);

        return "all removed !";
    }
}
