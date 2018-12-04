package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.GuardFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.GuardFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class GuardFragmentModule {

    private GuardFragment fragment;

    public GuardFragmentModule(GuardFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    GuardFragmentPresenter provideGuardFragmentPresenter(){
        return new GuardFragmentPresenter(fragment);
    }
}
