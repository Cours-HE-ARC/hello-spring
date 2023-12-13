package org.example.controllers;


import org.example.repositories.users.UserEntity;
import org.example.services.posts.PostsService;
import org.example.services.posts.Post;
import org.example.services.posts.reponse.DeletePostsResponse;
import org.example.services.posts.reponse.SavePostsResponse;
import org.example.services.posts.reponse.UpdatePostsResponse;
import org.example.services.posts.impl.DeleteResult;
import org.example.services.posts.impl.SavePostAction;
import org.example.services.posts.impl.UpdateResult;
import org.example.services.user.User;
import org.example.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostsService postsService;
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){

        return ResponseEntity.ok(postsService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getPostDetail(@PathVariable String id){

        Optional<Post> post = postsService.getPostDetail(Long.valueOf(id));

        if(post.isPresent()){
            return ResponseEntity.ok(post);
        }else{
            return ResponseEntity.notFound().build();
        }


    }



    @DeleteMapping("/{id}")
    public ResponseEntity<DeletePostsResponse> deletePost(@PathVariable String id){

        System.out.println("delete/id" + id);

        DeletePostsResponse response;
        DeleteResult deleteResult = postsService.deletePost(id);
        response = DeletePostsResponse.response(deleteResult.getMessage(), id);
        //TODO 404 is post doesn't exist ?
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePostsResponse> updatePost(@PathVariable String id,@RequestBody Post post){

        System.out.println("put/id" + id);

        UpdatePostsResponse response;

        UpdateResult updateResult = postsService.updatePost(Long.valueOf(id),post);

        response = UpdatePostsResponse.response(updateResult.getMessage(),id);

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<SavePostsResponse> savePost(@RequestBody SavePostRequestBody postBody) throws URISyntaxException {


        Post post = new Post(postBody.getContent(), null,postBody.getDate());

        SavePostAction postSavedAction = postsService.savePost(post,postBody.getUserId());

       return ResponseEntity.created(
               ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                       .buildAndExpand(postSavedAction.getPostId()).toUri())
               .body(SavePostsResponse.response(String.valueOf(postSavedAction.getPostId()),"Post saved"));
    }



}
