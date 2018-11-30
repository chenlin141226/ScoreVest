package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.HomeFragmentPresenter;
import com.hardy.jaffa.myapplication.presenter.fragment.InfoFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.HomeFragment;
import com.hardy.jaffa.myapplication.ui.fragment.InfoFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class InfoFragmentModule {
    private InfoFragment fragment;

    public InfoFragmentModule(InfoFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    InfoFragmentPresenter provideInfoFragmentPresenter(){
        return new InfoFragmentPresenter(fragment);
    }
}
