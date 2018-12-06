package com.hardy.jaffa.myapplication.dagger.conponent;


import com.hardy.jaffa.myapplication.dagger.module.LoginActivityModule;
import com.hardy.jaffa.myapplication.dagger.module.RegistActivityModule;
import com.hardy.jaffa.myapplication.ui.activity.LoginActivity;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;

import dagger.Component;

/**
 * 将创建好的业务对象设置给目标
 */
@Component(modules = LoginActivityModule.class)
public interface LoginActivityConponent {
    void in(LoginActivity activity);
}
