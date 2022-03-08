package com.jamel.pi.mappers;

import com.jamel.pi.dto.*;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    //converting entities into DTOs
    EmployeeDto employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    PostDto postToPostDto(Post post);

    //Post postDtoToPost(PostDto postDto);


    //retrieving
    CommentDto commentToCommentDto(Comment comment);

    EmployeeAllDto employeeToEmployeeAllDto(Employee employee);

    PostAllDto postToPostAllDto(Post post);

    List<EmployeeAllDto> employeeToEmployeeAllDto(List<Employee> employees);

    List<PostAllDto> postToPostAllDto(List<Post> posts);
}
