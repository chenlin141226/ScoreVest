package com.hardy.jaffa.myapplication.presenter.api;

import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.model.ZixunInfo;
import com.hardy.jaffa.myapplication.model.ZixunInfoDetails;
import com.hardy.jaffa.myapplication.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 对请求方式和请求参数的封装
 */
public interface ResponseInfoAPI {


//    /**
//     * 传统方式登陆
//     * @param username
//     * @param password
//     * @return
//     */
//    @GET(Constant.LOGIN)
//    Call<ZixunInfo> login(
//            @Query("username")// 参数的名字
//                    String username, // 该参数的值
//            @Query("password")
//                    String password);

    /**
     * 获取首页数据
     *
     * @return
     */
    @GET(Constant.INFO)
    Call<ZixunInfo> getInfoData();

    @GET(Constant.DETAILS)
    Call<List<ZixunInfoDetails>> getInfoDetailsData(
            @Query("searchTagsKey")
                    String keywords,
            @Query("pageNo")
                    int startPage,
            @Query("pageSize")
                    int endPage
    );

    @GET(Constant.PLAYER_INFO)
    Call<List<PlayerInfo>> getPlayerInfo(
            @Query("playerIdByTeamId")
                    String id
    );

//    @FormUrlEncoded
//    @POST(Constant.ORDER)
//    Call<ZixunInfo> creatOrder(@Field("orderOverview") String json);

}
