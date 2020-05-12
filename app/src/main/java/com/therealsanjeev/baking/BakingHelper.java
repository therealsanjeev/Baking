package com.therealsanjeev.baking;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BakingHelper {

    private static BakingAPI bakingApiService;

    public static synchronized BakingAPI getInstance(Context context) {
        if(bakingApiService== null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl("https://d17h27t6h515a5.cloudfront.net")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            bakingApiService = retrofit.create(BakingAPI.class);
        }

        return bakingApiService;
    }
}

