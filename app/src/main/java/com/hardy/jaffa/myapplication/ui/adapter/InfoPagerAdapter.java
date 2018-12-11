package com.hardy.jaffa.myapplication.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class InfoPagerAdapter extends FragmentPagerAdapter {

    private List<String> channelNames;
    private List<Fragment> mFragmentList;
    public InfoPagerAdapter(FragmentManager fm, List<String> channelNames, List<Fragment> mFragmentList) {
        super(fm);
        this.channelNames = channelNames;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return channelNames.get(position);
    }
}
