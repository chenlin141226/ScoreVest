package com.hardy.jaffa.myapplication.dagger.module;

import com.hardy.jaffa.myapplication.presenter.fragment.HotDoorFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.fragment.HotDoorFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class HotDoorFragmentModule {
    private HotDoorFragment hotDoorFragment;

    public HotDoorFragmentModule(HotDoorFragment hotDoorFragment) {
        this.hotDoorFragment = hotDoorFragment;
    }

    @Provides
    HotDoorFragmentPresenter provideHotDoorFragmentPresenter() {
        return new HotDoorFragmentPresenter(hotDoorFragment);
    }
}
