package com.example.woowahan.retrofitsample.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.woowahan.retrofitsample.network.GitHubService;
import com.example.woowahan.retrofitsample.presenter.LoginPresenter;
import com.example.woowahan.retrofitsample.presenter.LoginPresenterImpl;
import com.example.woowahan.retrofitsample.R;
import com.example.woowahan.retrofitsample.network.RetrofitCreator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class LoginActivity extends AppCompatActivity implements LoginPresenter.View {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.result)
    TextView result;
    private LoginPresenter loginPresenter;


    static String KEY = "token";

    public static Intent getIntent(Context context, String token) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(KEY, token);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        String hashedToken = getIntent().getStringExtra(KEY);
        loginPresenter = new LoginPresenterImpl(this, new GitHubService(RetrofitCreator.create()), hashedToken);

    }

    @OnClick(R.id.login)
    void onLoginClick(Button button) {
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        if (TextUtils.isEmpty(username + password)) {
            return;
        }
        loginPresenter.login(username, password);
    }

    @Override
    public void showResponseView(String response) {
        result.setText(response);
    }

    @Override
    public void showErrorView() {
        Toast.makeText(this, "login error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToNext() {

    }
}
