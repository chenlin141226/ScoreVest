package com.hardy.jaffa.myapplication;

import android.app.Application;
import android.content.Context;


/**
 * Created by itheima.
 */

public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
