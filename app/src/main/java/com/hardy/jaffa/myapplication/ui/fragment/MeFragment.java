package com.hardy.jaffa.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.MyApplication;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.ui.activity.AboutActivity;
import com.hardy.jaffa.myapplication.ui.activity.LoginActivity;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;
import com.hardy.jaffa.myapplication.ui.dialogs.CheckUpdataDialog;
import com.hardy.jaffa.myapplication.ui.dialogs.ClearCacheDialog;
import com.hardy.jaffa.myapplication.utils.ImageLoaderUtils;
import com.hardy.jaffa.myapplication.view.WaveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MeFragment extends Fragment implements View.OnClickListener {

    Unbinder unbinder;
    @BindView(R.id.wave_view)
    WaveView waveView;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.login) //登录
            TextView login;
    @BindView(R.id.regist)  //注册
            TextView regist;
    @BindView(R.id.rl_check) //检查更新
            RelativeLayout rlCheck;
    @BindView(R.id.rl_about)//关于我们
            RelativeLayout rlAbout;
    @BindView(R.id.rl_clear)//清除缓存
            RelativeLayout rlClear;
    @BindView(R.id.username)
    TextView username;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setListener();
    }

    private void setListener() {
        login.setOnClickListener(this);
        regist.setOnClickListener(this);
        rlCheck.setOnClickListener(this);
        rlAbout.setOnClickListener(this);
        rlClear.setOnClickListener(this);
    }

    private void initView() {
        //设置头像跟着波浪背景浮动
        ImageLoaderUtils.displayRound(getContext(), imgLogo, R.drawable.head);
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        lp.gravity = Gravity.CENTER;
        WaveView.setRangeY(20);
        waveView.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0, 0, 0, (int) y + 2);
                imgLogo.setLayoutParams(lp);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApplication.userLoginState==null||MyApplication.userLoginState.getData()==null
                ||MyApplication.userLoginState.getData().getUsername()==null){
            username.setVisibility(View.GONE);
            login.setVisibility(View.VISIBLE);
            regist.setVisibility(View.VISIBLE);
            return;
        }
        username.setText(MyApplication.userLoginState.getData().getUsername());
        username.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);
        regist.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.login://登录界面
                intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.regist://注册界面
                intent = new Intent(getContext(), RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_check://检查更新
                CheckUpdataDialog fragment = new CheckUpdataDialog();
                //fragment.setTargetFragment(this, REQUEST_CODE);
                fragment.show(getChildFragmentManager(), "update");
                break;
            case R.id.rl_about://关于我们
                intent = new Intent(getContext(), AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_clear://清除缓存
                ClearCacheDialog clearCacheDialog = new ClearCacheDialog();
                //fragment.setTargetFragment(this, REQUEST_CODE);
                clearCacheDialog.show(getChildFragmentManager(), "login");
                break;
        }


    }
}
