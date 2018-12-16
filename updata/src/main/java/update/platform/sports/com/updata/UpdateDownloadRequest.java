package update.platform.sports.com.updata;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件下载
 *
 */
public class UpdateDownloadRequest implements Runnable {


    private static final int HANDLER_DOWNLOAD_PROGRESS = 12;
    private static final int HANDLER_DOWNLOAD_FINISH = 13;
    private static final int HANDLER_DOWNLOAD_ERROR = 14;
    private static final int HANDLER_DOWNLOAD_SIZE = 15;
    private static final int HANDLER_DOWNLOAD_STOP = 16;

    private String downloadUrl;
    private String localPath;
    private DownloadDialog downloadDialog;
    private Context context;
    private boolean isCancel;
    private int updateFlag;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //            updating = false;
            switch (msg.what) {
                case HANDLER_DOWNLOAD_SIZE:
                    //                    downloadBar.setMax((int) fileSize);
                    break;
                case HANDLER_DOWNLOAD_PROGRESS:
                    //                    updating = true;
                    // 更新进度
                    int progress = msg.arg1;
                    downloadDialog.setDownloaddialogProgress(progress);
                    downloadDialog.setDownloaddialogCount(progress);
                    if(progress==100){
                        downloadDialog.setPathe(localPath);
                    }
                    break;
                case HANDLER_DOWNLOAD_FINISH:
                    if(updateFlag !=2){
                        downloadDialog.dismiss();
                    }

                    // 下载完成,转到安装界面
                   // ApkUtil.checkMD5(new File(localPath), "");
                   // ApkUtil.installApk(context, localPath);
                    SystemManager.setPermission(localPath);
                    ApkUtil.installNormal(context,localPath);
                    break;
                case HANDLER_DOWNLOAD_STOP:
                    downloadDialog.dismiss();
                    break;
                case HANDLER_DOWNLOAD_ERROR:
                    // 下载发生错误
                    String errMsg = (String) msg.obj;
                    if (errMsg == null && errMsg.length() <= 0) {
                        errMsg = "更新失败！";
                    }
                    Toast.makeText(context, errMsg, Toast.LENGTH_SHORT).show();
                    downloadDialog.dismiss();
                    break;
                default:
                    break;
            }
        }
    };

    public UpdateDownloadRequest(Context context, String downloadUrl, String localPath, int updateFlag) {
        this.context = context;
        this.downloadUrl = downloadUrl;
        this.localPath = localPath;
        this.updateFlag=updateFlag;
        downloadDialog = new DownloadDialog(context, updateFlag);
        downloadDialog.setDownloadDialogListener(new DownloadDialog.IDownloadDialogListener() {
            @Override
            public void onCancel() {
                isCancel = true;
                downloadDialog.dismiss();
            }
        });
        downloadDialog.show();

    }


    public void run() {
        InputStream inStream = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.connect();
            downloadDialog.setOnDismissListener(connection);
            inStream = connection.getInputStream();
            int fileSize = connection.getContentLength();
            if (fileSize > 0) {
                handler.sendEmptyMessage(HANDLER_DOWNLOAD_SIZE);
            } else {
                handler.sendEmptyMessage(HANDLER_DOWNLOAD_ERROR);
                return;
            }

            fos = new FileOutputStream(localPath);
            byte[] buffer = new byte[1024];
            int offset;
            int sum = 0;

            while ((offset = inStream.read(buffer, 0, 1024)) != -1) {
                if (isCancel) {
                    // 暂停退出
                    handler.obtainMessage(HANDLER_DOWNLOAD_STOP).sendToTarget();
                    return;
                }
                fos.write(buffer, 0, offset);
                sum += offset;
                int progress = (int) (((float) sum / fileSize) * 100);
                handler.obtainMessage(HANDLER_DOWNLOAD_PROGRESS, progress,0).sendToTarget();
            }
            if (sum == fileSize) {
                handler.sendEmptyMessage(HANDLER_DOWNLOAD_FINISH);
            } else {
                handler.obtainMessage(HANDLER_DOWNLOAD_ERROR, "文件大小不一致！").sendToTarget();
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (inStream != null) {
                    inStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
