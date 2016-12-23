package com.example.woowahan.retrofitsample.presenter;

import com.example.woowahan.retrofitsample.network.GitHubService;
import com.example.woowahan.retrofitsample.util.LogUtils;
import com.example.woowahan.retrofitsample.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class LoginPresenterImpl implements LoginPresenter {

    private static final String TAG = LoginPresenterImpl.class.getSimpleName();

    View view;
    GitHubService gitHubService;
    String token;

    public LoginPresenterImpl(View view, GitHubService gitHubService, String token) {
        this.view = view;
        this.gitHubService = gitHubService;
        this.token = token;
    }

    @Override
    public void login(String username, String password) {
        Call<User> call = gitHubService.login(username, password, token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                LogUtils.debug(TAG, "login response : " + response.message());
                view.showResponseView(response.message());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.showErrorView();
                LogUtils.error(TAG, "login response : " + t.getMessage());
            }
        });
    }
}
