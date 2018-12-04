package com.hardy.jaffa.myapplication.dagger.conponent;


import com.hardy.jaffa.myapplication.dagger.module.ForwardFragmentModule;
import com.hardy.jaffa.myapplication.dagger.module.MidfielFragmentModule;
import com.hardy.jaffa.myapplication.ui.fragment.ForwardFragment;
import com.hardy.jaffa.myapplication.ui.fragment.MidfieldFragment;

import dagger.Component;

/**
 * 将创建好的业务对象设置给目标
 */
@Component(modules = MidfielFragmentModule.class)
public interface MidfielFragmentConponent {
    void in(MidfieldFragment fragment);
}
