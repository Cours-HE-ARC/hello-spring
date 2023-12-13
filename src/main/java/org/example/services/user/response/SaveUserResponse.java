package org.example.services.user.response;

import org.example.services.posts.reponse.SavePostsResponse;

public class SaveUserResponse {

    private String message;

    private String id;

    public SaveUserResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public static SaveUserResponse response(String id, String message){
        return new SaveUserResponse(message,id);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
