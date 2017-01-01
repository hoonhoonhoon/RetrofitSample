package com.example.woowahan.retrofitsample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.woowahan.retrofitsample.R;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;
import com.example.woowahan.retrofitsample.network.StoreService;
import com.example.woowahan.retrofitsample.network.model.Blog;
import com.example.woowahan.retrofitsample.presenter.MainPresenter;
import com.example.woowahan.retrofitsample.presenter.MainPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private MainPresenter mainPresenter;
    private AppListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new AppListAdapter();

        mainPresenter = new MainPresenterImpl(this, new StoreService(RetrofitCreator.create()), adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mainPresenter.loadBlogs();

    }

    @Override
    public void bindData(List<Blog> blogs) {
        adapter.set(blogs);
    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
