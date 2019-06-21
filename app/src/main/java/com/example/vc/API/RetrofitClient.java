package com.example.vc.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static final String BASE_URL = "https://desolate-anchorage-26344.herokuapp.com/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private OkHttpClient getInterceptor()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }


    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public API getApi() {
        return retrofit.create(API.class);
    }
}
