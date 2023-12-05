package org.example.services.posts.reponse;

public class DeletePostsResponse {

    private String message;

    private String id;

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    private DeletePostsResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }
    public static DeletePostsResponse response(String message, String id) {
        return new DeletePostsResponse(message,id);
    }
}
