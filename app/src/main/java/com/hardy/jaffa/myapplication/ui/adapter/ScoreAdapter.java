package com.hardy.jaffa.myapplication.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

//比分界面得Adapter
public class ScoreAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private ArrayList<Fragment> mListFragment;

    public ScoreAdapter(FragmentManager fm, ArrayList<Fragment> mListFragment) {
        super(fm);
        this.mListFragment = mListFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }
}
