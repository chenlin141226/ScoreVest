package com.hardy.jaffa.myapplication.presenter.activity;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.hardy.jaffa.myapplication.model.UserState;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.RegexUtil;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistActivityPresenter {
    private RegistActivity activity;
    private ResponseInfoAPI responseInfoAPI;

    public RegistActivityPresenter(RegistActivity activity) {
        this.activity = activity;
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.TOKEN_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    public void Register(String username, String nickname, String phone, String password) {
        if (TextUtils.isEmpty(username)) {
            ToastUtil.ShowToast(activity, "用户名不能为空！");
            return;
        }
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            ToastUtil.ShowToast(activity, "账号和密码不能为空！");
            return;
        }
        if (!RegexUtil.isMobileExact(phone)) {
            ToastUtil.ShowToast(activity, "手机号不正确！");
            return;
        }
        Call<UserState> call = responseInfoAPI.Register(username, nickname, phone, password);
        call.enqueue(new Callback<UserState>() {
            @Override
            public void onResponse(@NonNull Call<UserState> call, @NonNull Response<UserState> response) {
                ToastUtil.ShowToast(activity, "注册成功！");
                activity.finish();
            }

            @Override
            public void onFailure(@NonNull Call<UserState> call, @NonNull Throwable t) {
                ToastUtil.ShowToast(activity, "注册失败！");
            }
        });
    }
}
