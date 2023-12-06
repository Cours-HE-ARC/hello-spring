package org.example.services.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Post() {

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

    public Post(String content, String utilisateur) {
        this.content = content;
        this.utilisateur = utilisateur;
    }

    public static Post create(String user, String content){
        return new Post(content,user);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
