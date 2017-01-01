package com.example.woowahan.retrofitsample.presenter;

import com.example.woowahan.retrofitsample.network.StoreService;
import com.example.woowahan.retrofitsample.network.model.ApiModel;
import com.example.woowahan.retrofitsample.util.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = MainPresenterImpl.class.getSimpleName();

    MainPresenter.View view;
    StoreService storeService;

    int page = 0;

    public MainPresenterImpl(View view, StoreService storeService) {
        this.view = view;
        this.storeService = storeService;
    }

    @Override
    public void loadRealTimeRank() {
        storeService.getBlogs("게임보이")
                .enqueue(new Callback<ApiModel>() {
                    @Override
                    public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                        if (response.isSuccessful()) {
                            page ++;
                            view.bindData(response.body().getItems());
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiModel> call, Throwable t) {
                        LogUtils.error(TAG, t.toString());
                        LogUtils.error(TAG, t.getMessage());
                    }
                });
    }


}
