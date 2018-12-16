package update.platform.sports.com.updata;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StartUpdata  {
    public static  void start(final Context context){
        AppUtils.init(context);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetRequestInterface requestInterface=retrofit.create(GetRequestInterface.class);
        Call<StarEnity> call=requestInterface.getCall(Constants.PLATFORM, Constants.APPSTORE,Constants.VERSIONCODE, Constants.UID);
        call.enqueue(new Callback<StarEnity>() {
            @Override
            public void onResponse(Call<StarEnity> call, Response<StarEnity> response) {
                StarEnity  starEnity=response.body();
                if(starEnity.data!=null && starEnity.data.version_info !=null && starEnity.data.version_info.size()>0){
                    if("1".equals(starEnity.data.version_info.get(0).ios_status)){//0开，1关(马甲包是否关闭)
                        //  WebUtils.openExternal(MainActivity.this, starEnityBaseBusResponse.data.version_info.get(0).url);
                        String url= starEnity.data.version_info.get(0).url;
                        UpdateManager.getInstance().startDownloads(context, url, StrUtils.getFileName(url),2);
                        return;
                    }

                   // UpdateManager.getInstance().startDownloads(context, url, StrUtils.getFileName(url),2);
                }

            }

            @Override
            public void onFailure(Call<StarEnity> call, Throwable t) {

            }
        });
    }
}
