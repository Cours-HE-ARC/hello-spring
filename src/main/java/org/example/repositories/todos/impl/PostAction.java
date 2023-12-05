package org.example.repositories.todos.impl;

import org.example.services.posts.Post;

public class PostAction {

    private Post post;
    private String id;

    public Post getPost() {
        return post;
    }

    public String getId() {
        return id;
    }

    public PostAction(Post post, String id){
        this.post = post;
        this.id = id;
    }
}
