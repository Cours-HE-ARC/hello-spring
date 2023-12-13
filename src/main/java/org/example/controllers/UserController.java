package org.example.controllers;

import org.example.services.posts.Post;
import org.example.services.posts.impl.SavePostAction;
import org.example.services.posts.reponse.SavePostsResponse;
import org.example.services.user.User;
import org.example.services.user.UserService;
import org.example.services.user.impl.SaveUserAction;
import org.example.services.user.response.SaveUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>>  getPostDetailByUserName(@PathVariable String username){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getUserDetail(@PathVariable String id){

        Optional<User> user = userService.getUserDetail(Long.valueOf(id));

        if(user.isPresent()){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }


    }
    @PostMapping
    public ResponseEntity<SaveUserResponse> saveUser(@RequestBody User user) throws URISyntaxException {

        SaveUserAction userSavedAction = userService.saveUser(user);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                .buildAndExpand(userSavedAction.getUserId()).toUri())
                .body(SaveUserResponse.response(String.valueOf(userSavedAction.getUserId()),"User saved"));
    }
}
