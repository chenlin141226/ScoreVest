package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.activity.LoginActivityPresenter;
import com.hardy.jaffa.myapplication.presenter.activity.RegistActivityPresenter;
import com.hardy.jaffa.myapplication.ui.activity.LoginActivity;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;

import dagger.Module;
import dagger.Provides;

/**
 * HomeFragment业务类创建
 */
@Module
public class LoginActivityModule {
    private LoginActivity activity;

    public LoginActivityModule(LoginActivity activity) {
        this.activity = activity;
    }

    @Provides
    LoginActivityPresenter provideLoginActivityPresenter(){
        return new LoginActivityPresenter(activity);
    }
}
