package org.example.repositories.todos.impl;

public class UpdateAction {

    public Boolean getUpdateStatus() {
        return updateStatus;
    }

    public String getMessage() {
        return message;
    }

    private Boolean updateStatus;

    private String message;

    public UpdateAction(Boolean updateStatus, String message){
        this.updateStatus = updateStatus;
        this.message = message;
    }
}
