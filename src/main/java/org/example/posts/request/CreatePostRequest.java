package org.example.posts.request;

public class CreatePostRequest {
    private String content;

    private String user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public CreatePostRequest(String content, String user) {
        this.content = content;
        this.user = user;
    }
}
