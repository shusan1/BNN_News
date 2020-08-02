package com.example.bnn_news.Responses;

import com.example.bnn_news.Models.UserModel;

public class UserResponse {
    private UserModel user;
    private String success;

    public UserModel getUser() {
        return user;
    }

    public String getSuccess() {
        return success;
    }
}
