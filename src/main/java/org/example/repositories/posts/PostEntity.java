package org.example.repositories.posts;

import jakarta.persistence.*;
import org.example.services.posts.Post;

import java.util.Date;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PostEntity() {
    }



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

    public PostEntity(String content, String utilisateur, Date date) {
        this.content = content;
        this.utilisateur = utilisateur;
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }
}
