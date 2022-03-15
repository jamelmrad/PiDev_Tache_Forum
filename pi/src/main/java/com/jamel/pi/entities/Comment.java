package com.jamel.pi.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Basic
    @Column
    private String content;

    @Basic
    @Column
    @Temporal(TemporalType.DATE)
    private Date posted_at;

    @Autowired
    public Comment(String c){
        this.content = c;
        this.posted_at = new Date();
    }

    @Autowired
    public  Comment(String c, Date d, Post p) {
        this.content=c;
        this.posted_at=d;
        this.post=p;
    }

    public Comment(){
        this.content="noo";
        this.posted_at=new Date();
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" , nullable = false)
    Post post;

    public Long getPost() {
        return post.getId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
