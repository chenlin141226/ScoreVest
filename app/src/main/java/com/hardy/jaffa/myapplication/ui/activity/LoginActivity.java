package com.hardy.jaffa.myapplication.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerLoginActivityConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.LoginActivityConponent;
import com.hardy.jaffa.myapplication.dagger.module.LoginActivityModule;
import com.hardy.jaffa.myapplication.presenter.activity.LoginActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_regist)
    TextView tvRegist;

    @Inject
    LoginActivityPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        DaggerLoginActivityConponent.Builder builder = DaggerLoginActivityConponent.builder();
        builder.loginActivityModule(new LoginActivityModule(this));
        LoginActivityConponent conponent = builder.build();
        conponent.in(this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("账号登录");
    }

    @Override
    protected void setListener() {
        super.setListener();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.tv_regist})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                presenter.Login(etAccount.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tv_regist:
                presenter.ToggleActivity(RegistActivity.class);
                break;
        }
    }
}
