package com.hardy.jaffa.myapplication.presenter.fragment;

import android.util.Log;

import com.google.gson.Gson;
import com.hardy.jaffa.myapplication.model.ZixunInfoDetails;
import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.ui.fragment.InfoDetailsFragment;
import com.hardy.jaffa.myapplication.utils.Constant;
import com.hardy.jaffa.myapplication.utils.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfoDetailsFragmentPresenter {
    private InfoDetailsFragment fragment;
    private ResponseInfoAPI responseInfoAPI;

    public InfoDetailsFragmentPresenter(InfoDetailsFragment fragment) {
        this.fragment = fragment;
        // 第一次初始化完成后，所有子类都可以使用
        if (responseInfoAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.INFOR_DETAILS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }

    /**
     * 获取资讯数据
     *
     * @param keyword
     */
    public void getData(String keyword) {
        Call<List<ZixunInfoDetails>> call = responseInfoAPI.getInfoDetailsData(keyword, 1, 20);
        call.enqueue(new Callback<List<ZixunInfoDetails>>() {
            @Override
            public void onResponse(Call<List<ZixunInfoDetails>> call, Response<List<ZixunInfoDetails>> response) {

                if (response != null && response.isSuccessful()) {
                    List<ZixunInfoDetails> info = response.body();
                  parseData(info);
                } else {
                    //联网过程中异常
                }
            }

            @Override
            public void onFailure(Call<List<ZixunInfoDetails>> call, Throwable t) {
                ToastUtil.ShowToast(fragment.getActivity(),"数据加载失败！请检查网络后重试！");
            }
        });
    }

    private void parseData(List<ZixunInfoDetails> data) {
        if(data!=null){
            fragment.setData(data);
        }
    }


}
