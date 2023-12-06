package org.example.controllers;


import org.example.services.todos.PostsService;
import org.example.services.posts.Post;
import org.example.services.posts.reponse.DeletePostsResponse;
import org.example.services.posts.reponse.SavePostsResponse;
import org.example.services.posts.reponse.UpdatePostsResponse;
import org.example.services.todos.impl.DeleteAction;
import org.example.services.todos.impl.SaveAction;
import org.example.services.todos.impl.UpdateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("posts")
public class PostControllerWithHashMap {

    @Autowired
    PostsService postsService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){

        return ResponseEntity.ok(postsService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getPostDetail(@PathVariable String id){

        Optional<Post> post = postsService.getPostDetail(Long.valueOf(id));

        if(post.isPresent()){
            return ResponseEntity.ok(post.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?>  getPostDetailByUserName(@PathVariable String username){

        Optional<Post> post = postsService.getPostDetailByUsername(username);

        if(post.isPresent()){
            return ResponseEntity.ok(post.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePostsResponse> deletePost(@PathVariable String id){

        System.out.println("put/id" + id);

        DeletePostsResponse response;

        Post toDelete = postsService.getPostDetail(Long.valueOf(id)).get();

        DeleteAction deleteAction = postsService.deletePost(toDelete);
        response = DeletePostsResponse.response(deleteAction.getMessage(), id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePostsResponse> updatePost(@PathVariable String id,@RequestBody Post post){

        System.out.println("put/id" + id);

        UpdatePostsResponse response;

        UpdateAction updateAction = postsService.updatePost(post);

        response = UpdatePostsResponse.response(id, updateAction.getMessage());

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<SavePostsResponse> savePost(@RequestBody Post post) throws URISyntaxException {

       SaveAction postSavedAction = postsService.savePost(post);

       return ResponseEntity.created(
               ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postSavedAction.getPostId()).toUri())
           .body(SavePostsResponse.response(postSavedAction.getPostId(),"Post saved"));
    }



}
