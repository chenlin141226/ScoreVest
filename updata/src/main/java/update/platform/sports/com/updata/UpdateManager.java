package update.platform.sports.com.updata;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 检查更新管理器
 *
 */
public class UpdateManager {

    private static UpdateManager updateManager;
    private ThreadPoolExecutor threadPoolExecutor;
    private UpdateDownloadRequest request;

    //private String localPath = App.getContext().getExternalCacheDir().getAbsolutePath() + "/sports/update/sports.apk";
    //private String downPath = App.getContext().getExternalCacheDir().getAbsolutePath() + "/sports/";
    private String localPath="";
    private String downPath ="";
   // private UpdateApi updateApi;

    private UpdateManager() {

        threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //updateApi = RestAdapterManager.getRestApi(UpdateApi.class);
    }

    static {
        updateManager = new UpdateManager();
    }

    public static UpdateManager getInstance() {

        return updateManager;
    }

    public void startDownloads(Context context, String downloadUrl, String fileName, int updateFlag) {
        localPath =context.getExternalCacheDir().getAbsolutePath() + "/sports/update/sports.apk";
        downPath = context.getExternalCacheDir().getAbsolutePath() + "/sports/";
        checkLocalFilePath(downPath+fileName);
        request = new UpdateDownloadRequest(context, downloadUrl, downPath+fileName,2);
        Future<?> future = threadPoolExecutor.submit(request);
    }
    /**
     * 检查文件路径是否存在
     *
     * @param path
     */
    private void checkLocalFilePath(String path) {
        Log.e("tag", path);
        File dir = new File(path);
        /*if(dir.exists()){
            dir.delete();//
        }*/
        if (!dir.getParentFile().exists()) {
            dir.getParentFile().mkdirs();
        }
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isExistApk(Context context) {
        //        File apkFile = new File(localPath);
        //        //如果之前已经下载过就直接安装
        //        if (apkFile.exists()) {
        //            PackageInfo pkgInfo = AppUtils.getPackageInfoByPath(context, apkFile.getPath());
        //            if (pkgInfo != null && pkgInfo.packageName.equals(serviceVerInfo.getPackageName())) {
        //                // 如果包名相同
        //                if (pkgInfo.versionCode == serviceVerInfo.getVersionNo()) {
        //                    // 如果版本号等于最新版本号
        //                    try {
        //                        // 直接跳到安装界面
        //                        Toast.makeText(context, context.getString(R.string.apk_isexits_install_now), Toast
        // .LENGTH_SHORT).show();
        //                        installApkByPath(context, apkFile.getCanonicalPath());
        //                    } catch (Exception e) {
        //                        Toast.makeText(context, context.getString(R.string.install_error), Toast
        // .LENGTH_SHORT).show();
        //                        apkFile.delete();
        //                    }
        //                    return;
        //                }
        //            }
        //        }
        return false;
    }

}
