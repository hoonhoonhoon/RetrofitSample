package com.example.woowahan.retrofitsample.presenter;


/**
 * Created by woowahan on 2016. 12. 23..
 */

public interface MainPresenter {


    void loadBlogs();


    interface View {

        void showErrorView();
    }
}
