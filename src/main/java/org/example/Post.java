package org.example;

import java.util.Date;

public class Post {

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getUser() {
        return user;
    }

    private String content;

    private String user;

    public Post(String content, String user) {
        this.content = content;
        this.user = user;
    }

    public static Post create(String user, String content){
        return new Post(content,user);
    }

}
