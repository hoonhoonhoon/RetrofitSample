package com.example.woowahan.retrofitsample.presenter;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public interface LoginPresenter {

    void login(String email, String password);

    interface View {

        void showResponseView(String response);

        void showErrorView();

        void moveToNext();
    }
}
