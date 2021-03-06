package com.hardy.jaffa.myapplication.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerRegistActivityConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.RegistActivityConponent;
import com.hardy.jaffa.myapplication.dagger.module.RegistActivityModule;
import com.hardy.jaffa.myapplication.presenter.activity.RegistActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_username)
    EditText etUsername;
    @Inject
    RegistActivityPresenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initInjector() {
        super.initInjector();
        DaggerRegistActivityConponent.Builder builder = DaggerRegistActivityConponent.builder();
        builder.registActivityModule(new RegistActivityModule(this));
        RegistActivityConponent conponent = builder.build();
        conponent.in(this);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(toolbar, true, "");
        tvTitle.setText("账号注册");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        presenter.Register(etUsername.getText().toString(), etUsername.getText().toString(),
                etAccount.getText().toString(), etPassword.getText().toString());
    }
}
