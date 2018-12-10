package com.hardy.jaffa.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void ShowToast(Context context, String msg) {
        if (toast == null) {
            toast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}
