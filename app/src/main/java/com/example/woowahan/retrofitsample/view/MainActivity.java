package com.example.woowahan.retrofitsample.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.woowahan.retrofitsample.R;
import com.example.woowahan.retrofitsample.network.BlogService;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;
import com.example.woowahan.retrofitsample.presenter.MainPresenter;
import com.example.woowahan.retrofitsample.presenter.MainPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    private MainPresenter mainPresenter;
    private BlogListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new BlogListAdapter();

        mainPresenter = new MainPresenterImpl(this, new BlogService(RetrofitCreator.create()), adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 10);
            }
        });

        mainPresenter.loadBlogs();

    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
