package com.example.woowahan.retrofitsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.woowahan.retrofitsample.network.GitHubService;
import com.example.woowahan.retrofitsample.presenter.MainPresenter;
import com.example.woowahan.retrofitsample.presenter.MainPresenterImpl;
import com.example.woowahan.retrofitsample.R;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;
import com.example.woowahan.retrofitsample.domain.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {


    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userinfo)
    TextView userinfo;


    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this, new GitHubService(RetrofitCreator.create()));


    }


    @OnClick(R.id.send)
    void onSendClick(Button button) {
        mainPresenter.gethUser(username.getText().toString());
    }

    @OnClick(R.id.next)
    void onNextClick(Button button) {
        if (user == null) return;
        moveToNext();
    }


    User user;

    @Override
    public void bindUserData(User user) {
        this.user = user;
        userinfo.setText(user.toString());
    }

    @Override
    public void moveToNext() {
        startActivity(LoginActivity.getIntent(this, user.getToken()));
    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
