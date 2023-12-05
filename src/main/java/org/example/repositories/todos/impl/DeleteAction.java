package org.example.repositories.todos.impl;

public class DeleteAction {

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public String getMessage() {
        return message;
    }

    private Boolean deleteStatus;

    private String message;

    public DeleteAction(Boolean deleteStatus, String message){
        this.deleteStatus = deleteStatus;
        this.message = message;
    }
}
