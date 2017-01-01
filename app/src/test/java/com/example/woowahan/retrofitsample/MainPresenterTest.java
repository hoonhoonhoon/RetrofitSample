package com.example.woowahan.retrofitsample;

import com.example.woowahan.retrofitsample.model.DataModel;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;
import com.example.woowahan.retrofitsample.network.StoreService;
import com.example.woowahan.retrofitsample.network.model.Blog;
import com.example.woowahan.retrofitsample.presenter.MainPresenter;
import com.example.woowahan.retrofitsample.presenter.MainPresenterImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Created by jihoon on 2017. 1. 1..
 */

public class MainPresenterTest {

    @Mock
    private MainPresenter.View view;

    @Mock
    private DataModel<Blog> dataModel;

    private MainPresenterImpl mainPresenter;


    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenterImpl(view, new StoreService(RetrofitCreator.create()), dataModel);
    }

    @Test
    public void 네이버블로그검색() throws Exception {
        mainPresenter.loadBlogs();

        Thread.sleep(200);

        // 검증 할 방법이 없넹..  DataModel을 추가해야 할 듯..

        Assert.assertTrue(dataModel.getAll().size() > 0);

    }
}
