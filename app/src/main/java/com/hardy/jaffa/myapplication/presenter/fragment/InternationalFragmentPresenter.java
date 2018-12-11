package com.hardy.jaffa.myapplication.presenter.fragment;

import android.support.annotation.NonNull;

import com.hardy.jaffa.myapplication.model.RaceData;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.fragment.InternationalFragment;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternationalFragmentPresenter {
    private InternationalFragment fragment;
    private ResponseInfoAPI responseInfoAPI;
    public InternationalFragmentPresenter(InternationalFragment fragment) {
        this.fragment = fragment;
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.TOKEN_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    public void getRaceData(){
        Call<RaceData> call=responseInfoAPI.getFocusRaceData();
        call.enqueue(new Callback<RaceData>() {
            @Override
            public void onResponse(@NonNull Call<RaceData> call, @NonNull Response<RaceData> response) {
               updateView(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<RaceData> call, @NonNull Throwable t) {
                ToastUtil.ShowToast(fragment.getActivity(),"数据加载失败！请检查网络后重试！");
            }
        });
    }

    private void updateView(RaceData data){
        if (data==null){
            return;
        }
        List<RaceData.DataBean.RaceBean> beans=data.getData().getList();
        if (beans==null||beans.size()==0){
            return;
        }
        fragment.setData(beans);
    }
}
