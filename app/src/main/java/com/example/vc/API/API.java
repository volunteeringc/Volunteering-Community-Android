package com.example.vc.API;

import com.example.vc.models.DefaultResponse;
import com.example.vc.models.LoginResponse;
import com.example.vc.models.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

    @FormUrlEncoded
    @POST("signup")
    Call<DefaultResponse>
    signup(@Field("email") String email,
           @Field("password") String password,
           @Field("name") String name);

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse>
    login(@Field("email") String email,
          @Field("password") String password);

    @GET("profile")
    Call<ProfileResponse>
    profile(@Path("id")String id);
}
