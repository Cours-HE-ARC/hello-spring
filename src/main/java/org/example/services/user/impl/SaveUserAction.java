package org.example.services.user.impl;

import org.example.services.user.User;

public class SaveUserAction {

    private String message;
    private User user;

    private Long userId;

    public String getMessage() {
        return message;
    }

    public SaveUserAction(String message, User user, Long userId) {
        this.message = message;
        this.user = user;
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
