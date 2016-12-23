package com.example.woowahan.retrofitsample.presenter;

import com.example.woowahan.retrofitsample.network.GitHubService;
import com.example.woowahan.retrofitsample.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class MainPresenterImpl implements MainPresenter {

    MainPresenter.View view;
    GitHubService gitHubService;

    public MainPresenterImpl(View view, GitHubService gitHubService) {
        this.view = view;
        this.gitHubService = gitHubService;
    }

    @Override
    public void gethUser(String username) {

        Call<User> call = gitHubService.getUser(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    view.bindUserData(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.showErrorView();
            }
        });

    }

}
