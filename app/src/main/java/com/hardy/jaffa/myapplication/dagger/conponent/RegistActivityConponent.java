package com.hardy.jaffa.myapplication.dagger.conponent;


import com.hardy.jaffa.myapplication.dagger.module.ForwardFragmentModule;
import com.hardy.jaffa.myapplication.dagger.module.RegistActivityModule;
import com.hardy.jaffa.myapplication.ui.activity.RegistActivity;
import com.hardy.jaffa.myapplication.ui.fragment.ForwardFragment;

import dagger.Component;

/**
 * 将创建好的业务对象设置给目标
 */
@Component(modules = RegistActivityModule.class)
public interface RegistActivityConponent {
    void in(RegistActivity activity);
}
