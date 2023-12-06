package org.example.services.posts.impl;

import org.example.services.posts.Post;

public class SaveAction {

    private String message;
    private Post post;

    private Long postId;

    public Long getPostId() {
        return postId;
    }

    public SaveAction(String message, Post post, Long postId){
        this.post = post;
        this.message = message;
        this.postId = postId;
    }

    public String getMessage(){
        return this.message;
    }

    public Post getPost(){
        return post;
    }
}
