package org.example.services.posts.impl;

public class DeleteResult {

    private String message;
    public DeleteResult(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
