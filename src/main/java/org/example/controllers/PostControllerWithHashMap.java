package org.example.controllers;

import org.example.repositories.todos.impl.DeleteAction;
import org.example.repositories.todos.impl.PostAction;
import org.example.repositories.todos.impl.UpdateAction;
import org.example.services.todos.TodosService;
import org.example.services.posts.Post;
import org.example.services.posts.reponse.DeletePostsResponse;
import org.example.services.posts.reponse.SavePostsResponse;
import org.example.services.posts.reponse.UpdatePostsResponse;
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
    TodosService todosService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){

        return ResponseEntity.ok(todosService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getPostDetail(@PathVariable String id){

        Optional<Post> post = todosService.getPostDetail(id);

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

        DeleteAction deleteAction = todosService.deletePost(id);
        response = DeletePostsResponse.response(deleteAction.getMessage(), id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePostsResponse> updatePost(@PathVariable String id,@RequestBody Post post){

        System.out.println("put/id" + id);

        UpdatePostsResponse response;

        UpdateAction updateAction = todosService.updatePost(id,post);

        response = UpdatePostsResponse.response(id, updateAction.getMessage());

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<SavePostsResponse> savePost(@RequestBody Post post) throws URISyntaxException {

       PostAction postSavedAction = todosService.savePost(post);

       return ResponseEntity.created(
               ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postSavedAction.getId()).toUri())
           .body(SavePostsResponse.response(postSavedAction.getId(),"Post saved"));
    }



}
