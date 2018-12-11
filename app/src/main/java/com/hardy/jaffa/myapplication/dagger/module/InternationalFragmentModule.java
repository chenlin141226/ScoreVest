package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.InternationalFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.InternationalFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class InternationalFragmentModule {
    private InternationalFragment fragment;

    public InternationalFragmentModule(InternationalFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    InternationalFragmentPresenter provideHotDoorFragmentPresenter() {
        return new InternationalFragmentPresenter(fragment);
    }
}
