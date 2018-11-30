package com.hardy.jaffa.myapplication.presenter;

import com.hardy.jaffa.myapplication.presenter.api.ResponseInfoAPI;
import com.hardy.jaffa.myapplication.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 业务层公共部分代码封装
 */

public abstract class BasePresenter {
    protected static ResponseInfoAPI responseInfoAPI;
    // 数据库
    // 网络
    // protected DBHelper helper;


//    public BasePresenter() {

/*        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Constant.BASEURL);
        builder.addConverterFactory(GsonConverterFactory.create());// Gson解析

        Retrofit retrofit = builder.build();*/


        // 第一次初始化完成后，所有子类都可以使用
//        if (responseInfoAPI == null) {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(Constant.BASEURL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
//        }
//
//        // helper=DBHelper.getInstance();
//
//    }

//    public class CallbackAdapter implements Callback<ZixunInfo> {
//
//        @Override
//        public void onResponse(Call<ZixunInfo> call, Response<ZixunInfo> response) {
//            // 处理回复
//            if (response != null && response.isSuccessful()) {
//                ZixunInfo info = response.body();
//
//                if ("0".equals(info.code)) {
//                    // 服务器端处理成功，并返回目标数据
//                    parserData(info.data);
//                } else {
//                    // 服务器端处理成功，返回错误提示，该信息需要展示给用户
//                    // 依据code值获取到失败的数据
//                    String msg = ErrorInfo.INFO.get(info.code);
//                    failed(msg);
//                }
//
//            } else {
//                // 联网过程中的异常
//            }
//
//
//        }
//
//        @Override
//        public void onFailure(Call<ZixunInfo> call, Throwable t) {
//            // 联网过程中的异常
//        }
//    }

//    /**
//     * 错误处理
//     *
//     * @param msg
//     */
//    protected abstract void failed(String msg);
//
//    /**
//     * 解析服务器回复数据
//     *
//     * @param data
//     */
//    protected abstract void parserData(String data);
}
