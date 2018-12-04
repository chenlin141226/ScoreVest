package com.hardy.jaffa.myapplication.dagger.conponent;


import com.hardy.jaffa.myapplication.dagger.module.GuardFragmentModule;
import com.hardy.jaffa.myapplication.ui.fragment.GuardFragment;

import java.security.Guard;

import dagger.Component;

/**
 * 将创建好的业务对象设置给目标
 */
@Component(modules = GuardFragmentModule.class)
public interface GuardFragmentConponent {
    void in(GuardFragment fragment);
}
