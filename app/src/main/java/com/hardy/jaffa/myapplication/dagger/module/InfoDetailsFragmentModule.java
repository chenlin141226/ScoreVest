package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.InfoDetailsFragmentPresenter;
import com.hardy.jaffa.myapplication.presenter.fragment.InfoFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.InfoDetailsFragment;
import com.hardy.jaffa.myapplication.ui.fragment.InfoFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class InfoDetailsFragmentModule {
    private InfoDetailsFragment fragment;

    public InfoDetailsFragmentModule(InfoDetailsFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    InfoDetailsFragmentPresenter provideInfoDetailsFragmentPresenter(){
        return new InfoDetailsFragmentPresenter(fragment);
    }
}
