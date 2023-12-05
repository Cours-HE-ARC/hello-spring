package org.example.services.posts.reponse;

public class UpdatePostsResponse {

    private String message;

    private String id;

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    private UpdatePostsResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public static UpdatePostsResponse response(String id, String message){
        return new UpdatePostsResponse(id, message);
    }

}
