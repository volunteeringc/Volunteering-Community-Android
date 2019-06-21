package com.example.vc.API;

import com.example.vc.models.DefaultResponse;
import com.example.vc.models.LoginResponse;
import com.example.vc.models.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
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

 //   @Headers("Content-Type: application/json")
    @GET("profile")
    Call<LoginResponse>
    profile(@Path("id")String id,@Header("Authorization") String header);
}
