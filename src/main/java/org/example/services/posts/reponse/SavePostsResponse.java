package org.example.services.posts.reponse;

public class SavePostsResponse {

    private String message;

    private String id;

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    private SavePostsResponse(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public static SavePostsResponse response(String id, String message){
        return new SavePostsResponse(id, message);
    }

}
