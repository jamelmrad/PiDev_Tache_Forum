package com.jamel.pi.services.comment;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.entities.Post;
import com.jamel.pi.mappers.MapStructMapper;
import com.jamel.pi.repositories.CommentRepository;
import com.jamel.pi.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class Comment_service_implementation implements Comment_service{

    MapStructMapper mapStructMapper;
    CommentRepository commentRepository;
    PostRepository postRepository;

    public Comment_service_implementation(MapStructMapper mapStructMapper,
                                          CommentRepository commentRepository,
                                          PostRepository postRepository)
    {
        this.mapStructMapper = mapStructMapper;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto create_comment(String c, Long id) {

        Comment comment = new Comment(c);

        Post p = postRepository.getById(id);

        comment.setPost(p);

        commentRepository.save(comment);

        CommentDto c_dto = mapStructMapper.commentToCommentDto(comment);

        c_dto.setPostDto(mapStructMapper.postToPostDto(p));

        return c_dto;
    }

    @Override
    public String update_comment(Long id, String c) {

        Comment comment = commentRepository.getById(id);

        comment.setContent(c);

        commentRepository.save(comment);

        return "updated with sucess";
    }

    @Override
    public CommentDto retrieve_comment(Long id) {

        Comment comment = commentRepository.getById(id);

        Post p = postRepository.getById(comment.getPost());

        CommentDto comment_dto = mapStructMapper.commentToCommentDto(comment);

        comment_dto.setPostDto(mapStructMapper.postToPostDto(p));

        return comment_dto;
    }

    @Override
    public String remove_Comment(Long id) {
        commentRepository.deleteById(id);
        return "removed with success";
    }

    @Override
    public List<Comment> retrieve_all_comments(Long id) {
        List<Comment> comments = commentRepository.findByPost_Id(id);
        return comments;
    }

    @Override
    public String delete_all_comments_of_post(Long id) {
        Post p = postRepository.getById(id);

        Set<Comment> comments = p.getComments();

        for ( Comment c : comments)
        {
            commentRepository.delete(c);
        }

        comments.clear();

        p.setComments(comments);

        return "all removed !";
    }
}
