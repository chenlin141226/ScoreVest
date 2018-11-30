package com.hardy.jaffa.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerHomeFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.HomeFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.module.HomeFragmentModule;
import com.hardy.jaffa.myapplication.presenter.fragment.HomeFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.adapter.MyPagerAdapter;
import com.hardy.jaffa.myapplication.utils.DataServer;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.appBarlayout)
    AppBarLayout appBarlayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.slider)
    SliderLayout sliderLayout;

    @Inject
    HomeFragmentPresenter presenter;
    Unbinder unbinder;
    private MyPagerAdapter mPagerAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeFragmentConponent.Builder builder = DaggerHomeFragmentConponent.builder();
        builder.homeFragmentModule(new HomeFragmentModule(this));
        HomeFragmentConponent conponent = builder.build();
        conponent.in(this);
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private ArrayList<String> urls = new ArrayList<>();
    private void initView() {
        sliderLayout.removeAllSliders();
        //轮播图
        for (int i = 0; i < DataServer.getWheelData().size(); i++) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView.image(DataServer.getWheelData().get(i).getUrl());
            textSliderView.description(DataServer.getWheelData().get(i).getDes());
            sliderLayout.addSlider(textSliderView);
        }

    }

    private void initData() {
        String[] titles = {"前锋", "中场", "后卫门将"};
        ArrayList<Fragment> mListFragment = new ArrayList<>();
        mListFragment.add(new ForwardFragment());
        mListFragment.add(new MidfieldFragment());
        mListFragment.add(new GuardFragment());
        mPagerAdapter = new MyPagerAdapter(getChildFragmentManager(),mListFragment);
        viewPager.setAdapter(mPagerAdapter);
        mPagerAdapter.setTitles(titles);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
