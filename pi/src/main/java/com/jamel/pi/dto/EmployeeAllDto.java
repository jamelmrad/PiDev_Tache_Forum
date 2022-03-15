package com.jamel.pi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jamel.pi.entities.Post;
import jdk.net.SocketFlow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//show all posts
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAllDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("posts")
    private Set<PostDto> posts;

    /*********************************************getters-setters*****************************************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDto> posts) {
        this.posts = posts;
    }
}
