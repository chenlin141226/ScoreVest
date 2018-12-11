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
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerForwardFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.ForwardFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.module.ForwardFragmentModule;
import com.hardy.jaffa.myapplication.model.PlayerInfo;
import com.hardy.jaffa.myapplication.presenter.fragment.ForwardFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.adapter.ForwardAdapter;
import com.hardy.jaffa.myapplication.ui.dialogs.CheckUpdataDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ForwardFragment extends Fragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;
    private List<PlayerInfo> data;

    @Inject
    ForwardFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerForwardFragmentConponent.Builder builder = DaggerForwardFragmentConponent.builder();
        builder.forwardFragmentModule(new ForwardFragmentModule(this));
        ForwardFragmentConponent conponent = builder.build();
        conponent.in(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forward, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void setData(List<PlayerInfo> data) {
        if(!isAdded())return;
        this.data = data;
        ForwardAdapter mAdapter = new ForwardAdapter(getContext(),R.layout.home_forward_item,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CheckUpdataDialog fragment = new CheckUpdataDialog();
                //fragment.setTargetFragment(this, REQUEST_CODE);
                fragment.show(getChildFragmentManager(), "login");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
