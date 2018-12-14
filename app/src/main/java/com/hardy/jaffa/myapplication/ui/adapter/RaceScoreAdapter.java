package com.hardy.jaffa.myapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.RaceData;
import com.hardy.jaffa.myapplication.model.RaceScoreState;

import java.util.List;

public class RaceScoreAdapter extends BaseQuickAdapter<RaceData.DataBean.RaceBean, BaseViewHolder> {
    private Context context;

    public RaceScoreAdapter(Context context, int layoutResId, @Nullable List<RaceData.DataBean.RaceBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, RaceData.DataBean.RaceBean item) {
        holder.setText(R.id.race_time, item.getGametime());
        holder.setText(R.id.race_row, item.getLeague() + "第" + item.getRounds() + "轮");
        holder.setText(R.id.race_team_one, item.getHometeam());
        holder.setText(R.id.race_team_two, item.getAwayteam());
        holder.setText(R.id.score, item.getScore());
        holder.setText(R.id.race_status, item.getStatus());
        Glide.with(context).load(item.getHometeamlogo()).fitCenter().into((ImageView) holder.getView(R.id.team_one_logo));
        Glide.with(context).load(item.getAwayteamlogo()).fitCenter().into((ImageView) holder.getView(R.id.team_two_logo));

    }
}
