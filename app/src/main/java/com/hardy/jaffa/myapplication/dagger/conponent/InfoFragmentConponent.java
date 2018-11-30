package com.hardy.jaffa.myapplication.dagger.conponent;


import com.hardy.jaffa.myapplication.dagger.module.HomeFragmentModule;
import com.hardy.jaffa.myapplication.dagger.module.InfoFragmentModule;
import com.hardy.jaffa.myapplication.ui.fragment.HomeFragment;
import com.hardy.jaffa.myapplication.ui.fragment.InfoFragment;

import dagger.Component;

/**
 * 将创建好的业务对象设置给目标
 */
@Component(modules = InfoFragmentModule.class)
public interface InfoFragmentConponent {
    void in(InfoFragment fragment);
}
