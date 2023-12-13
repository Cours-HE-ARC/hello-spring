package org.example.services.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.repositories.posts.PostEntity;
import org.example.services.user.User;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Post {




    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    private String content;

    private User utilisateur;

    public Post(String content, User utilisateur, Date date) {
        this.content = content;
        this.utilisateur = utilisateur;
        this.date = date;
    }



    public static Post fromEntity(PostEntity postEntity){

        return new Post(postEntity.getContent(), User.fromEntity(postEntity.getUser()),postEntity.getDate());
    }

    public static PostEntity toEntity(Post post){
        return new PostEntity(post.getContent(),  post.getDate(), null);
    }




}
