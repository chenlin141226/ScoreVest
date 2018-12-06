package com.hardy.jaffa.myapplication.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        super.initView();
        tvTitle.setText("关于我们");
    }

}
