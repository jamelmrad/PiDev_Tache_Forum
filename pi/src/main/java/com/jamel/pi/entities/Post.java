package com.jamel.pi.entities;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Basic
    @Column
    private String Content;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column
    private Date posted_at;

    public Post(String c){
        this.Content = c;
        this.posted_at = new Date();
    }

    public Post(Long id, String c, Date d){
        this.id =id;
        this.Content=c;
        this.posted_at=d;
    }
    public Post(){
        this.Content="no content";
        this.posted_at = new Date();
    }


    @OneToMany(fetch = FetchType.LAZY , mappedBy= "post")
           /* @JoinTable(
                    name = "post_comments",
                    joinColumns = @JoinColumn(name="post_id"),
                    inverseJoinColumns = @JoinColumn(name = "comment_id")
            )*/
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id" , nullable = false)
    Employee employee;
/////////////////////////////////////////////////////////////
    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public Long getEmployee() {
        return employee.getId();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
