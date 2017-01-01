package com.example.woowahan.retrofitsample.presenter;


import com.example.woowahan.retrofitsample.network.model.Blog;

import java.util.List;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public interface MainPresenter {


    void loadBlogs();


    interface View {

        void bindData(List<Blog> blogs);
        void showErrorView();
    }
}
