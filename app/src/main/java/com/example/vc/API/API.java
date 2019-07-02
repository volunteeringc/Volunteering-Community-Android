package com.example.vc.API;

import com.example.vc.models.DefaultResponse;
import com.example.vc.models.LoginResponse;
import com.example.vc.models.ProfileResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

//       @Headers("Content-Type: application/json")
//    @HTTP(method = "GET", path = "profile", hasBody = true)
    @GET("profile")
    Call<ProfileResponse>
    profile(@Query("id") String id, @Header("Authorization") String header);
}
