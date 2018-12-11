package com.hardy.jaffa.myapplication.dagger.conponent;

import com.hardy.jaffa.myapplication.dagger.module.InternationalFragmentModule;
import com.hardy.jaffa.myapplication.ui.fragment.InternationalFragment;

import dagger.Component;

@Component(modules = InternationalFragmentModule.class)
public interface InternationalFragmentComponent {
    void in(InternationalFragment fragment);
}
