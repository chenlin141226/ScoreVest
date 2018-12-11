package com.hardy.jaffa.myapplication.presenter.fragment;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.hardy.jaffa.myapplication.model.VodBean;
import com.hardy.jaffa.myapplication.model.ZixunInfo;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.fragment.InfoFragment;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoFragmentPresenter {
    private InfoFragment fragment;
    private ResponseInfoAPI responseInfoAPI;

    public InfoFragmentPresenter(InfoFragment fragment) {
        this.fragment = fragment;
        // 第一次初始化完成后，所有子类都可以使用
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.ZIXUN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    /**
     * 获取资讯数据
     */
    public void getData() {
        Call<ZixunInfo> call = responseInfoAPI.getInfoData();
        call.enqueue(new Callback<ZixunInfo>() {

            @Override
            public void onResponse(Call<ZixunInfo> call, Response<ZixunInfo> response) {

                if (response != null && response.isSuccessful()) {
                    ZixunInfo info = response.body();
                    parseData(info.getVod());
                } else {
                    //联网过程中异常
                }
            }

            @Override
            public void onFailure(Call<ZixunInfo> call, Throwable t) {
                ToastUtil.ShowToast(fragment.getActivity(),"数据加载失败！请检查网络后重试！");
            }
        });
    }

    private void parseData(List<VodBean> data) {
        fragment.setData(data);
    }


}
