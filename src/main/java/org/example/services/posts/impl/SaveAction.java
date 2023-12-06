package org.example.services.posts.impl;

public class SaveAction {

    private String message;
    private Long postId;
    public SaveAction(String message, Long postId){
        this.postId = postId;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public String getPostId(){
        return String.valueOf(this.postId);
    }
}
