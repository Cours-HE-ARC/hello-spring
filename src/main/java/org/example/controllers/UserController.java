package org.example.controllers;

import org.example.services.posts.Post;
import org.example.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

  /*  @GetMapping
    public ResponseEntity<List<User>> getAllPosts(){

        return ResponseEntity.ok(postsService.getAllPosts());
    }*/
}
