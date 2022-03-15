package com.jamel.pi.mappers;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.dto.EmployeeAllDto;
import com.jamel.pi.dto.EmployeeDto;
import com.jamel.pi.dto.PostAllDto;
import com.jamel.pi.dto.PostDto;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.entities.Employee;
import com.jamel.pi.entities.Post;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T11:45:39+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_60 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;

        id = employee.getId();
        nom = employee.getNom();
        prenom = employee.getPrenom();

        EmployeeDto employeeDto = new EmployeeDto( id, nom, prenom );

        return employeeDto;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        return employee;
    }

    @Override
    public PostDto postToPostDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setPosted_at( post.getPosted_at() );
        postDto.setContent( post.getContent() );
        postDto.setId( post.getId() );

        return postDto;
    }

    @Override
    public Employee mapEmp(Long value) {
        if ( value == null ) {
            return null;
        }

        Employee employee = new Employee();

        return employee;
    }

    @Override
    public Post mapPos(Long value) {
        if ( value == null ) {
            return null;
        }

        Post post = new Post();

        return post;
    }

    @Override
    public CommentDto commentToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( comment.getId() );
        commentDto.setContent( comment.getContent() );
        commentDto.setPosted_at( comment.getPosted_at() );

        return commentDto;
    }

    @Override
    public EmployeeAllDto employeeToEmployeeAllDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeAllDto employeeAllDto = new EmployeeAllDto();

        employeeAllDto.setId( employee.getId() );
        employeeAllDto.setNom( employee.getNom() );
        employeeAllDto.setPrenom( employee.getPrenom() );
        employeeAllDto.setPosts( postSetToPostDtoSet( employee.getPosts() ) );

        return employeeAllDto;
    }

    @Override
    public PostAllDto postToPostAllDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostAllDto postAllDto = new PostAllDto();

        postAllDto.setId( post.getId() );
        postAllDto.setContent( post.getContent() );
        postAllDto.setPosted_at( post.getPosted_at() );
        postAllDto.setComments( commentSetToCommentDtoSet( post.getComments() ) );

        return postAllDto;
    }

    @Override
    public List<EmployeeAllDto> employeeToEmployeeAllDto(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeAllDto> list = new ArrayList<EmployeeAllDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( employeeToEmployeeAllDto( employee ) );
        }

        return list;
    }

    @Override
    public List<PostAllDto> postToPostAllDto(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostAllDto> list = new ArrayList<PostAllDto>( posts.size() );
        for ( Post post : posts ) {
            list.add( postToPostAllDto( post ) );
        }

        return list;
    }

    protected Set<PostDto> postSetToPostDtoSet(Set<Post> set) {
        if ( set == null ) {
            return null;
        }

        Set<PostDto> set1 = new HashSet<PostDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Post post : set ) {
            set1.add( postToPostDto( post ) );
        }

        return set1;
    }

    protected Set<CommentDto> commentSetToCommentDtoSet(Set<Comment> set) {
        if ( set == null ) {
            return null;
        }

        Set<CommentDto> set1 = new HashSet<CommentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Comment comment : set ) {
            set1.add( commentToCommentDto( comment ) );
        }

        return set1;
    }
}
