package update.platform.sports.com.updata;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.HttpURLConnection;


/**
 * 下载进度更新对话框
 *
 */


public class DownloadDialog {
    ProgressBar downloaddialogProgress;
    TextView downloaddialogCount;
    private Dialog trueDialog;
    private IDownloadDialogListener downloadDialogListener;
    private Button btn_refresh;
    private String localPath;
    private Context context;
    public DownloadDialog(final Context context, int updateFlag) {
        this.context=context;
        if (context != null && context instanceof Activity && !((Activity) context).isFinishing()) {
            View view = LayoutInflater.from(context).inflate(R.layout.download_dialog, null);
            downloaddialogProgress = (ProgressBar) view.findViewById(R.id.downloaddialog_progress);
            downloaddialogCount = (TextView) view.findViewById(R.id.downloaddialog_count);
            ImageView downloaddialogClose = (ImageView) view.findViewById(R.id.downloaddialog_close);
            btn_refresh= (Button) view.findViewById(R.id.btn_refresh);
            if(updateFlag == 1 || updateFlag==2){//强制更新不能取消
                downloaddialogClose.setVisibility(View.GONE);
            }else{
                downloaddialogClose.setVisibility(View.VISIBLE);
            }
            downloaddialogClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (downloadDialogListener != null) {
                        downloadDialogListener.onCancel();
                    }
                }
            });
            trueDialog = new Dialog(context, R.style.Dialog);
            trueDialog.setCancelable(true);
            trueDialog.setContentView(view);

            btn_refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!TextUtils.isEmpty(localPath)){
                        SystemManager.setPermission(localPath);
                        ApkUtil.installNormal(context,localPath);
                    }
                }
            });
        }
    }
    public void setPathe(String path){
        localPath=path;
    }
    public void setDownloaddialogProgress(int progress){
        downloaddialogProgress.setProgress(progress);
    }
    public void setDownloaddialogCount(int progress){
        downloaddialogCount.setText(progress + "%");
        if(progress==100){
            btn_refresh.setVisibility(View.VISIBLE);
        }
    }

    public void setOnDismissListener(final HttpURLConnection connection){
        trueDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                connection.disconnect();
            }
        });
    }
    public IDownloadDialogListener getDownloadDialogListener() {
        return downloadDialogListener;
    }

    public void setDownloadDialogListener(IDownloadDialogListener downloadDialogListener) {
        this.downloadDialogListener = downloadDialogListener;
    }

    public void show() {
        if (trueDialog != null) {
            try {
                trueDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dismiss() {
        if (trueDialog != null) {
            try {
                trueDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static interface IDownloadDialogListener {
        void onCancel();
    }

}
