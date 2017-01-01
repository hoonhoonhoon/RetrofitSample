package com.example.woowahan.retrofitsample.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class RetrofitCreator {


    static String BASE_URL = "https://openapi.naver.com/v1/search/";


    static String CLIENT_ID = "NqxOrPe5UMX1y1oMrY0S";
    static String CLIENT_SECRET = "NulbmDG4Ur";

    public static Retrofit create() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Accept", "Application/JSON")
                                .addHeader("X-Naver-Client-Id", CLIENT_ID)
                                .addHeader("X-Naver-Client-Secret", CLIENT_SECRET)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(interceptor).build();


//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Blog.class, new CustomDeserializer())
//                .create();


        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(new NullOnEmptyConverterFactory())
//                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
