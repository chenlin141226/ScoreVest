package com.hardy.jaffa.myapplication.presenter.fragment;

import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.model.VodBean;
import com.hardy.jaffa.myapplication.model.ZixunInfo;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.fragment.ForwardFragment;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForwardFragmentPresenter {

    private ForwardFragment fragment;
    private ResponseInfoAPI responseInfoAPI;

    public ForwardFragmentPresenter(ForwardFragment fragment) {
        this.fragment = fragment;
        // 第一次初始化完成后，所有子类都可以使用
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.PLAYER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    /**
     * 获取资讯数据
     */
    public void getData() {
        Call<List<PlayerInfo>> call = responseInfoAPI.getPlayerInfo(Constant.player1);
        call.enqueue(new Callback<List<PlayerInfo>>() {

            @Override
            public void onResponse(Call<List<PlayerInfo>> call, Response<List<PlayerInfo>> response) {

                if (response != null && response.isSuccessful()) {
                    List<PlayerInfo> info = response.body();
                    parseData(info);
                } else {
                    //联网过程中异常
                }
            }

            @Override
            public void onFailure(Call<List<PlayerInfo>> call, Throwable t) {
                ToastUtil.ShowToast(fragment.getActivity(),"数据加载失败！请检查网络后重试！");
            }
        });
    }


    private void parseData(List<PlayerInfo> info) {
        fragment.setData(info);
    }


}
