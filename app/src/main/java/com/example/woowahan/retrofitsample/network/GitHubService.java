package com.example.woowahan.retrofitsample.network;

import com.example.woowahan.retrofitsample.domain.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class GitHubService {

    Retrofit retrofit;
    Api api;


    public GitHubService(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.api = getApiservice();
    }

    private Api getApiservice() {
        if (api == null)
            return retrofit.create(Api.class);
        else
            return api;
    }


    public Call<User> getUser(String username) {
        return getApiservice().getUser(username);
    }

    // 깃허브 로그인하는 방법을 모르겠네요..
    public Call<User> login(String username, String password, String token) {
        token = "1536565b3f97b34819e71bbea926bb0c419f9fc6";
        return getApiservice().login("token " + token);
    }


    interface Api {

        @GET("/users/{username}")
        Call<User> getUser(@Path("username") String username);


        @GET("/")
        Call<User> login(@Header("Authorization") String authorization);

    }
}
