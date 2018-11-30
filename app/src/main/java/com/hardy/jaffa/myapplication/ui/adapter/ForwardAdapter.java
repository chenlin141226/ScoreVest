package com.hardy.jaffa.myapplication.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;

import java.util.List;

public class ForwardAdapter extends BaseQuickAdapter<String,BaseViewHolder>{

    public ForwardAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
          helper.setText(R.id.tv,item);
    }
}
