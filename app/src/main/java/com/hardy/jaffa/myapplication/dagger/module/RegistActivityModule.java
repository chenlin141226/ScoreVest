package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.activity.RegistActivityPresenter;
import com.hardy.jaffa.myapplication.presenter.fragment.ForwardFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;
import com.hardy.jaffa.myapplication.ui.fragment.ForwardFragment;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class RegistActivityModule {
    private RegistActivity activity;

    public RegistActivityModule(RegistActivity activity) {
        this.activity = activity;
    }

    @Provides
    RegistActivityPresenter provideRegistActivityPresenter(){
        return new RegistActivityPresenter(activity);
    }
}
