package com.example.woowahan.retrofitsample.network;

import com.example.woowahan.retrofitsample.network.model.ApiModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by woowahan on 2016. 12. 23..
 */

public class StoreService {

    Retrofit retrofit;
    Api api;


    public StoreService(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.api = getApiservice();
    }

    private Api getApiservice() {
        if (api == null)
            return retrofit.create(Api.class);
        else
            return api;
    }



    public Call<ApiModel> getBlogs(String query) {
        return getApiservice().getBlogs(query);
    }

    interface Api {


        @GET("blog")
        Call<ApiModel> getBlogs(@Query("query") String query);

    }
}
