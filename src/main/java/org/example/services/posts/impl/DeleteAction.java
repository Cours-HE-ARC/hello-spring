package org.example.services.posts.impl;

public class DeleteAction {

    private String message;
    public DeleteAction(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}