package com.example.southside.models.forms;

import com.example.southside.models.User;

import javax.validation.constraints.NotNull;

public class LoginForm {

    private User user;

    private String language;

    @NotNull
    private int userId;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LoginForm(User user, String language) {
        this.user = user;
        this.language = language;
    }

    public LoginForm() {}
}
