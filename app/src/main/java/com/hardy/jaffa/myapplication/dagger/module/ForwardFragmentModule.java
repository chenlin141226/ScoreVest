package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.ForwardFragmentPresenter;
import com.hardy.jaffa.myapplication.presenter.fragment.HomeFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.ForwardFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class ForwardFragmentModule {
    private ForwardFragment fragment;

    public ForwardFragmentModule(ForwardFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    ForwardFragmentPresenter provideForwardFragmentPresenter(){
        return new ForwardFragmentPresenter(fragment);
    }
}
