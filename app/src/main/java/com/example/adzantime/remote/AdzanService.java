package com.example.adzantime.remote;

import com.example.adzantime.model.APIEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdzanService {

    public static String BASE_URL = "http://api.aladhan.com/v1/";

    public static APIEndpoint getAPI() {
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit.create(APIEndpoint.class);
    }
}
