package org.example.services.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.repositories.posts.PostEntity;

import java.util.Date;


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

    public String getUtilisateur() {
        return utilisateur;
    }

    private String content;

    private String utilisateur;

    public Post(String content, String utilisateur, Date date) {
        this.content = content;
        this.utilisateur = utilisateur;
        this.date = date;
    }



    public static Post fromEntity(PostEntity postEntity){
        return new Post(postEntity.getContent(), postEntity.getUtilisateur(),postEntity.getDate());
    }

    public static PostEntity toEntity(Post post){
        return new PostEntity(post.getContent(), post.getUtilisateur(), post.getDate());
    }




}
