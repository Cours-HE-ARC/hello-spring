package org.example.controllers;

import java.util.Date;

public class SavePostRequestBody {

    private String content;

    private Date date;

    private String userId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SavePostRequestBody(String content, Date date, String userId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
    }
}
