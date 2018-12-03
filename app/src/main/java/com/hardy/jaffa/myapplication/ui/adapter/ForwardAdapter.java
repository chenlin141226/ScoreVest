package com.hardy.jaffa.myapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.PlayerInfo;

import java.util.List;

public class ForwardAdapter extends BaseQuickAdapter<PlayerInfo,BaseViewHolder>{
    private Context context;
    public ForwardAdapter(Context context, int layoutResId, List<PlayerInfo> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PlayerInfo item) {
          //helper.setText(R.id.tv,item);
    }
}
