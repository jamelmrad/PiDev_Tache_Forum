package com.jamel.pi.services.comment;

import com.jamel.pi.dto.CommentDto;
import com.jamel.pi.entities.Comment;
import com.jamel.pi.entities.Post;

import java.util.List;

public interface Comment_service {

    public CommentDto create_comment(String c, Long id);

    public String update_comment(Long id, String c);

    public CommentDto retrieve_comment(Long id);

    public String remove_Comment(Long id);

    public List<Comment> retrieve_all_comments(Long id);

    public String delete_all_comments_of_post(Long id);
}
