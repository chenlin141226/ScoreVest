package com.hardy.jaffa.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.model.RaceScoreState;
import com.hardy.jaffa.myapplication.ui.adapter.RaceScoreAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotDoorFragment extends Fragment {

    @BindView(R.id.score_recycler_view)
    RecyclerView scoreRecyclerView;
    Unbinder unbinder;

    private List<RaceScoreState> scoreStateList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotdoor, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        scoreRecyclerView.setAdapter(new RaceScoreAdapter(R.layout.score_item, scoreStateList));
        scoreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initData() {
        scoreStateList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            RaceScoreState scoreState = new RaceScoreState();
            scoreState.setRaceTime("08:30");
            scoreState.setRaceRow("意甲第25轮");
            scoreState.setRaceTeamOne("尤文图斯");
            scoreState.setRaceTeamTwo("史帕尔");
            scoreState.setScoreTeamOne("3");
            scoreState.setScoreTeamTwo("1");
            scoreStateList.add(scoreState);
        }
    }
}
