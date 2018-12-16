package update.platform.sports.com.updata;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetRequestInterface {
    String API = "/api/index";

    @FormUrlEncoded
    @POST(API+"/ad")
    Call<StarEnity> getCall(@Field("p") String platfrom,@Field("appstore") String appstore,@Field("app_version") String app_version,@Field("uid") String udi);
}
