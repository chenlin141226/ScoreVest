package com.hardy.jaffa.myapplication.dagger.conponent;

import com.hardy.jaffa.myapplication.dagger.module.HotDoorFragmentModule;
import com.hardy.jaffa.myapplication.ui.fragment.HotDoorFragment;

import dagger.Component;

@Component(modules = HotDoorFragmentModule.class)
public interface HotDoorFragmentComponent {
    void in(HotDoorFragment fragment);
}
