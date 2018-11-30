package com.hardy.jaffa.myapplication.ui.adapter;


import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hardy.jaffa.myapplication.R;

import java.util.List;

public class HomeRecyclerViewAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;

    public HomeRecyclerViewAdapter(List<MultiItemEntity> data) {
        super(data);
//        addItemType(0, R.layout.head);
//        addItemType(1,R.layout.body);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {

    }

    @Override
    public int getItemCount() {
        int count = 0;
      //  if(){}
        return super.getItemCount();
    }


}
