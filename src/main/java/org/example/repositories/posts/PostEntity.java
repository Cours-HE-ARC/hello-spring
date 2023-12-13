package org.example.repositories.posts;

import jakarta.persistence.*;
import org.example.repositories.users.UserEntity;
import org.example.services.posts.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

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


    private String content;


    public PostEntity(String content, Date date, UserEntity user) {
        this.content = content;
        this.date = date;
        this.user = user;
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


}
