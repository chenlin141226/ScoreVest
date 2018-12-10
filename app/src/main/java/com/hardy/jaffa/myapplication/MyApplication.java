package com.hardy.jaffa.myapplication;

import android.app.Application;
import android.content.Context;

import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.model.Token;
import com.hardy.jaffa.myapplication.model.UserLoginState;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.TimeUtils;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by itheima.
 */

public class MyApplication extends Application {
    private static Context context;
    private ResponseInfoAPI responseInfoAPI;
    public static Context getContext() {
        return context;
    }

    private final String app_id = "48916295";
    private final String app_secret = "MVfGUSRvOkpYeIiNmiGfXMwBEaeElzNf";
    private  String signature;//签名
    private  String device_id ;//设备唯一ID
    private  String rand_str ;//随机字符串
    private  long timestamp;//当前系统时间戳
    public static UserLoginState userLoginState;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        signature = TimeUtils.getRandomString(20);
        device_id = TimeUtils.getRandomString(18);
        rand_str = TimeUtils.getRandomString(17);
        timestamp = System.currentTimeMillis();
        //获取AccessToken
        getAccessToken();
    }

    private void getAccessToken() {
        // 第一次初始化完成后，所有子类都可以使用
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.TOKEN_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }

        Call<Token> call = responseInfoAPI.getAccessToken(app_id,app_secret,signature,device_id,rand_str,timestamp);
        call.enqueue(new Callback<Token>() {

            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                if (response != null && response.isSuccessful()) {
                    Token body = response.body();

                } else {
                    //联网过程中异常
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                System.out.println("");
            }
        });
    }

}
