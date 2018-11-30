package com.hardy.jaffa.myapplication.model;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hardy.jaffa.myapplication.ui.adapter.HomeRecyclerViewAdapter;

public class MultipleItem implements MultiItemEntity {


    @Override
    public int getItemType() {
        return HomeRecyclerViewAdapter.TYPE_LEVEL_0;
    }
}
