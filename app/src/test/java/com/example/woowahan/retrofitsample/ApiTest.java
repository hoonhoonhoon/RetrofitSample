package com.example.woowahan.retrofitsample;

import com.example.woowahan.retrofitsample.model.DataModel;
import com.example.woowahan.retrofitsample.network.BlogService;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;
import com.example.woowahan.retrofitsample.network.model.ApiModel;
import com.example.woowahan.retrofitsample.network.model.Blog;
import com.example.woowahan.retrofitsample.presenter.MainPresenter;
import com.example.woowahan.retrofitsample.presenter.MainPresenterImpl;
import com.example.woowahan.retrofitsample.view.BlogListAdapter;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jihoon on 2017. 1. 1..
 */

public class ApiTest {

    private BlogService blogService;

    private final CountDownLatch latch = new CountDownLatch(1);

    private Response<ApiModel> apiResponse;

    private MainPresenterImpl mainPresenter;

    @Mock
    private MainPresenter.View view;

    private DataModel<Blog> dataModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        blogService = new BlogService(RetrofitCreator.create());
        dataModel = new BlogListAdapter();
        mainPresenter = new MainPresenterImpl(view, blogService, dataModel);
        apiResponse = null;

    }

    @Test
    public void blog검색_api_호출테스트() throws Exception {


        String text = "게임보이";

        blogService.getBlogs(text).enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                apiResponse = response;
                latch.countDown();
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                latch.countDown();
            }
        });

        latch.await();
        Assert.assertNotNull(apiResponse);
        Assert.assertTrue(apiResponse.body().getItems().size() > 10);

    }

    @Test
    public void presenter_와_dataModel_의_호출테스트() throws Exception {
        mainPresenter.loadBlogs();

        Thread.sleep(2000);

        Assert.assertNotNull(dataModel.getAll());
        Assert.assertTrue(dataModel.getAll().size() > 0);
    }
}