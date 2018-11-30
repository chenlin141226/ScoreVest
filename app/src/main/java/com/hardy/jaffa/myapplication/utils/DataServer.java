package com.hardy.jaffa.myapplication.utils;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.WheelBean;

import java.util.ArrayList;

public class DataServer {

    public static ArrayList<WheelBean> getWheelData() {
        int[] res = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3};
        String [] des = {"激流涌进","勇往直前","五大联赛"};
        ArrayList<WheelBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            WheelBean bean = new WheelBean();
            bean.setUrl(res[i]);
            bean.setDes(des[i]);
            list.add(bean);
        }
        return list;
    }

}
