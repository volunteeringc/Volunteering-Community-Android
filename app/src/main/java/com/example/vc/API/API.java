package com.example.vc.API;

import com.example.vc.models.DefaultResponse;
import com.example.vc.models.FollowersResponse;
import com.example.vc.models.FollowingResponse;
import com.example.vc.models.HomeResponse;
import com.example.vc.models.LoginResponse;
import com.example.vc.models.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface API {
    //User Routes


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

    @DELETE("setting/delete")
    Call<DefaultResponse> delete(@Query("id") String id, @Header("Authorization") String header);

    @FormUrlEncoded
    @PUT("setting/changename")
    Call<ProfileResponse> changename(
            @Field("id") String id, @Field("name") String name, @Header("Authorization") String header);

    @FormUrlEncoded
    @PUT("setting/changepassword")
    Call<ProfileResponse>
    ChangePassword(@Field("id") String id, @Field("password") String password, @Header("Authorization") String header);


    @GET("profile")
    Call<ProfileResponse>
    profile(@Query("id") String id, @Header("Authorization") String header);


    @GET("followers")
    Call<FollowersResponse>
    followers(@Query("id") String id, @Header("Authorization") String header);


    @GET("following")
    Call<FollowingResponse>
    following(@Query("id") String id, @Header("Authorization") String header);

    //Home Routes

    @GET("home")
    Call<HomeResponse>
    home(@Query("id") String id, @Header("Authorization") String header);


}

