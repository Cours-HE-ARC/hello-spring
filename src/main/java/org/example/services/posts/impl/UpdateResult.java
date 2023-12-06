package org.example.services.posts.impl;

public class UpdateResult {

    private String message;
    public UpdateResult(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
