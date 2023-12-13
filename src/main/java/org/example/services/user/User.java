package org.example.services.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.example.repositories.posts.PostEntity;
import org.example.repositories.users.UserEntity;
import org.example.services.posts.Post;


public class User {


    private String username;

    public User(){}
    public User(String username){
        this.username = username;
    }

    public static User fromEntity(UserEntity userEntity) {

        return new User(userEntity.getUsername());
    }

    public String getUsername(){
        return this.username;
    }

    public static UserEntity toEntity(User user){
        return new UserEntity(user.getUsername());
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
