package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.MidfieldFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.MidfieldFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class MidfielFragmentModule {
    private MidfieldFragment fragment;

    public MidfielFragmentModule(MidfieldFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    MidfieldFragmentPresenter provideMidfieldFragmentPresenter(){
        return new MidfieldFragmentPresenter(fragment);
    }
}
