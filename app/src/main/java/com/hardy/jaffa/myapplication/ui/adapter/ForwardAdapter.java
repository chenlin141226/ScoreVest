package com.hardy.jaffa.myapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.utils.Constant;

import java.util.List;

public class ForwardAdapter extends BaseQuickAdapter<PlayerInfo, BaseViewHolder> {
    private Context context;

    public ForwardAdapter(Context context, int layoutResId, List<PlayerInfo> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PlayerInfo item) {
        Glide.with(context).load(Constant.PLAYRT_PHOTO+item.getPlayerId()+Constant.PLAYRT_PHOTO_INFO).into((ImageView) helper.getView(R.id.iv_logo));
        helper.setText(R.id.tv_chineseName, item.getPlayerFullNameChi());
        if(item.getPlayerFullNameEng().length()>15){
        helper.setText(R.id.tv_EnglisgName, item.getPlayerFullNameEng().substring(0,15));
        }else{
            helper.setText(R.id.tv_EnglisgName, item.getPlayerFullNameEng());
        }
        helper.setText(R.id.tv_teanName,"球队:"+item.getTeamFullNameChi());
        helper.setText(R.id.tv_teamNum,"球衣号码: "+item.getPlayerNumber());
        helper.setText(R.id.tv_teamPosition,"位置: "+item.getPositionChi());
        helper.setText(R.id.tv_country,"国籍: "+item.getCountryNameChi());
        helper.setText(R.id.tv_height,"身高: "+item.getHeight());
        helper.setText(R.id.tv_weight,"体重: "+item.getWeight());
    }
}
