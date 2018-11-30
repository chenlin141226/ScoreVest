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
import android.widget.TextView;

import com.hardy.jaffa.myapplication.R;
import com.hardy.jaffa.myapplication.dagger.conponent.DaggerInfoDetailsFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.conponent.InfoDetailsFragmentConponent;
import com.hardy.jaffa.myapplication.dagger.module.InfoDetailsFragmentModule;
import com.hardy.jaffa.myapplication.model.ZixunInfoDetails;
import com.hardy.jaffa.myapplication.presenter.fragment.InfoDetailsFragmentPresenter;
import com.hardy.jaffa.myapplication.ui.adapter.InforDetailsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InfoDetailsFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private String keyword;


    @Inject
    InfoDetailsFragmentPresenter presenter;
    private List<ZixunInfoDetails> data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerInfoDetailsFragmentConponent.Builder builder = DaggerInfoDetailsFragmentConponent.builder();
        builder.infoDetailsFragmentModule(new InfoDetailsFragmentModule(this));
        InfoDetailsFragmentConponent conponent = builder.build();
        conponent.in(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_detailss, null);
        unbinder = ButterKnife.bind(this, view);
        if (getArguments() != null) {
            keyword = getArguments().getString("keyword");
        }
        return view;
    }


    //设置详情页数据
    public void setData(List<ZixunInfoDetails> data) {
        this.data = data;
        InforDetailsAdapter adapter = new InforDetailsAdapter(getContext(),R.layout.infor_details_item,data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (keyword != null) {
            presenter.getData(keyword);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
