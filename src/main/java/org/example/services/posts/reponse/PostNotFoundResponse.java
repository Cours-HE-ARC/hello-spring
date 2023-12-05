package org.example.services.posts.reponse;

public class PostNotFoundResponse {

    private String id;

    private String message;

    public PostNotFoundResponse(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
