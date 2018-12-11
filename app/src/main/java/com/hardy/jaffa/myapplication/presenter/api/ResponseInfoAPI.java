package com.hardy.jaffa.myapplication.presenter.api;

import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.model.RaceScoreState;
import com.hardy.jaffa.myapplication.model.Token;
import com.hardy.jaffa.myapplication.model.UserLoginState;
import com.hardy.jaffa.myapplication.model.UserState;
import com.hardy.jaffa.myapplication.model.ZixunInfo;
import com.hardy.jaffa.myapplication.model.ZixunInfoDetails;
import com.hardy.jaffa.myapplication.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 对请求方式和请求参数的封装
 */
public interface ResponseInfoAPI {


//    /**
//     * 传统方式登录
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
            @Query(value = "playerIdByTeamId", encoded = true)
                    String id
    );

    @GET(Constant.TOKEN)
    Call<Token> getAccessToken(
            @Query("app_id")
                    String app_id,
            @Query("app_secret")
                    String app_secret,
            @Query("signature")
                    String signature,
            @Query("device_id")
                    String device_id,
            @Query("rand_str")
                    String rand_str,
            @Query("timestamp")
                    long timestamp
    );

    @FormUrlEncoded
    @POST(Constant.LoginUrl)
    @Headers("version:v3.0")
    Call<UserLoginState> Login(@Field("username") String username, @Field("password") String password);

    @GET(Constant.LogoutUrl)
    @Headers("version:v3.0")
    Call<UserState> Logout();

    @FormUrlEncoded
    @POST(Constant.RegisterUrl)
    @Headers("version:v3.0")
    Call<UserState> Register(@Field("username") String username,
                             @Field("nickname") String nickname,
                             @Field("phone") String phone,
                             @Field("password") String password);

    @GET(Constant.RaceDataUrl)
    @Headers("version:v3.0")
    Call<RaceScoreState> getRaceData();
}
