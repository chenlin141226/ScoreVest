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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerInternationalFragmentComponent;
import com.hardy.jaffa.myapplication.dagger.conponent.InternationalFragmentComponent;
import com.hardy.jaffa.myapplication.dagger.module.InternationalFragmentModule;
import com.hardy.jaffa.myapplication.model.RaceData;
import com.hardy.jaffa.myapplication.model.RaceScoreState;
import com.hardy.jaffa.myapplication.presenter.fragment.InternationalFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.adapter.RaceScoreAdapter;
import com.hardy.jaffa.myapplication.ui.dialogs.CheckUpdataDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InternationalFragment extends Fragment {
    @BindView(R.id.score_recycler_view)
    RecyclerView scoreRecyclerView;
    Unbinder unbinder;
    @Inject
    InternationalFragmentPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerInternationalFragmentComponent.Builder builder = DaggerInternationalFragmentComponent.builder();
        builder.internationalFragmentModule(new InternationalFragmentModule(this));
        InternationalFragmentComponent component = builder.build();
        component.in(this);
        presenter.getRaceData();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_international, null);
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setData(List<RaceData.DataBean.RaceBean> data) {
        RaceScoreAdapter adapter = new RaceScoreAdapter(getActivity(), R.layout.score_item, data);
        scoreRecyclerView.setAdapter(adapter);
        scoreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CheckUpdataDialog fragment = new CheckUpdataDialog();
                //fragment.setTargetFragment(this, REQUEST_CODE);
                fragment.show(getChildFragmentManager(), "update");
            }
        });
    }
}
