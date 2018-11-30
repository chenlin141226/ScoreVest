package com.hardy.jaffa.myapplication.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.ZixunInfoDetails;

import java.util.List;

//资讯详情页得RecycleView列表

public class InforDetailsAdapter extends BaseQuickAdapter<ZixunInfoDetails, BaseViewHolder> {
    private Context context;

    public InforDetailsAdapter(Context context, int layoutResId, List<ZixunInfoDetails> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZixunInfoDetails item) {
        String str = item.getSummaryChi().replace("【now.com體育】","");
        helper.setText(R.id.tv_desc,str);
       // helper.setText(R.id.tv_desc, item.getSummaryChi());
        if (item.getNewsPhotos().size()>0){
            Glide.with(context).load(item.getNewsPhotos().get(0).getImageFileUrl()).into((ImageView) helper.getView(R.id.iv_content));
        }else{
            helper.setImageResource(R.id.iv_content,R.drawable.info_iv3);
        }
    }
}
