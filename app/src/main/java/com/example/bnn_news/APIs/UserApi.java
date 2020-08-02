package com.example.bnn_news.APIs;

import com.example.bnn_news.Responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {

    @FormUrlEncoded
    @POST("sign-in")
    Call<UserResponse> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("sign-up")
    Call<UserResponse> registerUser(@Field("email") String email, @Field("password") String password, @Field("firstname") String first, @Field("lastname") String last, @Field("phonenumber") String phone);

}
