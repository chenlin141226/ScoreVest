package com.hardy.jaffa.myapplication.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.RaceScoreState;

import java.util.List;

public class RaceScoreAdapter extends BaseQuickAdapter<RaceScoreState, BaseViewHolder> {
    public RaceScoreAdapter(int layoutResId, @Nullable List<RaceScoreState> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RaceScoreState item) {
        holder.setText(R.id.race_time, item.getRaceTime());
        holder.setText(R.id.race_row, item.getRaceRow());
        holder.setText(R.id.race_team_one, item.getRaceTeamOne());
        holder.setText(R.id.race_team_two, item.getRaceTeamTwo());
        holder.setText(R.id.score_team_one, item.getScoreTeamOne());
        holder.setText(R.id.score_team_two, item.getScoreTeamTwo());

    }
}
