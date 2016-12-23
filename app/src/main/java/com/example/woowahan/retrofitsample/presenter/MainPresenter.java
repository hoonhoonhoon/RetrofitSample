package com.example.woowahan.retrofitsample.presenter;

import com.example.woowahan.retrofitsample.domain.User;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public interface MainPresenter {


    void gethUser(String username);



    interface View {

        void bindUserData(User user);

        void moveToNext();

        void showErrorView();
    }
}
