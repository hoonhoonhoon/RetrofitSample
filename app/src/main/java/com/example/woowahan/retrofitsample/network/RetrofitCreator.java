package com.example.woowahan.retrofitsample.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class RetrofitCreator {


    static String BASE_URL = "https://api.github.com";

    public static Retrofit create() {

        OkHttpClient okHttpClient = new OkHttpClient();


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
