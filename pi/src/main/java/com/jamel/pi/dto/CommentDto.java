package com.jamel.pi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamel.pi.entities.Post;
import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("content")
    private String Content;

    @JsonProperty("posted_at")
    private Date posted_at;

    @JsonProperty("post")
    private PostDto postDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }
}
