package com.example.bnn_news.BLL;

import com.example.bnn_news.APIs.UserApi;
import com.example.bnn_news.Models.UserModel;
import com.example.bnn_news.Responses.UserResponse;
import com.example.bnn_news.Utlis.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserBLL {
    private UserApi userApi;

    public UserBLL() {
        userApi = RetrofitClient.getInstance().create(UserApi.class);
    }

    public UserModel loginUser(String email, String password) {
        UserModel user = null;
        Call<UserResponse> loginCall = userApi.loginUser(email, password);

        try {
            Response<UserResponse> loginResponse = loginCall.execute();
            if (!loginResponse.isSuccessful()) {
                return user;
            } else if (loginResponse.body().getSuccess() == "true") {
                user = loginResponse.body().getUser();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    public UserModel registerUser(String email, String password, String first, String last, String phone) {
        UserModel userreg = null;
        Call<UserResponse> registerCall = userApi.registerUser(email, password, first, last, phone);

        try {
            Response<UserResponse> registerResponse = registerCall.execute();
            if (!registerResponse.isSuccessful()) {
                return userreg;
            } else if (registerResponse.body().getSuccess() == "true") {
                userreg = registerResponse.body().getUser();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userreg;
    }
}

