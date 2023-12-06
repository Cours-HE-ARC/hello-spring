package org.example.services.todos.impl;

public class UpdateAction {

    private String message;
    public UpdateAction(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
