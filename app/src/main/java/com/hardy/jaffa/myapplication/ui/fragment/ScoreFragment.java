package com.hardy.jaffa.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.ui.adapter.ScoreAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ScoreFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;


    Unbinder unbinder;
    private ArrayList<Fragment> mListFragment;//viewpager中得fragment
    private String[] tabs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        tvTitle.setText("比赛");
        ScoreAdapter mPagerAdapter = new ScoreAdapter(getChildFragmentManager(),mListFragment);
        mViewPager.setAdapter(mPagerAdapter);
        mPagerAdapter.setTitles(tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        tabs = new String[]{"热门", "关注"};
        mListFragment = new ArrayList<>();
        mListFragment.add(new HotDoorFragment());
        mListFragment.add(new InternationalFragment());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
