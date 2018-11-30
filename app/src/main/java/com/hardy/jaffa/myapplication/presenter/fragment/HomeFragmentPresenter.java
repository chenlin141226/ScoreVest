package com.hardy.jaffa.myapplication.presenter.fragment;

import com.hardy.jaffa.myapplication.model.ZixunInfo;
import com.hardy.jaffa.myapplication.presenter.BasePresenter;
import com.hardy.jaffa.myapplication.ui.fragment.HomeFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 首页的业务处理
 */

public class HomeFragmentPresenter extends BasePresenter {

    private HomeFragment fragment;

    public HomeFragmentPresenter(HomeFragment fragment) {
        this.fragment = fragment;
    }
    /**
     * 获取首页数据的步骤：
     * 1.需要在联网的API接口中增加一个获取首页数据的方法（访问方式和请求参数配置）
     * 2.异步获取首页数据
     * 3.数据处理
     * 4.展示数据到界面
     */


    /**
     * 获取服务器端首页数据
     */
    public void getData() {
        //Call<ZixunInfo> call = responseInfoAPI.home();
//        call.enqueue(new Callback<ZixunInfo>(){
//
//            @Override
//            public void onResponse(Call<ZixunInfo> call, Response<ZixunInfo> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ZixunInfo> call, Throwable t) {
//
//            }
//        });
    }

}
