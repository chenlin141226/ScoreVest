package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.HomeFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class HomeFragmentModule {
    private HomeFragment fragment;

    public HomeFragmentModule(HomeFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    HomeFragmentPresenter provideHomeFragmentPresenter(){
        return new HomeFragmentPresenter(fragment);
    }
}
