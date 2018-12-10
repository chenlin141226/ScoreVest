package com.hardy.jaffa.myapplication.presenter.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.hardy.jaffa.myapplication.MyApplication;
import com.hardy.jaffa.myapplication.model.UserLoginState;
import com.hardy.jaffa.myapplication.model.UserState;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.activity.LoginActivity;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.RegexUtil;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivityPresenter {
    private LoginActivity activity;
    private ResponseInfoAPI responseInfoAPI;

    public LoginActivityPresenter(LoginActivity activity) {
        this.activity = activity;
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.TOKEN_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    public void Login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            ToastUtil.ShowToast(activity, "账号和密码不能为空！");
            return;
        }
        /*if (!RegexUtil.isMobileExact(username)){
            ToastUtil.ShowToast(activity,"手机号不正确！");
            return;
        }*/
        Call<UserLoginState> call = responseInfoAPI.Login(username, password);
        call.enqueue(new Callback<UserLoginState>() {
            @Override
            public void onResponse(@NonNull Call<UserLoginState> call, @NonNull Response<UserLoginState> response) {
                MyApplication.userLoginState = response.body();
                ToastUtil.ShowToast(activity, "登录成功！");
                activity.finish();
            }

            @Override
            public void onFailure(@NonNull Call<UserLoginState> call, @NonNull Throwable t) {
                ToastUtil.ShowToast(activity, "登录失败！");
            }
        });
    }

    public void ToggleActivity(Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
    }
}
